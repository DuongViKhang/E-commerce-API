package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import DAO.StoreDAO;
import DAO.TransactionDAO;
import DAO.UserDAO;
import Model.Product;
import Model.Store;
import Model.Transactions;
import Model.Users;

/**
 * Servlet implementation class AdminControl
 */
@WebServlet("/admin")
public class AdminControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminControl() {
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
        
        UserDAO user = new UserDAO();
        StoreDAO store = new StoreDAO();
        TransactionDAO trans = new TransactionDAO();
        ProductDAO product = new ProductDAO();
        
        List<Users> listu = user.getAllUser();
        List<Store> lists = store.getAllStore();
        List<Transactions> listtr = trans.getAllTransaction();
        List<Product> listp = product.getAllProduct();
        
        request.setAttribute("countuser", listu.size());
        request.setAttribute("countstore", lists.size());
        request.setAttribute("counttrans", listtr.size());
        request.setAttribute("countproduct", listp.size());
        
        HttpSession session = request.getSession();
        
        if (session.getAttribute("admin") == null) {
        	request.getRequestDispatcher("./admin/adminlogin.jsp").forward(request, response);
        }
        else {
        	request.getRequestDispatcher("./admin/admin.jsp").forward(request, response);
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
