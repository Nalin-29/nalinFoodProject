package com.ntl.pos.service.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.dao.impl.AdministratorDaoImpl;
import com.ntl.pos.service.Administrator;

import client.Pizza;
import jdk.internal.jline.internal.Log;

public class AdministratorImpl implements Administrator {
	static Logger log=Logger.getLogger(AdministratorImpl.class);
	AdministratorDaoImpl adminDaoImpl=new AdministratorDaoImpl();
	StoreBean storeBean = new StoreBean();

	public AdministratorImpl(AdministratorDaoImpl testobj) {
		// TODO Auto-generated constructor stub
		this.adminDaoImpl = testobj;
	}

	public AdministratorImpl() {
		// TODO Auto-generated constructor stub
	}

	//@Override
	public String addStore(StoreBean storeBean) {
		// TODO Auto-generated method stub
		//Log.info("Inside add store in service");
		String result= adminDaoImpl.addStore(storeBean);
		return result;
	}

	//@Override
	public boolean modifyStore(StoreBean storebean) {
		// TODO Auto-generated method stub
		//Log.info("Inside modify store in service");
		boolean result=adminDaoImpl.modifyStore(storebean);
		return result;
	}

	

	//@Override
	public StoreBean viewStore(String storeId) {
		// TODO Auto-generated method stub
		//System.out.println("StoreId - " + storeId);
		StoreBean sb =adminDaoImpl.viewStore(storeId);
		return sb;
	}

	//@Override
	public ArrayList<StoreBean> viewAllStore() {
		// TODO Auto-generated method stub
	//	Log.info("inside ViewAll Store in service");
		ArrayList<StoreBean> sb=  adminDaoImpl.viewAllStore();
		return sb;
	}

	//@Override
	public String addFood(FoodBean foodBean,int storeId) {
		// TODO Auto-generated method stub
	//	Log.info("Inside AddFood in service");
		String result=adminDaoImpl.addFood(foodBean, storeId);
		return result;
	}

	//@Override
	public boolean modifyFood(FoodBean foodbean) {
		// TODO Auto-generated method stub
	//	Log.info("Inside modifyFood in service");
		boolean result=adminDaoImpl.modifyFood(foodbean);
		return result;
	}

	

	//@Override
	public FoodBean viewFood(int foodId) {
		// TODO Auto-generated method stub
	//	Log.info("Inside ViewFood in service");
		FoodBean fb =new FoodBean();
		fb=adminDaoImpl.viewFood(foodId);
		return fb;
	}

	//@Override
	public ArrayList<FoodBean> viewAllFood(int storeId) {
		// TODO Auto-generated method stub
	//	Log.info("Inside ViewAll Food in service");
		ArrayList<FoodBean> fb =adminDaoImpl.viewAllFood(storeId);
		return fb;
	}

	
}
