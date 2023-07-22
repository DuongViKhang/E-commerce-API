package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.OrderItemDAO;
import DAO.OrdersDAO;
import DAO.ProductDAO;
import Model.OrderItem;
import Model.Orders;
import Model.Product;

/**
 * Servlet implementation class InvoiceControl
 */
@WebServlet("/seller/InvoiceControl")
public class InvoiceControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvoiceControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        String a = request.getParameter("OId");
        int id = Integer.parseInt(a);
        
        OrderItemDAO orderitem = new OrderItemDAO();
        
        List<OrderItem> listoit = orderitem.getAllOrderItemById(id);
        
        OrdersDAO order = new OrdersDAO();
        
        Orders o = order.CheckOrderById(id);
        
        ProductDAO product = new ProductDAO();
        List<Product> listp = product.getAllProduct();
        
//        System.out.print(listp);
//        System.out.print(listoit);
        
        HttpSession session = request.getSession();
        
        session.setAttribute("listoit", listoit);
        session.setAttribute("listp", listp);
        session.setAttribute("id", id);
        session.setAttribute("Sid", o.getStatusId());
        session.setAttribute("size", listoit.size());
        session.setAttribute("size2", listp.size());
        
        request.getRequestDispatcher("/seller/sellerinvoice.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}