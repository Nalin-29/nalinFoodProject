package com.ntl.pos.util;

import java.sql.SQLException;

import com.ntl.pos.utilImpl.DbUtilImpl;

import junit.framework.TestCase;

public class DbUtilClassTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}



	public void testGetDataBase() {
		java.sql.Connection conn;
		DbUtilImpl dbU = new DbUtilImpl();
		conn  = dbU.getDataBase("com.mysql.jdbc.Driver");
		boolean status = true;
		try {
			if(conn.isClosed()) {
				status = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, status);
	}

}
