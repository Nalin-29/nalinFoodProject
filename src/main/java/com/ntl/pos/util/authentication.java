package com.ntl.pos.util;

import com.ntl.pos.bean.CredentialsBean;

public interface authentication {
	public boolean authenticate(CredentialsBean credentialsBean);
	public String authorize(String userId);
	public boolean changeloginStatus(CredentialsBean credentialsBean,int loginStatus);

}
