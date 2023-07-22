package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.ConnectJDBC;
import Model.Cart;
import Model.Delivery;

public class DeliveryDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Delivery CheckDeliveryById(int id) {
    	String query ="select * from Delivery\r\n"
    			+ "where DeliveryId = ? and IsDeleted = '0'";
    	try {
    		conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Delivery(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return null;
    }
}
