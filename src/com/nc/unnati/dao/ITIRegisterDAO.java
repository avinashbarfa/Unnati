package com.nc.unnati.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nc.unnati.dto.ITIRegister;
import com.nc.unnati.util.DBUtil;

public class ITIRegisterDAO {
	
	public boolean registerITI(ITIRegister register) {
		
		String query = "INSERT INTO institute (fullname,email,password,contact,zip,state,address) values (?,?,?,?,?,?,?)";
		try(Connection connection = DBUtil.getConnection()) {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, register.getFullName());
			ps.setString(2, register.getEmailID());
			ps.setString(3, register.getPassword());
			ps.setLong(4, register.getContactNumber());
			ps.setInt(5, register.getZipCode());
			ps.setString(6, register.getState());
			ps.setString(7, register.getAddress());
		
			if(ps.executeUpdate() > 0) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
