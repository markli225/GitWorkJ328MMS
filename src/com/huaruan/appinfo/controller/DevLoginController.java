package com.huaruan.appinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.startup.UserConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huaruan.appinfo.contants.UserConstants;
import com.huaruan.appinfo.pojo.DevUser;
import com.huaruan.appinfo.service.devuser.DevUserService;

@Controller
public class DevLoginController {

	@Resource
	private DevUserService devUserService;
	
	/**
	 * 开发者首页
	 * @return
	 */
	@RequestMapping(value="/dev/main",method=RequestMethod.GET)
	public String toDevMain() {
		return "developer/main";
	}
	
	/**
	 * 开发者登录
	 * @param devCode
	 * @param devPassword
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/dev/dologin",method=RequestMethod.POST)
	public String doDevLogin(@RequestParam String devCode,
			                 @RequestParam String devPassword,HttpServletRequest request) throws Exception {
		DevUser devUser = devUserService.login(devCode,devPassword);
		if(null == devUser) {
			request.setAttribute("error", "开发者帐号或密码有误！");
			return "devlogin";
		}
		request.getSession().setAttribute(UserConstants.DEV_USER_SESSION, devUser);
		return "redirect:/dev/main";
	}
	
	/**
	 * 跳转到开发者登录窗口
	 * @return
	 */
	@RequestMapping(value="/dev/login",method=RequestMethod.GET)
	public String toDevLogin() {
		return "devlogin";
	}
	
}
