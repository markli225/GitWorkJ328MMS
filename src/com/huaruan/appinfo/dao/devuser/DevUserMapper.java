package com.huaruan.appinfo.dao.devuser;

import org.apache.ibatis.annotations.Param;

import com.huaruan.appinfo.pojo.DevUser;

public interface DevUserMapper {

	/**
	 * 根据开发者编号查询开发者信息
	 * @param devCode
	 * @return
	 */
	DevUser getDevUserByDevCode(@Param("devCode")String devCode) throws Exception;
	
}
