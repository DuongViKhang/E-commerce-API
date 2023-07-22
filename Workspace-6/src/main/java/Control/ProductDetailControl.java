package Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import DAO.StoreDAO;
import Model.Product;

/**
 * Servlet implementation class ProductDetailControl
 */
@WebServlet("/ProductDetailControl")
public class ProductDetailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		StoreDAO storeDAO = new StoreDAO();
		
		int id = Integer.parseInt(req.getParameter("id"));
		Product product = productDAO.getProductById(id);
		String store = storeDAO.getStoreById(product.getStoreId()).getStoreName();
		
		req.setAttribute("product", product);
		req.setAttribute("store", store);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/shop/productDetail.jsp");
		dispatcher.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String quantity = req.getParameter("quantity");
		req.setAttribute("id", id);
		req.setAttribute("quantity", quantity);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/PaymentControl");
		dispatcher.forward(req, resp);
	}

}
