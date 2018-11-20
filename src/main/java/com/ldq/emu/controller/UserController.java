package com.ldq.emu.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldq.emu.entity.User;
import com.ldq.emu.service.UserService;
import com.ldq.emu.utils.EasyUI;

import lombok.extern.slf4j.Slf4j;
/**
 * 用户视图控制器
 * @author 叶宏杰
 *
 */
@Controller
@Slf4j
public class UserController {
	/**
	 * 注入UserService
	 */
	@Autowired
	private UserService userService;
	/**
	 * 用户登录验证
	 * @param session 会话
	 * @param loginName 账号
	 * @param loginPasswd 密码
	 * @return json
	 */
	@RequestMapping("/userLogin")
	@ResponseBody
	public EasyUI userLogin(HttpSession session, String loginName,String loginPasswd){
		
		log.info(">>>>>>>>>调用/userLogi接口");
		loginPasswd = DigestUtils.md5DigestAsHex(loginPasswd.getBytes());
		return userService.userLogin(session,loginName, loginPasswd);	
	}
	/**
	 * 查询用户信息
	 * @param user 用户
	 * @param page 当前页 easyui默认名称
	 * @param rows 每页显示条数easyui默认名称
	 * @return json
	 */
	@PostMapping("/userList")
	@ResponseBody
	public EasyUI userList(User user, int page, int rows){
		return userService.userList(user, page, rows);
		
	}
	/**
	 * 删除用户信息
	 * @param userId 用户id
	 * @return json
	 */
	@RequestMapping("/delUser")
	@ResponseBody
	public Map<String,Object> delUser(String userId){
		return userService.delUser(userId);
	}
	/**
	 * 添加用户信息
	 * @param user 用户信息
	 * @return json
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public Map<String, Object> addUser(User user){
		String password = DigestUtils.md5DigestAsHex(user.getLoginPasswd().getBytes());
		user.setLoginPasswd(password);
		return userService.addUser(user);
	}
	/**
	 * 修改用户信息
	 * @param user 用户信息
	 * @return json
	 */
	@RequestMapping("/updUser")
	@ResponseBody
	public Map<String,Object> updUser(User user){
		return userService.updUser(user);
	}
	/**
	 * 查询所有用户
	 * @return
	 */
	@RequestMapping("/userCombobox")
	@ResponseBody
	public List<User> userCombobox(){
		return userService.userCombobox();
	}

	/**
	 * 跳转到index.html页面
	 * @param session
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpSession session) {
		return "index";
	}
	
	/**
	 * 跳转到index.html页面
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		if(session.getAttribute("user") != null) {
			session.removeAttribute("user");
		}
		return index(session);
		
	}
	
	@RequestMapping("/updUserPasswd")
	@ResponseBody
	public EasyUI updUserPasswd(User user,String oldLoginPasswd){
		return userService.updUserPasswd(user,oldLoginPasswd);
	}
}
