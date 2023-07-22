package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StoreDAO;
import DAO.UserDAO;
import Model.Store;
import Model.Users;

/**
 * Servlet implementation class AdminDataSellerControl
 */
@WebServlet("/admin/dataseller")
public class AdminDataSellerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDataSellerControl() {
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
        
		StoreDAO store = new StoreDAO();
		UserDAO user = new UserDAO();
		
		List<Store> list = store.getAllStore();
		List<Users> listu = user.getAllUser();
		
		request.setAttribute("list", list);
		request.setAttribute("listu", listu);
		request.setAttribute("size", list.size());
		request.getRequestDispatcher("./admin_dataseller.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/admin/dataseller");
	}

}
