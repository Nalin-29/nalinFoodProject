package com.ntl.pos.util;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.ProfileBean;

public interface user {
	
	String logIn(CredentialsBean credentialsBean);
	boolean logout(String userId);
	public String register(ProfileBean profileBean);
	
}