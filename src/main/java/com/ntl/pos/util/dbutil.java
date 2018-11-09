package com.ntl.pos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface dbutil {
	
	public static  Connection getDataBase() {
		Connection conn=null;
		String url = "jdbc:mysql://localhost/POS";
		String USER = "root";
		String PASS =  "root";
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
