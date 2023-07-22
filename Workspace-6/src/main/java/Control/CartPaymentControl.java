package Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
import DAO.OrderItemDAO;
import DAO.OrdersDAO;
import DAO.ProductDAO;
import DAO.StoreDAO;
import DAO.TransactionDAO;
import DAO.UserDAO;
import Model.CartItem;
import Model.OrderItem;
import Model.Orders;
import Model.Product;
import Model.Store;
import Model.Users;

/**
 * Servlet implementation class CartPaymentControl
 */
@WebServlet("/CartPaymentControl")
public class CartPaymentControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartPaymentControl() {
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
		for(CartItem o : list) {
			Product item = productDAO.getProductById(o.getProductId());
			listp.add(item);
			total.add(Integer.toString(o.getCount() * item.getPromotionalPrice()));
		}
		UserDAO userDAO = new UserDAO();
		StoreDAO storeDAO = new StoreDAO();
		OrdersDAO orderDAO = new OrdersDAO();
		OrderItemDAO orderItemDAO = new OrderItemDAO();
		Users user = userDAO.getAllUserById(userId).get(0);
		Date now = new Date(System.currentTimeMillis());
		for(int i = 0; i < list.size(); i++) {
			Store store = storeDAO.getStoreById(listp.get(i).getStoreId());
			Orders order = new Orders(userId, store.getStoreId(), 1, user.getAddress(), user.getPhone(), 1, 0, Integer.parseInt(total.get(i)), 0, 0, 0, user.getEmail(), now, 0);
			orderDAO.AddOrder(order);
			int orderId = orderDAO.findNewOrderId(order);
			OrderItem orderItem = new OrderItem(orderId, listp.get(i).getProductId(), list.get(i).getCount());
			orderItemDAO.AddOrder(orderItem);
			TransactionDAO trans = new TransactionDAO();
			trans.addTransaction(userId, store.getStoreId(), Integer.parseInt(total.get(i)));
			cartItemDAO.UpdateCartItem(list.get(i).getCartItemId());
		}
		resp.sendRedirect("http://localhost:8080/Shopee/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
