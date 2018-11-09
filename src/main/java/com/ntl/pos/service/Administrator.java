package com.ntl.pos.service;

import java.util.ArrayList;

import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.StoreBean;

public interface Administrator {
  
	String addStore(StoreBean storeBean);
	boolean modifyStore(StoreBean storebean);
	
	StoreBean viewStore(String storeId);
	ArrayList <StoreBean> viewAllStore();
	
	String addFood(FoodBean foodBean,int storeId);
	boolean modifyFood(FoodBean foodbean);
	
	FoodBean viewFood(int foodId);
	ArrayList <FoodBean> viewAllFood(int StoreId);
}
