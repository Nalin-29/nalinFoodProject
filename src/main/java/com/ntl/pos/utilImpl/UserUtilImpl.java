package com.ntl.pos.utilImpl;

import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.ProfileBean;
import com.ntl.pos.dao.profiledao;
import com.ntl.pos.dao.impl.ProfileDaoClass;
import com.ntl.pos.util.user;

public class UserUtilImpl implements user {

	profiledao pd= new ProfileDaoClass();

	public UserUtilImpl(ProfileDaoClass testobj) {
		// TODO Auto-generated constructor stub
		this.pd = testobj;
	}

	public UserUtilImpl() {
		// TODO Auto-generated constructor stub
	}

	//@Override
	public String logIn(CredentialsBean credentialsBean) {
		// TODO Auto-generated method stub
	//	System.out.println("Login");
		AuthenticationImpl au = new AuthenticationImpl();
	    if(au.authenticate(credentialsBean)) {
	    return au.authorize(credentialsBean.getUserId());
	   }
		return null;
	}

	//@Override
	public boolean logout(String userId) {
		// TODO Auto-generated method stub
		return false;
	}
 
	//@Override
	public String register(ProfileBean profileBean) {
		// TODO Auto-generated method stub
		System.out.println(profileBean.toString());
		return pd.createProfile(profileBean);
	}

	

}
