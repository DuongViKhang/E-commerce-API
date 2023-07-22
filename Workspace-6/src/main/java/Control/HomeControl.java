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
 * Servlet implementation class HomeControl
 */
@WebServlet("/home")
public class HomeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeControl() {
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
		if(session.getAttribute("user") != null) {
			int userId = ((Users)session.getAttribute("user")).getUserId();
			int cardId = cartDAO.CheckCartId(userId).getCartId();
			List<CartItem> listc = cartItemDAO.getAllCartItem(cardId);
			List<Product> listp = new ArrayList<>();
			List<String> totalc = new ArrayList<>();
			for(CartItem o : listc) {
				Product item = productDAO.getProductById(o.getProductId());
				listp.add(item);
				totalc.add(Integer.toString(o.getCount() * item.getPromotionalPrice()));
			}
			req.setAttribute("listc", listc);
			req.setAttribute("listp", listp);
			req.setAttribute("totalc", totalc);
			req.setAttribute("sizec", listc.size() - 1);
		}
		
		String index = req.getParameter("index");
		if(index == null) {
			index = "1";
		}
		int indexPage = Integer.parseInt(index);
		List<Product> list = productDAO.pagingProduct(indexPage);
		int size = list.size();
		int numberPage = productDAO.getNumberPage();
		req.setAttribute("list", list);
		req.setAttribute("size", size-1);
		req.setAttribute("numberPage", numberPage);
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("home.jsp");
	}

}
