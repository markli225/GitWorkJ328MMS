package com.huaruan.appinfo.service.devuser;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaruan.appinfo.dao.devuser.DevUserMapper;
import com.huaruan.appinfo.pojo.DevUser;

@Service
public class DevUserServiceImpl implements DevUserService {

	@Resource
	private DevUserMapper devUserMapper;
	
	@Override
	public DevUser login(String devCode, String devPassword) throws Exception {
		DevUser devUser = devUserMapper.getDevUserByDevCode(devCode);
		if(null != devUser && !(devUser.getDevPassword().equals(devPassword))) {
			devUser = null;
		}
		return devUser;
	}

}
