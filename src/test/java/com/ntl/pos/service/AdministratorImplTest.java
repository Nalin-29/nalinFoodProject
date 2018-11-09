package com.ntl.pos.service;

import java.util.ArrayList;

import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.dao.impl.AdministratorDaoImpl;
import com.ntl.pos.service.impl.AdministratorImpl;

import junit.framework.TestCase;
//import junit.framework.TestCase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AdministratorImplTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAddStore() {
		StoreBean sb = new StoreBean(0,"NIIT Pizza","abc","9876543210","Gr Noida","UP","136119");
	    AdministratorDaoImpl testobj = mock(AdministratorDaoImpl.class); 
	    AdministratorImpl admin = new AdministratorImpl(testobj);
	    when(admin.addStore(sb)).thenReturn("SUCCESS");
		String result= admin.addStore(sb);
		assertEquals("SUCCESS",result);
	}

	public void testModifyStore() {
		StoreBean sb = new StoreBean(5,"NIIT Pizza","abc","9876543210","Gr Noida","UP","136119");
	    AdministratorDaoImpl testobj = mock(AdministratorDaoImpl.class); 
	    AdministratorImpl admin = new AdministratorImpl(testobj);
	    when(admin.modifyStore(sb)).thenReturn(true);
	 	
		boolean result= admin.modifyStore(sb);
		assertEquals(true,result);
	}



	public void testViewStore() {
		 String id = "2002";
		// sb.getStoreId();
		 AdministratorImpl ap = new AdministratorImpl();
		 StoreBean result = ap.viewStore(id);
		 assertEquals(2002, result.getStoreId());
	}

	public void testViewAllStore() {
		AdministratorImpl ap = new AdministratorImpl();
		ArrayList<StoreBean> result = ap.viewAllStore();
		
		int flag =0;
		if(result.size()>0)
		{
			flag=1;
		}
		
		 assertEquals(1, flag);
		
	}

	public void testAddFood() {
		FoodBean fb = new FoodBean(100,"test","test","test",100,100,4);
		AdministratorDaoImpl testobj = mock(AdministratorDaoImpl.class); 
	    AdministratorImpl admin = new AdministratorImpl(testobj);
		when(admin.addFood(fb,4)).thenReturn("SUCCESS");
		
		String result= admin.addFood(fb,4);
		assertEquals("SUCCESS",result);
	}

	

	public void testViewFood() {
		 int id = 1000;
			// sb.getStoreId();
			 AdministratorImpl ap = new AdministratorImpl();
			 FoodBean result = ap.viewFood(id);
			 assertEquals(1000, result.getFoodId());
	}

	public void testViewAllFood() {
		int id = 2002;
		AdministratorImpl ap = new AdministratorImpl();
		ArrayList<FoodBean> result = ap.viewAllFood(id);
		
		int flag =0;
		if(result.size()>0)
		{
			flag=1;
		}
		
		 assertEquals(1, flag);
	}

}
