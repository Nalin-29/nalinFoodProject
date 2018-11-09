package com.ntl.pos.service.impl;

import java.util.ArrayList;

import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.dao.impl.UserDaoImpl;
import com.ntl.pos.service.User;
import com.ntl.pos.utilImpl.UserUtilImpl;

public class UserImpl implements User {
	
	UserDaoImpl userDao = new UserDaoImpl();

	public UserImpl(UserUtilImpl testobj) {
		// TODO Auto-generated constructor stub
	}

	public UserImpl() {
		// TODO Auto-generated constructor stub
	}

	public UserImpl(UserDaoImpl testobj) {
		// TODO Auto-generated constructor stub
		this.userDao =testobj;
	}

	////@Override
	public String confirmOrder(OrderBean ob) {
		// TODO Auto-generated method stub
		String result = userDao.confirmOrder(ob);
		return result;
	}

	

	////@Override
	public ArrayList<StoreBean> viewAllStore() {
		// TODO Auto-generated method stub
		ArrayList<StoreBean> result =  userDao.viewAllStore();
		return result;
	}

	

	

	//@Override
	public ArrayList<OrderBean> viewOrder(int userid) {
		// TODO Auto-generated method stub
		ArrayList<OrderBean> result = userDao.viewOrder(userid);
		return result;
	}

	//@Override
	public StoreBean viewStore(String storeId) {
		// TODO Auto-generated method stub
		//System.out.println("StoreId - " + storeId);
		StoreBean result = userDao.viewStore(storeId);
		return result;
	}

	//@Override
	public ArrayList<FoodBean> viewAllFood(int storeId) {
		// TODO Auto-generated method stub
		ArrayList<FoodBean> result =userDao.viewAllFood(storeId);
		return result;
	}

	//@Override
	public FoodBean viewFood(int foodId) {
		// TODO Auto-generated method stub
		FoodBean result = userDao.viewFood(foodId);
		return result;
	}

}
