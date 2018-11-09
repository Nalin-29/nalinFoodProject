package com.ntl.pos.util;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.ProfileBean;
import com.ntl.pos.dao.impl.ProfileDaoClass;
import com.ntl.pos.service.impl.UserImpl;
import com.ntl.pos.utilImpl.AuthenticationImpl;
import com.ntl.pos.utilImpl.UserUtilImpl;

import junit.framework.TestCase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

public class UserClassTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAdminLogIn() {
		//
		String id = "1007";
		String pass = "naman@gmail.com";
		CredentialsBean cb = new CredentialsBean();
	    cb.setUserId(id);
	    cb.setPassword(pass);
	    UserUtilImpl uc = new UserUtilImpl();
	 //   when(uc.logIn(cb)).thenReturn("admin");
	    String result = uc.logIn(cb);
	    assertEquals("admin", result);
	}
	
	public void testAdminLogInfail() {
		//
		String id = "1009";
		String pass = "naman@gmail.com";
		CredentialsBean cb = new CredentialsBean();
	    cb.setUserId(id);
	    cb.setPassword(pass);
	    UserUtilImpl uc = new UserUtilImpl();
	 //   when(uc.logIn(cb)).thenReturn("admin");
	    String result = uc.logIn(cb);
	    assertEquals("admin", result);
	}
	
	public void testUserLogIn() {
		//
		String id = "1008";
		String pass = "nalin";
		CredentialsBean cb = new CredentialsBean();
	    cb.setUserId(id);
	    cb.setPassword(pass);
	    UserUtilImpl uc = new UserUtilImpl();
	 //   when(uc.logIn(cb)).thenReturn("admin");
	    String result = uc.logIn(cb);
	    assertEquals("User", result);
	}

	public void testUserLogInfail() {
		//
		String id = "102";
		String pass = "nalin";
		CredentialsBean cb = new CredentialsBean();
	    cb.setUserId(id);
	    cb.setPassword(pass);
	    UserUtilImpl uc = new UserUtilImpl();
	 //   when(uc.logIn(cb)).thenReturn("admin");
	    String result = uc.logIn(cb);
	    assertEquals("User", result);
	}



    	public void testRegister() {
    		ProfileDaoClass testobj = mock(ProfileDaoClass.class);
    		UserUtilImpl userobj =  new UserUtilImpl(testobj);
    		Date date = new Date();
    		
    		ProfileBean pb = new ProfileBean();
    		pb.setUserId("6543");
    		pb.setFirstName("nalin");
    		pb.setLastName("agrawal");
    		pb.setDateOfBirth(date);
    		pb.setGender("male");
    		pb.setStreet("Housing ");
    		pb.setLocation("2 ");
    		pb.setCity("naharatpur");
    		pb.setState("Rajasthan");
    		pb.setPincode("232001");
    		pb.setMobileNo("9768768");
    		pb.setEmailId("mittalsab@yahoo.com");
    		pb.setPassword("Mdm@9782");
    		when(userobj.register(pb)).thenReturn("success");
    		
    	
    		
    		String result= userobj.register(pb);
    		assertEquals("success",result); 
    	}
	
	}


