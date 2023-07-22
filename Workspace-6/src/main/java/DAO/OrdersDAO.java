package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.Cart;
import Model.Delivery;
import Model.Orders;
import Model.StatusOrder;
import Model.Store;
import Model.Users;

public class OrdersDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Orders CheckOrderById(int id) {
    	String query = "select * from Orders\r\n"
                + "where OrderId = ? and IsDeleted = '0'";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Orders(rs.getInt(1),
    					rs.getInt(2),
    					rs.getInt(3),
    					rs.getInt(4),
    					rs.getString(5),
    					rs.getString(6),
    					rs.getInt(7),
    					rs.getInt(8),
    					rs.getInt(9),
    					rs.getInt(10),
    					rs.getInt(11),
    					rs.getInt(12),
    					rs.getString(13),
    					rs.getDate(14),
    					rs.getInt(15));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    	return null;
    }
    
    public List<Orders> getAllOrders(int id){
    	List<Orders> list = new ArrayList<>();
    	String query = "select * from Orders where IsDeleted = '0' and StoreId=?";
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		ps.setInt(1, id);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			list.add(new Orders(rs.getInt(1),
    					rs.getInt(2),
    					rs.getInt(3),
    					rs.getInt(4),
    					rs.getString(5),
    					rs.getString(6),
    					rs.getInt(7),
    					rs.getInt(8),
    					rs.getInt(9),
    					rs.getInt(10),
    					rs.getInt(11),
    					rs.getInt(12),
    					rs.getString(13),
    					rs.getDate(14),
    					rs.getInt(15)));
    		}
    	} catch (Exception e) {
    		
        }
    	return list;
    }
    
    public void AddOrder(Orders order) {
    	LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        String query ="Insert into Orders Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, order.getUserId());
            ps.setInt(2, order.getStoreId());
            ps.setInt(3, order.getDeliveryId());
            ps.setString(4, order.getAddress());
            ps.setString(5, order.getPhone());
            ps.setInt(6, order.getStatusId());
            ps.setInt(7, order.getIsPay());
            ps.setInt(8, order.getAmountFromUser());
            ps.setInt(9, order.getAmountFromStore());
            ps.setInt(10, order.getAmountToStore());
            ps.setInt(11, order.getAmountToGD());
            ps.setString(12, order.getEmail());
            ps.setDate(13, order.getDate());
            ps.setInt(14, order.getIsDeleted());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void updateOrder(int id) {
    	LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        String query = "Update Orders\r\n"
        		+ "Set StatusId='2'\r\n"
        		+ "where OrderId = ?;";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
	}
    
    public int findNewOrderId(Orders order) {
    	String query ="select top 1 *\r\n"
    			+ "from Orders\r\n"
    			+ "where UserId = ? and StoreId = ? and DeliveryId = ? \r\n"
    			+ "  and Address = ? and Phone = ? \r\n"
    			+ "  and StatusId = ? and IsPay = ?\r\n"
    			+ "  and AmountFromUser = ? and AmountFromStore = ?\r\n"
    			+ "  and AmountToStore = ? and AmountToGD = ?\r\n"
    			+ "  and Email = ? and Date = ?\r\n"
    			+ "  and IsDeleted = ?\r\n"
    			+ "order by OrderId desc";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, order.getUserId());
            ps.setInt(2, order.getStoreId());
            ps.setInt(3, order.getDeliveryId());
            ps.setString(4, order.getAddress());
            ps.setString(5, order.getPhone());
            ps.setInt(6, order.getStatusId());
            ps.setInt(7, order.getIsPay());
            ps.setInt(8, order.getAmountFromUser());
            ps.setInt(9, order.getAmountFromStore());
            ps.setInt(10, order.getAmountToStore());
            ps.setInt(11, order.getAmountToGD());
            ps.setString(12, order.getEmail());
            ps.setDate(13, order.getDate());
            ps.setInt(14, order.getIsDeleted());
            rs = ps.executeQuery();
            while (rs.next()) {
            	return rs.getInt(1);
            }
        } catch (Exception e) {
        }
    	return 0;
    }
    public static void main(String[] agrc) {
    	/*OrdersDAO dao = new OrdersDAO();
    	Orders o = new Orders(4, 1, 1, "Viet Nam", "099999922", 2, 1, 0, 0, 0, 0, "khang@gmail.com", java.sql.Date.valueOf("2022-12-16"), 0);
    	try {
    		dao.AddOrder(o);
    		System.out.println("Thêm thành công!");
    	}
    	catch (Exception e) {
    		
    	}*/
		/*
		 * OrdersDAO dao = new OrdersDAO(); List<Orders> list = dao.getAllOrders(1);
		 * System.out.print(list);
		 */
    }
}
