package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.Users;

public class UserDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Users login(String email, String password) {
    	String query = "select * from Users\r\n"
                + "where Email=? and Password = ? and IsDeleted = '0' and RoleId = '3'";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11),
                        rs.getInt(12));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    	return null;
    }
    
    public Users adminlogin(String email, String password) {
    	String query = "select * from Users\r\n"
                + "where Email=? and Password = ? and IsDeleted = '0' and RoleId = '1'";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11),
                        rs.getInt(12));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    	return null;
    }
    
    public void signup(String username, String idcard, String email, String phone, String pass) {
    	String query ="insert into Users\r\n"
    			+ "values(?,?,?,?, '1' ,?,3,Null,Null, Null, '0');";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, idcard);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, pass);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void ChangePass(int id, String pass) {
        String querry = "update Users set Password=? where UserId=? and IsDeleted = '0'";
        try {

            conn = new ConnectJDBC().getConnection();

            ps = conn.prepareStatement(querry);
            ps.setString(1, pass);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }
    
    public Users CheckUserByUserId(int id) {
    	String query = "select * from Users\r\n"
                + "where UserId=? and IsDeleted = '0'";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11),
                        rs.getInt(12));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    	return null;
    }
    
    public Users CheckUserByUsername(String username) {
    	String query = "select * from Users\r\n"
                + "where UserName=? and IsDeleted = '0'";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11),
                        rs.getInt(12));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    	return null;
    }
    
    public Users CheckUserByIdcard(String idcard) {
    	String query = "select * from Users\r\n"
                + "where IdCard=? and IsDeleted = '0'";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idcard);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11),
                        rs.getInt(12));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    	return null;
    }
    
    public Users CheckUserByEmail(String email, String pass) {
    	String query = "select * from Users\r\n"
                + "where Email = ? and Password = ? and IsDeleted = '0'";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11),
                        rs.getInt(12));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    	return null;
    }
    
    public Users CheckUserByPhone(String phone, String pass) {
    	String query = "select * from Users\r\n"
                + "where Phone = ? and Password = ? and IsDeleted = '0'";
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, phone);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11),
                        rs.getInt(12));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    	return null;
    }
    public List<Users> getAllUser(){
    	List<Users> list = new ArrayList<>();
    	String query = "select * from Users where IsDeleted = '0' and RoleId = '3' or RoleId = '2'";
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			list.add(new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11),
                        rs.getInt(12)));
    		}
    	} catch (Exception e) {
    		
        }
    	return list;
    }
    public List<Users> getAllUserById(int id){
    	List<Users> list = new ArrayList<>();
    	String query = "select * from Users where UserId=? and IsDeleted = '0' and RoleId = '3' or RoleId = '2'";
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		ps.setInt(1, id);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			list.add(new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11),
                        rs.getInt(12)));
    		}
    	} catch (Exception e) {
    		
        }
    	return list;
    }
    public void Create(Users user) {
    	String query = "INSERT INTO Users \r\n"
    			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
		try {
			conn = new ConnectJDBC().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getIdCard());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setInt(5, user.getIsEmailActive());
			ps.setString(6, user.getPassword());
			ps.setInt(7, user.getRoleId());
			ps.setString(8, user.getAddress());
			ps.setString(9, user.getAvatar());
			ps.setDate(10, user.getDate());
			ps.setInt(11, user.getIsDeleted());
			ps.executeUpdate();
			
			query = "INSERT INTO Cart values(?)";
			try {
				ps = conn.prepareStatement(query);
				ps.setInt(1, checkAccountExist(user.getUserName()
						, user.getPhone(), user.getEmail(), user.getIdCard(),
						user.getIdCard()).getUserId());
				ps.executeUpdate();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    public void Update(Users user) {
    	String query = "update Users\r\n"
    			+ "set Username = ?,\r\n"
    			+ "	IdCard = ?,\r\n"
    			+ "	Email = ?,\r\n"
    			+ "	Phone = ?,\r\n"
    			+ "	IsEmailActive = ?,\r\n"
    			+ "	Password = ?,	\r\n"
    			+ "	RoleId = ?,\r\n"
    			+ "	Address = ?,\r\n"
    			+ "	Avatar = ?,\r\n"
    			+ "	Date = ?,\r\n"
    			+ "	IsDeleted = ?\r\n"
    			+ "where UserId = ?";
		try {
			conn = new ConnectJDBC().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getIdCard());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setInt(5, user.getIsEmailActive());
			ps.setString(6, user.getPassword());
			ps.setInt(7, user.getRoleId());
			ps.setString(8, user.getAddress());
			ps.setString(9, user.getAvatar());
			ps.setDate(10, user.getDate());
			ps.setInt(11, user.getIsDeleted());
			ps.setInt(12, user.getUserId());
			ps.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
    }
//    public void Delete(int id) {
//    	String query = "delete from Users where UserId = ?";
//		try {
//			conn = new ConnectJDBC().getConnection();
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setInt(1, id);
//			ps.executeUpdate();
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//    }
    public Users checkAccountExist(String username, String phone, String email, String idCard, String password) {
    	String query = "select * from Users where Username = ? \r\n"
    			+ "or Phone = ? \r\n"
    			+ "or Email = ? \r\n"
    			+ "or IdCard = ? \r\n"
    			+ "or Password = ?";
    	try {
			conn = new ConnectJDBC().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, idCard);
			ps.setString(5, password);
			
			rs = ps.executeQuery();
            while (rs.next()) {
                return new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11),
                        rs.getInt(12));
            }
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    /*public static void main(String[] argc) {
    	UserDAO dao = new UserDAO();
    	Date now = new Date(System.currentTimeMillis());
    	Users o = new Users("khangduong", "012345", "khangduong@gmail.com"
    			, "0129945678", 1, "khangduong", 3, null, null, now, 0);
    	Users x = dao.checkAccountExist(o.getUserName(), o.getPhone(), o.getEmail(), o.getIdCard(), o.getIdCard());
    	if (x == null) {
    		try {
    			dao.Create(o);
        		System.out.print("Thành công");
    		}
    		catch (Exception e) {
    			System.out.print("Thất bại 2");
    		}
    	}
    	else {
    		System.out.print("Thất bại");
    	}
    }*/
}
