package com.ntl.pos.dao;

import java.util.ArrayList;

import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.StoreBean;

public interface UserDao {
	
	String confirmOrder(OrderBean ob);
	
	ArrayList<StoreBean> viewAllStore();
	public StoreBean viewStore(String storeId);

	public ArrayList<FoodBean> viewAllFood(int storeId);
	
	public FoodBean viewFood(int foodId);
	

	
	ArrayList <OrderBean> viewOrder(int userid);

}
