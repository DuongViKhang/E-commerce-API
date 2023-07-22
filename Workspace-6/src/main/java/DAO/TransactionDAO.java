package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.Transactions;
import Model.Users;

public class TransactionDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void addTransaction(int user, int store, int amount) {
    	LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        String query = "Insert into Transactions\r\n"
        		+ "values (?,?,?,?,0)";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1, user);
            ps.setInt(2, store);
            ps.setInt(3, amount);
            ps.setString(4, date);
            ps.executeUpdate();
        } catch (Exception e) {
        }
	}
    
    public List<Transactions> getAllTransaction(){
    	List<Transactions> list = new ArrayList<>();
    	String query = "select * from Transactions where IsDeleted = '0'";
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			list.add(new Transactions(rs.getInt(1),
    										rs.getInt(2),
    										rs.getInt(3),
    										rs.getInt(4),
    										rs.getDate(5),
    										rs.getInt(6)));
    		}
    	} catch (Exception e) {
    		
        }
    	return list;
    }
}
