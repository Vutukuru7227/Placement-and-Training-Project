package services;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import repository.*;

public class LoginService implements ILogin{
	
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/placement";
			String username = "root";
			String password = "";
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			
			out.println("Connection established");
			
			return conn;
		}catch (Exception e) {
			out.println("Connection error");
		}
		return null;
	}

	@Override
	public boolean authenticateUser(String email_id, String password) {
		boolean result = false;
		String dbEmail_id = "";
		String dbPassword = "";
		
		try {
			String sql = "select * from registration where email_id=? and password=?";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, email_id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				dbEmail_id = rs.getString(1);
				dbPassword = rs.getString(4);
			}
			if((dbEmail_id.equals(email_id)) && (dbPassword.equals(password))) {
				return true;
			}else {
				return result;
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;		
	}	
}
