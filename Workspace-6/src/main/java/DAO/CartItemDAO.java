package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.CartItem;
import Model.Category;

public class CartItemDAO {
	 Connection conn = null;
     PreparedStatement ps = null;
     ResultSet rs = null;
     
	 public void AddCartItem(int cartId, int productId, int count, Date date, int isDeleted) {
	    	String query ="insert into CartItem\r\n"
	    			+ "values(?,?,?,?,?);";
	    	try {
	            conn = new ConnectJDBC().getConnection();
	            ps = conn.prepareStatement(query);
	            ps.setInt(1, cartId);
	            ps.setInt(2, productId);
	            ps.setInt(3, count);
	            ps.setDate(4, date);
	            ps.setInt(5, isDeleted);
	            ps.executeUpdate();
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	 }
	 
	 public List<CartItem> getAllCartItem(int cartId){
		 List<CartItem> list = new ArrayList<>();
	        String query = "select * From CartItem where CartId = ? and IsDeleted = 0";
	        try {
	            conn = new ConnectJDBC().getConnection();
	            ps = conn.prepareStatement(query);
	            ps.setInt(1, cartId);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(new CartItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getInt(6)));
	            }
	        } catch (Exception e) {
	        }
	     return list;
	 }
	 public void DeleteCartItem(int cartItemId) {
		 String query ="delete from CartItem where CartItemId = ?";
	    	try {
	            conn = new ConnectJDBC().getConnection();
	            ps = conn.prepareStatement(query);
	            ps.setInt(1, cartItemId);
	            ps.executeUpdate();
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	 }
	 public void UpdateCartItem(int cartItemId) {
		 String query ="update CartItem set IsDeleted = 1 where CartItemId = ? and IsDeleted = 0";
	    	try {
	            conn = new ConnectJDBC().getConnection();
	            ps = conn.prepareStatement(query);
	            ps.setInt(1, cartItemId);
	            ps.executeUpdate();
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	 }
	 public static void main(String[] agrc) {
		 
	 }
}
