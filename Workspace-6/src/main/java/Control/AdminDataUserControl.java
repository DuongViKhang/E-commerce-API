package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RolesDAO;
import DAO.UserDAO;
import Model.Roles;
import Model.Users;

/**
 * Servlet implementation class AdminDataUserControl
 */
@WebServlet("/admin/datauser")
public class AdminDataUserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDataUserControl() {
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
		RolesDAO role = new RolesDAO();
		
		List<Users> list = user.getAllUser();
		List<Roles> listr = role.getAllRoles();
		
		request.setAttribute("listu", list);
		request.setAttribute("listr", listr);
		request.setAttribute("size", list.size());
		
		request.getRequestDispatcher("./admin_datauser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/admin/datauser");
	}

}
