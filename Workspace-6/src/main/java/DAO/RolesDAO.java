package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.Roles;
import Model.Users;

public class RolesDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Roles CheckRole(int id) {
    	String query = "select * from Users\r\n"
                + "where RoleId = ? and IsDeleted = '0'";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Roles(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    	return null;
    }
    
    
    public List<Roles> getAllRoles(){
    	List<Roles> list = new ArrayList<>();
    	String query = "select * from Roles where IsDeleted = '0'";
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			list.add(new Roles(rs.getInt(1), rs.getString(2), rs.getInt(3)));
    		}
    	} catch (Exception e) {
    		
        }
    	return list;
    }
}
