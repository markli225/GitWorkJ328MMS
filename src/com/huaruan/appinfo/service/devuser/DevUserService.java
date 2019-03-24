package com.huaruan.appinfo.service.devuser;

import com.huaruan.appinfo.pojo.DevUser;

public interface DevUserService {

	/**
	 * 开发者登录
	 * @param devCode
	 * @param devPassword
	 * @return
	 * @throws Exception
	 */
	DevUser login(String devCode, String devPassword) throws Exception;

}
