package com.ntl.pos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

//import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.ntl.pos.bean.ProfileBean;
import com.ntl.pos.dao.profiledao;
import com.ntl.pos.util.*;

public class ProfileDaoClass implements profiledao {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	public ProfileDaoClass(DataSource mockDataSource) {
		// TODO Auto-generated constructor stub
		try {
			conn=mockDataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ProfileDaoClass() {
		// TODO Auto-generated constructor stub
	}

	//@Override
	public String createProfile(ProfileBean profileBean) {
		// TODO Auto-generated method stub
		conn=dbutil.getDataBase(); 
		
		try {
			//Create user credintial 
			int z = createUserCredintial(profileBean);
			if(z==0) {
				return "Fail";
			}
			pstmt = conn.prepareStatement("insert into user_profile values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, profileBean.getUserId());
			pstmt.setString(2, profileBean.getFirstName());
			pstmt.setString(3, profileBean.getLastName());
			pstmt.setObject(4, profileBean.getDateOfBirth());
			pstmt.setString(5, profileBean.getGender());
			pstmt.setString(6, profileBean.getStreet());
			pstmt.setString(7, profileBean.getLocation());
			pstmt.setString(8, profileBean.getCity());
			pstmt.setString(9, profileBean.getState());
			pstmt.setString(10,profileBean.getPincode());
			
			pstmt.setString(11, profileBean.getMobileNo());
			int s=pstmt.executeUpdate();
			if(s==1) {
				pstmt =conn.prepareStatement("insert into wallet(userid,balance) values(?,?)");
				pstmt.setString(1, profileBean.getUserId());
				pstmt.setInt(2,1000);
				s = pstmt.executeUpdate();
				if(s==1)
				return "Success";
			}
			//System.out.println(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//stmt.execute("insert ");
		return "Fail";
	}

	public int createUserCredintial(ProfileBean profileBean) {
		try {
			pstmt = conn.prepareStatement("insert into user_credential values(?,?,?,?)");
			pstmt.setString(1, profileBean.getUserId());
			pstmt.setString(2, profileBean.getPassword());
			pstmt.setString(3, "User");
			pstmt.setInt(4, 0);
			return pstmt.executeUpdate();
		}
		catch(Exception e){
			System.out.println("Exception - " + e);
		}
		return 0;
	}
	//@Override
	public int deleteProfile(ArrayList<String> profile) {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public boolean updateProfile(ProfileBean profileBean) {
		// TODO Auto-generated method stub
		return false;
	}

	//@Override
	public ProfileBean findByID(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public ArrayList<ProfileBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
