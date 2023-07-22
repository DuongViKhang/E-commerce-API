package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.Store;
import Model.Users;

public class StoreDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void signupstore(String name, int userid) {
    	String query = "insert into Store\r\n"
    			+ "values(?,Null,?,'1','1',Null,Null, Null, '0');";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, userid);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public Store CheckStoreByUserId(int userid) {
    	String query = "select * from Store\r\n"
    			+ "where UserId = ? and IsDeleted = '0'";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userid);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Store(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                		rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getFloat(8), rs.getDate(9), rs.getInt(10));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    	return null;
    }
    
    public void Open(int storeid) {
        String querry = "update Users set IsOpen='1' where StoreId=? and IsDeleted = '0'";
        try {

            conn = new ConnectJDBC().getConnection();

            ps = conn.prepareStatement(querry);
            ps.setInt(1, storeid);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }
    
    public void NoOpen(int storeid) {
        String querry = "update Users set IsOpen='0' where StoreId=? and IsDeleted = '0'";
        try {

            conn = new ConnectJDBC().getConnection();

            ps = conn.prepareStatement(querry);
            ps.setInt(1, storeid);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }
    
    public List<Store> getAllStore(){
    	List<Store> list = new ArrayList<>();
    	String query = "select * from Store where IsDeleted = '0'";
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			list.add(new Store(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                		rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getFloat(8), rs.getDate(9), rs.getInt(10)));
    		}
    	} catch (Exception e) {
    		
        }
    	return list;
    }
    public Store getStoreById(int id) {
    	String query = "select * from Store where StoreId = ? and IsDeleted = '0'";
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		ps.setInt(1, id);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			return (new Store(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                		rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getFloat(8), rs.getDate(9), rs.getInt(10)));
    		}
    	} catch (Exception e) {
    		
        }
    	return null;
    }
}
