package com.jobportal.services.user;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.models.GeneralInfoModel;

public class GeneralInfoService {
	
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

	public void deleteGeneralInfo(int userId) throws Exception {
		try {
            PreparedStatement preparedStatement = getConnection()
                    .prepareStatement("delete from user_primary where user_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	public List<GeneralInfoModel> getGeneralDetails(String email_id) throws Exception {
		List<GeneralInfoModel> general = new ArrayList<>();
		try {
			// We should write where email_id condition using session in the below sql command
			PreparedStatement preparedStatement = getConnection().
                    prepareStatement("select * from user_primary where email_id=?");
            preparedStatement.setString(1, email_id);
            ResultSet rs = preparedStatement.executeQuery();
           
            while (rs.next()) {
                GeneralInfoModel generalmodel = new GeneralInfoModel();
                generalmodel.setUser_id(rs.getInt("user_id"));
                generalmodel.setEmail_id(rs.getString("email_id"));
                generalmodel.setAddress(rs.getString("address"));
                generalmodel.setPhone_no(rs.getString("phone_no"));
                generalmodel.setZip_code(rs.getString("zip_code"));
                
                general.add(generalmodel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return general;
	}

	public GeneralInfoModel editGeneralInfo(int userId) throws Exception {
		GeneralInfoModel generalmodel = new GeneralInfoModel();
        try {
            PreparedStatement preparedStatement = getConnection().
                    prepareStatement("select * from user_primary where user_id=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	 generalmodel.setUser_id(rs.getInt("user_id"));
                 generalmodel.setAddress(rs.getString("address"));
                 generalmodel.setPhone_no(rs.getString("phone_no"));
                 generalmodel.setZip_code(rs.getString("zip_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generalmodel;

	}

	public void addGeneralInfo(GeneralInfoModel generalmodel) throws Exception {
		 try {
	            PreparedStatement ps = getConnection()
	                    .prepareStatement("insert into user_primary (email_id,address,phone_no,zip_code) values (?, ?, ?, ?)");
	            // Parameters start with 1
	            ps.setString(1, generalmodel.getEmail_id());
	            ps.setString(2, generalmodel.getAddress());
	            ps.setString(3, generalmodel.getPhone_no());
	            ps.setString(4, generalmodel.getZip_code());
	            
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	public void updateGeneralInfo(GeneralInfoModel generalmodel) throws Exception {
		try {
            PreparedStatement ps = getConnection()
                    .prepareStatement("update user_primary set address=?,phone_no=?,zip_code=? where user_id=?");
            // Parameters start with 1
          
            ps.setString(1, generalmodel.getAddress());
            ps.setString(2, generalmodel.getPhone_no());
            ps.setString(3, generalmodel.getZip_code());
            ps.setInt(4, generalmodel.getUser_id());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
