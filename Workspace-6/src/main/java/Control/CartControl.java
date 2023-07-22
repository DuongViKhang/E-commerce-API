package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CartDAO;
import DAO.CartItemDAO;
import DAO.ProductDAO;
import Model.CartItem;
import Model.Product;
import Model.Users;

/**
 * Servlet implementation class CartControl
 */
@WebServlet("/CartControl")
public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CartItemDAO cartItemDAO = new CartItemDAO();
		CartDAO cartDAO = new CartDAO();
		ProductDAO productDAO = new ProductDAO();
		HttpSession session = req.getSession();
		int userId = ((Users)session.getAttribute("user")).getUserId();
		int cardId = cartDAO.CheckCartId(userId).getCartId();
		List<CartItem> list = cartItemDAO.getAllCartItem(cardId);
		List<Product> listp = new ArrayList<>();
		List<String> total = new ArrayList<>();
		int totalCart = 0;
		for(CartItem o : list) {
			Product item = productDAO.getProductById(o.getProductId());
			listp.add(item);
			totalCart += o.getCount() * item.getPromotionalPrice();
			total.add(Integer.toString(o.getCount() * item.getPromotionalPrice()));
		}
		req.setAttribute("list", list);
		req.setAttribute("listp", listp);
		req.setAttribute("total", total);
		req.setAttribute("totalCart", totalCart);
		req.setAttribute("sizec", list.size() - 1);
		req.getRequestDispatcher("shop/cart.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
