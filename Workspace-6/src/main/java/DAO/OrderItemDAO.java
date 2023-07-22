package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.OrderItem;
import Model.Orders;
import Model.Users;

public class OrderItemDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public OrderItem CheckOrderItemByOrderId(int id) {
    	String query = "select * from OrderItem\r\n"
                + "where OrderId = ?";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new OrderItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    	return null;
    }
	
	public void AddOrder(OrderItem orderItem) {
		String query = "Insert into OrderItem Values(?,?,?)";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderItem.getOrderId());
			ps.setInt(2, orderItem.getProductId());
			ps.setInt(3, orderItem.getCount());
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	public List<OrderItem> getAllOrderItemById(int id) {
		List<OrderItem> list = new ArrayList<>();
		String query = "select * from OrderItem where OrderId = ?";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new OrderItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (Exception e) {

		}
		return list;
	}
	
	public List<OrderItem> getAllOrderItem() {
		List<OrderItem> list = new ArrayList<>();
		String query = "select * from Orders where IsDeleted = '0'";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new OrderItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	public static void main(String[] agrc) {
		/*
		 * OrderItemDAO dao = new OrderItemDAO(); OrderItem o = new OrderItem(17, 1008,
		 * 2); try { dao.AddOrder(o); System.out.println("Thêm thành công!"); } catch
		 * (Exception e) {
		 * 
		 * } OrderItemDAO dao = new OrderItemDAO(); List<OrderItem> list =
		 * dao.getAllOrderItem(); System.out.print(list);
		 */
	}
}
