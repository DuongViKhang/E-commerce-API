package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StoreDAO;
import DAO.TransactionDAO;
import DAO.UserDAO;
import Model.Store;
import Model.Transactions;
import Model.Users;

/**
 * Servlet implementation class AdminDataTransaction
 */
@WebServlet("/admin/transaction")
public class AdminDataTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDataTransaction() {
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
        
        TransactionDAO trans = new TransactionDAO();
        
        List<Transactions> listtr = trans.getAllTransaction();
        
        UserDAO user = new UserDAO();
        List<Users> listu = user.getAllUser();
        request.setAttribute("listu", listu);
        
        StoreDAO store = new StoreDAO();
        List<Store> lists = store.getAllStore();
        request.setAttribute("lists", lists);
        
        request.setAttribute("listtr", listtr);
        request.setAttribute("size", listtr.size());
        request.getRequestDispatcher("./admin_transaction.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
