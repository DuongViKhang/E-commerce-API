package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.Product;

public class ProductDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void addProduct(String name, String mota, int giathuong, int giasale, int giagoc, int soluong, String ava, int danhmuc, int style, int store) {
    	LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        String query = "Insert into Product\r\n"
        		+ "Values(?,?,?,?,?,?,?,'1','1',?,?,?,?,?,?,'0')";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, mota);
            ps.setInt(3, giathuong);
            ps.setInt(4, giasale);
            ps.setInt(5, giagoc);
            ps.setInt(6, soluong);
            ps.setInt(7, 0);
            ps.setString(8, ava);
            ps.setInt(9, danhmuc);
            ps.setInt(10, style);
            ps.setInt(11, store);
            ps.setInt(12, 0);
            ps.setString(13, date);
            ps.executeUpdate();
        } catch (Exception e) {
        }
	}
    
    public void updateProduct(int id, String name, String mota, int giathuong, int giasale, int giagoc, int soluong, String ava, int danhmuc) {
    	LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        String query = "Update Product\r\n"
        		+ "Set ProductName = ?, Decription=? , Price=?, SalePrice=?,PromotionalPrice=?,Quantity=?, Image=?,CategoryId=?,Date=?\r\n"
        		+ "where ProductId = ?;";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            
            ps.setString(1, name);
            ps.setString(2, mota);
            ps.setInt(3, giathuong);
            ps.setInt(4, giasale);
            ps.setInt(5, giagoc);
            ps.setInt(6, soluong);
            ps.setString(7, ava);
            ps.setInt(8, danhmuc);
            ps.setString(9, date);
            ps.setInt(10, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
	}
    
    public Product getProductById(int id) {
    	String query = "select * From Product where ProductID = ?";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
            	return (new Product(rs.getInt(1),
                		rs.getString(2),
                		rs.getString(3),
                		rs.getInt(4),
                		rs.getInt(5),
                		rs.getInt(6),
                		rs.getInt(7),
                		rs.getInt(8),
                		rs.getInt(9),
                		rs.getInt(10),
                		rs.getString(11),
                		rs.getInt(12),
                		rs.getInt(13),
                		rs.getInt(14),
                		rs.getInt(15),
                		rs.getDate(16),
                		rs.getInt(17)));
            }
        } catch (Exception e) {
        }
    	return null;
    }
    
    public List<Product> getAllProduct(){
    	List<Product> list = new ArrayList<>();
    	String query = "select * From Product where IsDeleted = '0'";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
            	list.add(new Product(rs.getInt(1),
                		rs.getString(2),
                		rs.getString(3),
                		rs.getInt(4),
                		rs.getInt(5),
                		rs.getInt(6),
                		rs.getInt(7),
                		rs.getInt(8),
                		rs.getInt(9),
                		rs.getInt(10),
                		rs.getString(11),
                		rs.getInt(12),
                		rs.getInt(13),
                		rs.getInt(14),
                		rs.getFloat(15),
                		rs.getDate(16),
                		rs.getInt(17)));
            }
        } catch (Exception e) {
        }
    	return list;
    }
    
    public List<Product> getAllProductByStore(int id){
    	List<Product> list = new ArrayList<>();
    	String query = "select * From Product where IsDeleted = '0' and StoreId = ?";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
            	list.add(new Product(rs.getInt(1),
                		rs.getString(2),
                		rs.getString(3),
                		rs.getInt(4),
                		rs.getInt(5),
                		rs.getInt(6),
                		rs.getInt(7),
                		rs.getInt(8),
                		rs.getInt(9),
                		rs.getInt(10),
                		rs.getString(11),
                		rs.getInt(12),
                		rs.getInt(13),
                		rs.getInt(14),
                		rs.getFloat(15),
                		rs.getDate(16),
                		rs.getInt(17)));
            }
        } catch (Exception e) {
        }
    	return list;
    }
    
    public int getNumberPage() {
    	String query = "select count(*) From Product where IsDeleted = '0'";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
            	int total = rs.getInt(1);
            	int countPage = total/25;
            	if(total % 25 != 0) {
            		countPage++;
            	}
            	return countPage;
            }
        } catch (Exception e) {
        }
    	return 0;
    }
    public List<Product> pagingProduct(int index) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product where IsDeleted = '0'\r\n "
        			 + "order by ProductId\r\n"
        			 + "offset ? rows fetch next 25 rows only;";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index-1)*25);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                		rs.getString(2),
                		rs.getString(3),
                		rs.getInt(4),
                		rs.getInt(5),
                		rs.getInt(6),
                		rs.getInt(7),
                		rs.getInt(8),
                		rs.getInt(9),
                		rs.getInt(10),
                		rs.getString(11),
                		rs.getInt(12),
                		rs.getInt(13),
                		rs.getInt(14),
                		rs.getFloat(15),
                		rs.getDate(16),
                		rs.getInt(17)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void deletePro(int maSP) {
        String query = "UPDATE Product\n" +
                "SET IsDeleted=?\n" +
                "WHERE ProductId = ?;";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, "1");
            ps.setInt(2, maSP);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public static void main(String[] agrc) {
    	ProductDAO dao = new ProductDAO();
    	dao.addProduct("a", "a", 1, 1, 1, 1, "a", 1, 1, 1);
    	System.out.print("a");
    }
}
