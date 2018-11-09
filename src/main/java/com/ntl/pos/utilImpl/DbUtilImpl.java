package com.ntl.pos.utilImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.ntl.pos.util.dbutil;

public class DbUtilImpl implements dbutil {
	
	static Connection conn;
	static Statement stat;
	static ResultSet rs;
	static PreparedStatement pstmt;
	
	static final String url = "jdbc:mysql://localhost/POS";
	static final String USER = "root";
	static final String PASS =  "root";
	
	public DbUtilImpl() {
     conn = getDataBase(url);
	}

	public  Connection getDataBase(String driver) {
		   try {Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, USER, PASS);
			//stat =conn.createStatement();
		   }
	       catch (SQLException s)
		   {
				System.out.println(s);
		   }
		   catch(ClassNotFoundException c)
			{
				System.out.println(c);
			}

		return conn;
	}
	

	

}
