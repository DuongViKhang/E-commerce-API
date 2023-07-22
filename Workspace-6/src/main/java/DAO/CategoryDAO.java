package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.Category;

public class CategoryDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void AddCategory(String name, int styleid) {
    	String query ="insert into Category\r\n"
    			+ "values(?,?,0);";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, styleid);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * From Category where IsDeleted = 0";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Category> getcategoryByStyleId(int styleid) {
        List<Category> list = new ArrayList<>();
        String query = "select * From Category where StyleId = ? and isDeleted = 0";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, styleid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Category getCategoryByID(int categoryid) {
        String query = "select * From DanhMuc where MaDM = ? and isDeleted = 0";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, categoryid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void UpdateCategory(String name, int styleid, int categoryid, int isDeleted) {
    	String query ="update Category set CategoryName=?, StyleId=?, IsDeleted where CategoryId=?";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, styleid);
            ps.setInt(3, isDeleted);
            ps.setInt(4, categoryid);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void DeleteCategory(int categoryid) {
    	String query ="update Category set IsDeleted ='0' where CategoryId=?";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, categoryid);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
