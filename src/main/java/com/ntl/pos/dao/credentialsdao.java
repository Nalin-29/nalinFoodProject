package com.ntl.pos.dao;

import java.util.ArrayList;

import com.ntl.pos.bean.CredentialsBean;


public interface credentialsdao {

 public String createProfile(CredentialsBean credentialsBean);
	 
	 int deleteProfile(ArrayList<String> profile);
	 
	 boolean updateProfile(CredentialsBean profileBean);
	 
	 CredentialsBean findByID(String userID);
	 
	 ArrayList <CredentialsBean> findAll();

}
