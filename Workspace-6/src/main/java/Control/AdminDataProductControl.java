package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import DAO.StoreDAO;
import Model.Category;
import Model.Product;
import Model.Store;

/**
 * Servlet implementation class AdminDataProductControl
 */
@WebServlet("/admin/dataproduct")
public class AdminDataProductControl extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public AdminDataProductControl() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			ProductDAO pr = new ProductDAO();
			List<Product> listp = pr.getAllProduct();
			
			CategoryDAO ca = new CategoryDAO();
			List<Category> listc = ca.getAllCategory();
			
			StoreDAO st = new StoreDAO();
			List<Store> lists = st.getAllStore();
			
			request.setAttribute("listp", listp);
			request.setAttribute("listc", listc);
			request.setAttribute("lists", lists);
			request.setAttribute("size", listp.size());
			
			request.getRequestDispatcher("./admin_dataproduct.jsp").forward(request, response);
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

}
