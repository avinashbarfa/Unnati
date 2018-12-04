package com.nc.unnati.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nc.unnati.dto.Login;
import com.nc.unnati.util.DBUtil;

public class LoginDAO {
	
	public boolean authenticateInstitue(Login login) {
		String query = "SELECT username,password FROM institute WHERE visibility=true";
		String userName = null;
		String password = null;
		try(Connection connection = DBUtil.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(login.getUsername());
				System.out.println(login.getPassword());
				userName = rs.getString("username");
				password = rs.getString("password");
				System.out.println("db username :"+userName);
				System.out.println("DB password :"+password);
				if(userName.equals(login.getUsername()) && password.equals(login.getPassword()))
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
