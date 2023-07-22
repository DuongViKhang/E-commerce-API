package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import DAO.StoreDAO;
import Model.Category;
import Model.Product;
import Model.Store;
import Model.Users;

/**
 * Servlet implementation class SellerProductControl
 */
@WebServlet("/seller/sellerproduct")
public class SellerProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerProductControl() {
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
        
        HttpSession session = request.getSession();
        
        String userid = session.getAttribute("sellerid").toString();
        int id = Integer.parseInt(userid);
        
        StoreDAO store = new StoreDAO();
        
        Store st = store.CheckStoreByUserId(id);
        
        ProductDAO pr = new ProductDAO();
        List<Product> listp = pr.getAllProductByStore(st.getStoreId());
        
        CategoryDAO cate = new CategoryDAO();
        List<Category> listc = cate.getAllCategory();
        
        request.setAttribute("listp", listp);
        request.setAttribute("size", listp.size());
        request.setAttribute("listc", listc);
		
		request.getRequestDispatcher("/seller/sellerdataproduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}