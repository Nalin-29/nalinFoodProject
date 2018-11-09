/**
 * 
 */
package com.ntl.pos.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.service.impl.UserImpl;
import com.ntl.pos.service.impl.ValidateDataImpl;

/**
 * @author Training
 *
 */
public class ValidateImplTest {
	
	ValidateDataImpl vd = new ValidateDataImpl();

	/**
	 * Test method for {@link com.ntl.pos.service.impl.ValidateDataImpl#validateEmail(java.lang.String)}.
	 */
	@Test
	public void testValidateEmail() {
		String email = "abcdefbhut";
		boolean sb = vd.validateEmail(email);
		assertEquals(true,sb);
		
		
	}
	
	@Test
	public void testValidateEmailfalse() {
		String email = "abcdefbh";
		boolean sb = vd.validateEmail(email);
		assertEquals(false,sb);
		
		
	}
	
	/**
	 * Test method for {@link com.ntl.pos.service.impl.ValidateDataImpl#validatePassword(java.lang.String)}.
	 */
	@Test
	public void testValidatePassword() {
		String pass = "abcdef";
		boolean sb = vd.validatePassword(pass);
		assertEquals(true,sb);
	}
	
	@Test
	public void testValidatePasswordfalse() {
		String pass = "abc";
		boolean sb = vd.validatePassword(pass);
		assertEquals(false,sb);
	}

	/**
	 * Test method for {@link com.ntl.pos.service.impl.ValidateDataImpl#validateName(java.lang.String)}.
	 */
	@Test
	public void testValidateName() {
		String name = "abcder";
		boolean sb = vd.validateName(name);
		assertEquals(true,sb);
		
	}
	
	@Test
	public void testValidateNamefalse() {
		String name = "abc";
		boolean sb = vd.validateName(name);
		assertEquals(false,sb);
		
	}

	/**
	 * Test method for {@link com.ntl.pos.service.impl.ValidateDataImpl#validateLong(java.lang.String)}.
	 */
	@Test
	public void testValidateLong() {
		String lname = "abcdefhigk";
		boolean sb = vd.validateLong(lname);
		assertEquals(true,sb);
	}
	
	@Test
	public void testValidateLongfalse() {
		String lname = "abc";
		boolean sb = vd.validateLong(lname);
		assertEquals(false,sb);
	}

	/**
	 * Test method for {@link com.ntl.pos.service.impl.ValidateDataImpl#validategender(java.lang.String)}.
	 */
	@Test
	public void testValidategender() {
		String gender = "male";
		boolean sb = vd.validategender(gender);
		assertEquals(true,sb);
	}
	
	@Test
	public void testValidategenderfalse() {
		String gender = "ma";
		boolean sb = vd.validategender(gender);
		assertEquals(false,sb);
	}


	/**
	 * Test method for {@link com.ntl.pos.service.impl.ValidateDataImpl#validateNum(java.lang.String)}.
	 */
	@Test
	public void testValidateNum() {
		String num = "9728430593";
		boolean sb = vd.validateLong(num);
		assertEquals(false,sb);
	}

}
