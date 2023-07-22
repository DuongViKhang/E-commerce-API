package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StoreDAO;
import Model.Store;

/**
 * Servlet implementation class SellerControl
 */
@WebServlet("/seller")
public class SellerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        HttpSession session = request.getSession();
        
        
        if (session.getAttribute("seller") == null) {
        	request.getRequestDispatcher("./seller/sellerlogin.jsp").forward(request, response);
        }
        else {
        	String userid = session.getAttribute("sellerid").toString();
            int id = Integer.parseInt(userid);
            
            StoreDAO st = new StoreDAO();
            Store a = st.CheckStoreByUserId(id);
            
            request.setAttribute("id", a.getStoreId());
        	request.getRequestDispatcher("./seller/seller.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
