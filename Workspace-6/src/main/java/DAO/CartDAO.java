package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.ConnectJDBC;
import Model.Cart;
import Model.Store;

public class CartDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Cart CheckCartId(int userid) {
    	String query = "select * from Cart\r\n"
    			+ "where UserId = ?";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userid);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Cart(rs.getInt(1), rs.getInt(2));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    	return null;
    }
}
