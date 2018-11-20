package com.ldq.emu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ldq.emu.entity.User;
import com.ldq.emu.utils.EasyUI;

public interface UserService {
	/**
	 * 用户登陆验证
	 * @param loginName 用户名
	 * @param loginPassword 密码
	 * @return
	 */
	public EasyUI userLogin(HttpSession session, String loginName,String loginPassword); 
	/**
	 * 查询用户列表
	 * @param user 用户实体
	 * @param page 页数
	 * @param rows 每页显示条数
	 * @return
	 */
	public EasyUI userList(User user, int page, int rows);
	/**
	 * 删除用户信息
	 * @param userid 用户id
	 * @return
	 */
	public EasyUI delUser(String userId);
	/**
	 * 添加用户信息
	 * @param user 
	 * @return
	 */
	public EasyUI addUser(User user);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public EasyUI updUser(User user);
	/**
	 * 查询所有用户信息
	 * @return
	 */
	List<User> userCombobox();
	public EasyUI updUserPasswd(User user, String oldLoginPasswd);
}
