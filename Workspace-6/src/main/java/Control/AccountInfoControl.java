package Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CartDAO;
import DAO.CartItemDAO;
import DAO.ProductDAO;
import DAO.UserDAO;
import Model.CartItem;
import Model.Product;
import Model.Users;

/**
 * Servlet implementation class AccountInfoControl
 */
@WebServlet("/AccountInfoControl")
public class AccountInfoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountInfoControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Users user = (Users)session.getAttribute("user");
		
		CartItemDAO cartItemDAO = new CartItemDAO();
		CartDAO cartDAO = new CartDAO();
		ProductDAO productDAO = new ProductDAO();
		int userId = ((Users)session.getAttribute("user")).getUserId();
		int cardId = cartDAO.CheckCartId(userId).getCartId();
		List<CartItem> listc = cartItemDAO.getAllCartItem(cardId);
		List<Product> listp = new ArrayList<>();
		List<String> total = new ArrayList<>();
		int totalCart = 0;
		for(CartItem o : listc) {
			Product item = productDAO.getProductById(o.getProductId());
			listp.add(item);
			totalCart += o.getCount() * item.getPromotionalPrice();
			total.add(Integer.toString(o.getCount() * item.getPromotionalPrice()));
		}
		req.setAttribute("list", listc);
		req.setAttribute("listp", listp);
		req.setAttribute("total", total);
		req.setAttribute("totalCart", totalCart);
		req.setAttribute("sizec", listc.size() - 1);
		
		req.setAttribute("user", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/shop/accountInfo.jsp");
		dispatcher.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		HttpSession session = req.getSession();
		int id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
		username = new String(bytes, StandardCharsets.UTF_8);
		String idCard = req.getParameter("idCard");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		int isEmailActive = Integer.parseInt(req.getParameter("isEmailActive"));
		String password = req.getParameter("password");
		int roleId = 3;
		String address = req.getParameter("address");
		bytes = address.getBytes(StandardCharsets.ISO_8859_1);
		address = new String(bytes, StandardCharsets.UTF_8);
		String avatar = req.getParameter("avatar");
		if(avatar == "") {
			avatar = ((Users)session.getAttribute("user")).getAvatar();
		}
		Date date = Date.valueOf(req.getParameter("date"));
		int isDeleted = Integer.parseInt(req.getParameter("isDeleted"));
		Users user = new Users(id, username, idCard, email, phone, isEmailActive, password, roleId, address, avatar, date, isDeleted);
    	session.setAttribute("user", user);
		dao.Update(user);
		resp.sendRedirect("http://localhost:8080/Shopee/home");
	}

}
