package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectJDBC {
	
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://"+serverName + ":"+portNumber+"\\"+instance+";databaseName="+dbName;
		if(instance == null || instance.trim().isEmpty())
		url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}
		private final String serverName = "LAPTOP-A1H3S8V5";
		private final String dbName = "ShopeeDB";
		private final String portNumber = "1433";
		private final String instance="";
		private final String userID = "sa";
		private final String password = "khang1234";
	public static void main(String[] args) {
		try {
			System.out.println(new ConnectJDBC().getConnection());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	}