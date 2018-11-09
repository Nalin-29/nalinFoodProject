package com.ntl.pos.dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Before;
import org.junit.Test;

import com.ntl.pos.bean.ProfileBean;
import com.ntl.pos.dao.impl.ProfileDaoClass;

import junit.framework.TestCase;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class profileDaoClassTest extends TestCase {
	
	 DataSource mockDataSource=mock(DataSource.class);
	    Connection mockConn=mock(Connection.class);
	    PreparedStatement mockPreparedStmnt=mock(PreparedStatement.class);
	    Statement mockCreateStmt=mock(Statement.class);
	    ResultSet mockResultSet=mock(ResultSet.class);
	
	   // String sDate1="31/12/1998";    
	  //  SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
	    Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
	    
	    ProfileBean pb=new ProfileBean("70000","Nalin","Agrawal",sqlDate,"Male","delhi","delhi","delhi","delhi","321001","9728430593","mittal@gmail.com","Ishanya@123");
	    

	protected void setUp() throws Exception {
		super.setUp();
		
		when(mockDataSource.getConnection()).thenReturn(mockConn);
        when(mockConn.prepareStatement(anyString())).thenReturn(mockPreparedStmnt);
        when(mockConn.createStatement()).thenReturn(mockCreateStmt);
        when(mockCreateStmt.executeQuery(anyString())).thenReturn(mockResultSet);
       when(mockCreateStmt.executeUpdate(anyString())).thenReturn(1);
        doNothing().when(mockPreparedStmnt).setString(anyInt(), anyString());
        doNothing().when(mockPreparedStmnt).setInt(anyInt(), anyInt());
        when(mockPreparedStmnt.executeUpdate()).thenReturn(1);
        when(mockPreparedStmnt.executeQuery()).thenReturn(mockResultSet);
       // when(mockPreparedStmnt.getGeneratedKeys()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);
        when(mockResultSet.first()).thenReturn(true);
        when(mockResultSet.getString(1)).thenReturn("70000");
        when(mockResultSet.getString(2)).thenReturn("Nalin");
        when(mockResultSet.getString(3)).thenReturn("Agrawal");
        when(mockResultSet.getDate(4)).thenReturn(sqlDate);
        when(mockResultSet.getString(5)).thenReturn("Male");
        when(mockResultSet.getString(6)).thenReturn("delhi");
        when(mockResultSet.getString(7)).thenReturn("delhi");
        when(mockResultSet.getString(8)).thenReturn("delhi");
        when(mockResultSet.getString(9)).thenReturn("delhi");
        when(mockResultSet.getString(10)).thenReturn("321001");
        when(mockResultSet.getString(11)).thenReturn("9728430593");
        when(mockResultSet.getString(12)).thenReturn("mittal@gmail.com");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCreateProfile() {
		ProfileDaoClass profile=new ProfileDaoClass(mockDataSource);

		assertEquals("Success",profile.createProfile(pb));
	}

	
	
	

}
