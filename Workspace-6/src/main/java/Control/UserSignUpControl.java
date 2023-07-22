package Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CartDAO;
import DAO.UserDAO;
import Model.Users;

/**
 * Servlet implementation class UserSignUpControl
 */
@WebServlet("/shop/signup")
public class UserSignUpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignUpControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/shop/signup.jsp").forward(request, response);
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
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String idCard = request.getParameter("idCard");
        String password = request.getParameter("password");
       
        UserDAO userDAO = new UserDAO();
        Users a = userDAO.checkAccountExist(username, phone, email, idCard, password);
        if (a == null) {
        	CartDAO cartDAO = new CartDAO();
        	Date now = new Date(System.currentTimeMillis());
        	Users user = new Users(username, idCard, email, phone, 1, password, 3, null, null, now, 0);
        	userDAO.Create(user);
        	response.sendRedirect("http://localhost:8080/Shopee/shop/login");
        }
        else {
        	response.sendRedirect("http://localhost:8080/Shopee/home");
        }
        
	}

}
