 package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StoreDAO;
import DAO.UserDAO;
import Model.Store;
import Model.Users;

/**
 * Servlet implementation class SellerLoginControl
 */
@WebServlet("/sellerlogin")
public class SellerLoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerLoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/seller/sellerlogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        String username = request.getParameter("username");
        String pass = request.getParameter("password");

        UserDAO seller = new UserDAO();
        
        Users a = seller.CheckUserByEmail(username, pass);
        Users b = seller.CheckUserByPhone(username, pass);
        
        if(a != null || b != null) {
        	HttpSession session = request.getSession();
        	if(a==null) {
        		session.setAttribute("seller", b);
        		session.setAttribute("sellerid", b.getUserId());
        		
        		StoreDAO store = new StoreDAO();
        		Store st = store.CheckStoreByUserId(b.getRoleId());
        		session.setAttribute("store", st);
        	}
        	else {
        		session.setAttribute("seller", a);
        		session.setAttribute("sellerid", a.getUserId());
        		
        		StoreDAO store = new StoreDAO();
        		Store st = store.CheckStoreByUserId(a.getRoleId());
        		session.setAttribute("store", st);
        	}
        	response.sendRedirect("http://localhost:8080/Shopee/seller");
        }
        else {
        	request.setAttribute("mess", "Sai tên đăng nhập hoặc mật khẩu");
        	request.getRequestDispatcher("/seller/sellerlogin.jsp").forward(request, response);
        }
	}

}
