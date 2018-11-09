package com.ntl.pos.dao;

import java.util.ArrayList;

import com.ntl.pos.bean.ProfileBean;

public interface profiledao {
	
	 public String createProfile(ProfileBean profileBean);
	 
	 int deleteProfile(ArrayList<String> profile);
	 
	 boolean updateProfile(ProfileBean profileBean);
	 
	 ProfileBean findByID(String userID);
	 
	 ArrayList <ProfileBean> findAll();

}
