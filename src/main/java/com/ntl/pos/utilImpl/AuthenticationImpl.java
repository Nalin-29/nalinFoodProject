package com.ntl.pos.utilImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.dao.impl.CredentialsDaoImpl;
import com.ntl.pos.util.authentication;
import com.ntl.pos.util.dbutil;

public class AuthenticationImpl implements authentication {
    
	Connection conn;
	Statement stat;
	ResultSet rs;
	//@Override
	public boolean authenticate(CredentialsBean credentialsBean) {
		// TODO Auto-generated method stub
		//System.out.println("auth");
		conn=dbutil.getDataBase(); 

		//CredentialsBean cb1=new CredentialsBean();
		//System.out.println("lu");
		try {
			String userId = credentialsBean.getUserId();
			String sql = "select * from user_credential where userId ='" + userId + "'";
			stat =conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()) {
				credentialsBean.setUserId(rs.getString("userid"));
				if(rs.getString("password").equals(credentialsBean.getPassword())) {
					
					changeloginStatus(credentialsBean, 0);
					//System.out.println("Authenticate SUccess");
					return true;
				}
				else {
					System.out.println("Invalid");
				}
			}
			else {
				System.out.println("Failed");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
			
	}

	//@Override
	public String authorize(String userId) {
		// TODO Auto-generated method stub
		//System.out.println("Authorize");
		CredentialsDaoImpl credit = new CredentialsDaoImpl();
		CredentialsBean crbean = credit.findByID(userId);
		
		return crbean.getUsertype();
	}

	//@Override
	public boolean changeloginStatus(CredentialsBean credentialsBean, int loginStatus) {
		// TODO Auto-generated method stub
		String userId = credentialsBean.getUserId();
	//this has to be executed	//String sql = ("update user_credential set loginstatus="+loginStatus where credential);
		try {
			stat =conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}


