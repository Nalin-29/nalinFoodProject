package com.ntl.pos.dao;

import java.util.ArrayList;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.service.impl.AdministratorImpl;
import com.ntl.pos.service.impl.UserImpl;
import com.ntl.pos.util.user;

import junit.framework.TestCase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserDaoImplTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}



	

	public void testViewAllStore() {
		UserImpl testobj = new UserImpl(); 
		ArrayList<StoreBean> sb = new ArrayList<StoreBean>();
		sb = testobj.viewAllStore();
		int status = 0;
		if(sb.size()>0) {
			status = 1;
		}
		assertEquals(1,status);	
		
	}

	public void testViewStore() {
		String storeId = "2001";
		UserImpl testobj = new UserImpl(); 
		StoreBean sb = new StoreBean();
		sb = testobj.viewStore(storeId);
		assertEquals(2001,sb.getStoreId());
	}

	public void testViewFood() {
		int foodId = 1000;
		UserImpl testobj = new UserImpl(); 
		FoodBean sb = new FoodBean();
		sb = testobj.viewFood(foodId);
		assertEquals(1000,sb.getFoodId());
	}

	public void testViewAllFood() {
		UserImpl testobj = new UserImpl(); 
		ArrayList<FoodBean> fb = new ArrayList<FoodBean>();
		fb = testobj.viewAllFood(2002);
		int status = 0;
		if(fb.size()>0) {
			status = 1;
		}
		assertEquals(1,status);	
	}



	
}
