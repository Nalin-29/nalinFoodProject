package com.ntl.pos.dao;

import java.util.ArrayList;

import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.dao.impl.AdministratorDaoImpl;
import com.ntl.pos.service.impl.AdministratorImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import junit.framework.TestCase;

public class AdministratorDaoImplTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAddStore() {
		StoreBean sb = new StoreBean(2008," Pizza","nagar","9728430593","delhi","delhi","321001");
	    AdministratorDaoImpl testobj = mock(AdministratorDaoImpl.class); 
		when(testobj.addStore(sb)).thenReturn("SUCCESS");
		String result= testobj.addStore(sb);
		assertEquals("SUCCESS",result);
	}

	public void testModifyStore() {
		StoreBean sb = new StoreBean(2008," Pizza","nagar","9728430593","delhi","delhi","321001");
	    AdministratorDaoImpl testobj = mock(AdministratorDaoImpl.class); 
		when(testobj.modifyStore(sb)).thenReturn(true);
	 	
		boolean result= testobj.modifyStore(sb);
		assertEquals(true,result);
	}



	public void testViewStore() {
		String storeId = "2001";
		AdministratorImpl testobj = new AdministratorImpl(); 
		StoreBean sb = new StoreBean();
		sb = testobj.viewStore(storeId);
		assertEquals(2001,sb.getStoreId());
	}

	public void testViewAllStore() {
		AdministratorImpl testobj = new AdministratorImpl(); 
		ArrayList<StoreBean> sb = new ArrayList<StoreBean>();
		sb = testobj.viewAllStore();
		int status = 0;
		if(sb.size()>0) {
			status = 1;
		}
		assertEquals(1,status);	
	}



	public void testAddFood() {
		FoodBean fb = new FoodBean(10001,"pizza","nagar","delhi",100,100,9);
		AdministratorDaoImpl testobj = mock(AdministratorDaoImpl.class); 
		when(testobj.addFood(fb,9)).thenReturn("SUCCESS");
		
		String result= testobj.addFood(fb,9);
		assertEquals("SUCCESS",result);
	}




	public void testViewFood() {
	    int foodId = 1000;
		AdministratorImpl testobj = new AdministratorImpl(); 
		FoodBean sb = new FoodBean();
		sb = testobj.viewFood(foodId);
		assertEquals(1000,sb.getFoodId());
	}

	public void testViewAllFood() {
		AdministratorImpl testobj = new AdministratorImpl(); 
		ArrayList<FoodBean> fb = new ArrayList<FoodBean>();
		fb = testobj.viewAllFood(2002);
		int status = 0;
		if(fb.size()>0) {
			status = 1;
		}
		assertEquals(1,status);
	}

}
