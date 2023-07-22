package Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.OrderItemDAO;
import DAO.OrdersDAO;
import DAO.UserDAO;
import Model.OrderItem;
import Model.Orders;
import Model.Users;

/**
 * Servlet implementation class SellerDataOrderControl
 */
@WebServlet("/seller/dataorder")
public class SellerDataOrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerDataOrderControl() {
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
        
        String a = request.getParameter("id");
        int id = Integer.parseInt(a);
        
        OrdersDAO order = new OrdersDAO();
        List<Orders> listo = order.getAllOrders(id);
        
        //System.out.print(listo);
        
        OrderItemDAO item = new OrderItemDAO();
        List<OrderItem> listot = item.getAllOrderItem();
        
        UserDAO user = new UserDAO();
        List<Users> listu = user.getAllUser();
        
//        PrintWriter out = response.getWriter();
//        out.println(id);
//        out.println(listo.size());
//        out.print(listot);
        request.setAttribute("listo", listo);
        request.setAttribute("listu", listu);
        request.setAttribute("size", listo.size());
        request.setAttribute("listot", listot);
        request.getRequestDispatcher("/seller/sellerdataorder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
