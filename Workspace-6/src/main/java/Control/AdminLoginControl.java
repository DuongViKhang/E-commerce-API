package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import Model.Users;

/**
 * Servlet implementation class AdminLoginControl
 */
@WebServlet("/adminlogin")
public class AdminLoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/admin/adminlogin.jsp").forward(request, response);
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

        UserDAO admin = new UserDAO();
        
        Users a = admin.CheckUserByEmail(username, pass);
        Users b = admin.CheckUserByPhone(username, pass);
        
        if(a != null || b != null) {
        	HttpSession session = request.getSession();
        	if(a==null) {
        		session.setAttribute("admin", b);
        	}
        	else {
        		session.setAttribute("admin", a);
        	}
        	response.sendRedirect("http://localhost:8080/Shopee/admin");
        }
        else {
        	request.setAttribute("mess", "Sai tên đăng nhập hoặc mật khẩu");
        	request.getRequestDispatcher("/admin/adminlogin.jsp").forward(request, response);
        }
	}

}
