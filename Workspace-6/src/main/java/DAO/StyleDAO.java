package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.Category;
import Model.Style;


public class StyleDAO {
	
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
	public Style getStyleByStyleID(int id){
    	String query = "select * from Style where StyleId = ?";
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		ps.setInt(1, id);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			return new Style(rs.getInt(1), rs.getString(2), rs.getInt(3));
    		}
    		
    	} catch (Exception e) {
    		
        }
    	return null;
    }
	public Style getStyleIDByStyle(String s) {
    	String query = "select * from Style where StyleName = ?";
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		ps.setString(1, s);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			return new Style(rs.getInt(1), rs.getString(2), rs.getInt(3));
    		}
    		
    	} catch (Exception e) {
    		
        }
    	return null;
	}
}
