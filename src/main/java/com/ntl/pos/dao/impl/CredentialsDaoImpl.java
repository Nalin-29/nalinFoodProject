package com.ntl.pos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import com.mysql.jdbc.Statement;
import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.dao.credentialsdao;
import com.ntl.pos.util.dbutil;

public class CredentialsDaoImpl implements credentialsdao{
	//private static final String Password = null;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;

	//@Override
	public String createProfile(CredentialsBean credentialsBean) {
		// TODO Auto-generated method stub
		
		conn=dbutil.getDataBase(); 
		try {
			pstmt = conn.prepareStatement("insert into user_credential values(?,?,?,?)");
			pstmt.setString(1, credentialsBean.getUserId());
			pstmt.setString(2, credentialsBean.getPassword());
			pstmt.setString(3, credentialsBean.getUsertype());			
			pstmt.setInt(4, credentialsBean.getLoginStatus());
		//	int s=pstmt.executeUpdate();
			//System.out.println(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//stmt.execute("insert ");
		return null;
	}

	//@Override
	public int deleteProfile(ArrayList<String> profile) {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public boolean updateProfile(CredentialsBean profileBean) {
		// TODO Auto-generated method stub
		return false;
	}

	//@Override
	public CredentialsBean findByID(String userID) {
		// TODO Auto-generated method stub
		CredentialsBean  user=null;
		conn=dbutil.getDataBase();
		
		try {
			stmt=conn.createStatement();
			rs = stmt.executeQuery("Select * from user_credential where userid='"+userID+"'");
			if(rs.next()) {
				user = new CredentialsBean(rs.getString("userID"),rs.getString("Password"),rs.getString("usertype"),rs.getInt("loginstatus"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user.toString());
		return user;
	
	}

	//@Override
	public ArrayList<CredentialsBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
