package Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paypal.api.payments.Transaction;

import DAO.OrderItemDAO;
import DAO.OrdersDAO;
import DAO.ProductDAO;
import DAO.TransactionDAO;
import DAO.UserDAO;
import Model.OrderItem;
import Model.Orders;
import Model.Product;
import Model.Users;

/**
 * Servlet implementation class PaymentControl
 */
@WebServlet("/PaymentControl")
public class PaymentControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrdersDAO orderDAO = new OrdersDAO();
		OrderItemDAO orderItemDAO = new OrderItemDAO();
		
		int userId = Integer.parseInt(req.getParameter("UserId"));
		int storeId = Integer.parseInt(req.getParameter("StoreId"));
		String address = req.getParameter("Address");
		String phone = req.getParameter("Phone");
		String email = req.getParameter("Email");
		Date now = new Date(System.currentTimeMillis());
		int productId = Integer.parseInt(req.getParameter("ProductId"));
		int count = Integer.parseInt(req.getParameter("Count"));
		int total = Integer.parseInt(req.getParameter("Total"));
		Orders order = new Orders(userId, storeId, 1, address, phone, 1, 0, total, 0, 0, 0, email, now, 0);
		orderDAO.AddOrder(order);
		int orderId = orderDAO.findNewOrderId(order);
		OrderItem orderItem = new OrderItem(orderId, productId, count);
		orderItemDAO.AddOrder(orderItem);
		
		TransactionDAO trans = new TransactionDAO();
		trans.addTransaction(userId, storeId, total);
		resp.sendRedirect("http://localhost:8080/Shopee/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		int id = Integer.parseInt(req.getParameter("id"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		Product product = productDAO.getProductById(id);
		if(req.getParameter("action").equals("Mua")) {
			req.setAttribute("id", id);
			req.setAttribute("storeId", product.getStoreId());
			req.setAttribute("product", product);
			req.setAttribute("quantity", quantity);
			req.setAttribute("total", product.getPromotionalPrice() * quantity);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/shop/payment.jsp");
			dispatcher.forward(req, resp);
		}
		else{
			resp.sendRedirect("http://localhost:8080/Shopee/AddCartControl?id=" + id +"&quantity=" + quantity);
		}
	}

}
