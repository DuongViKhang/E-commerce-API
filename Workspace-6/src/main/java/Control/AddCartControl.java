package Control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CartDAO;
import DAO.CartItemDAO;
import Model.Users;

/**
 * Servlet implementation class AddCartControl
 */
@WebServlet("/AddCartControl")
public class AddCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		CartDAO cartDAO = new CartDAO();
		CartItemDAO cartItemDAO = new CartItemDAO();
		HttpSession session = req.getSession();
		int cartId = cartDAO.CheckCartId(((Users)session.getAttribute("user")).getUserId()).getCartId();
		Date now = new Date(System.currentTimeMillis());
		cartItemDAO.AddCartItem(cartId, id, quantity, now, 0);
		resp.sendRedirect("http://localhost:8080/Shopee/CartControl");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
