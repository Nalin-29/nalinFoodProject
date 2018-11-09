package com.ntl.pos.util;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.utilImpl.AuthenticationImpl;

import junit.framework.TestCase;

public class AuthenticationClassTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAuthenticate() {
		AuthenticationImpl authenticationImpl;
		authenticationImpl = new AuthenticationImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setUserId("1007");
		credentialsBean.setPassword("naman@gmail.com");
	    //Correct Data | ADMIN
		boolean actual = authenticationImpl.authenticate(credentialsBean);
		assertEquals(true, actual);

	}
	
	public void testAuthenticateUser() {
		AuthenticationImpl authenticationImpl;
		authenticationImpl = new AuthenticationImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setUserId("1008");
		credentialsBean.setPassword("nalin");
	    //Correct Data | ADMIN
		boolean actual = authenticationImpl.authenticate(credentialsBean);
		assertEquals(true, actual);

	}
	
	
	public void testAuthenticateFalse() {
		AuthenticationImpl authenticationImpl;
		authenticationImpl = new AuthenticationImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setUserId("1008");
		credentialsBean.setPassword("naman@gmail.com");
	    //Correct Data | ADMIN
		boolean actual = authenticationImpl.authenticate(credentialsBean);
		assertEquals(false, actual);

	}

	public void testAuthorize() {
		AuthenticationImpl authenticationImpl;
		authenticationImpl = new AuthenticationImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setUserId("1007");
		credentialsBean.setPassword("naman@gmail.com");
	   
		boolean actual = authenticationImpl.authenticate(credentialsBean);
	   
		String result = authenticationImpl.authorize("1007");
		assertEquals("admin",result);
		}
	
	public void testAuthorizeForUser() {
		AuthenticationImpl authenticationImpl;
		authenticationImpl = new AuthenticationImpl();
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setUserId("1008");
		credentialsBean.setPassword("nalin");
	   
		boolean actual = authenticationImpl.authenticate(credentialsBean);
	   
		String result = authenticationImpl.authorize("1008");
		assertEquals("User",result);	
		}
	
	
	



}
