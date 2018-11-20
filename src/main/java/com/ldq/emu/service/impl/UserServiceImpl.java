package com.ldq.emu.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ldq.emu.dao.UserMapper;
import com.ldq.emu.entity.User;
import com.ldq.emu.service.UserService;
import com.ldq.emu.utils.EasyUI;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public EasyUI userLogin(HttpSession session, String loginName, String loginPasswd) {
		
		User user = userMapper.selectByLoginName(loginName);
		if(user == null)
			return EasyUI.loginMsg(false, "用户不存在.",null);
		
		if( ! user.getLoginPasswd().equals(loginPasswd))
			return EasyUI.loginMsg(false, "密码不正确.",null);
		session.setAttribute("user", user);
		return EasyUI.loginMsg(true, "验证成功.",user.getUserName());
	}

	@Override
	public EasyUI userList(User user, int page, int rows) {
		
		PageList<User> users = userMapper.userList(user,new PageBounds(page, rows));
		
		if(users != null)
			return EasyUI.data(users.getPaginator().getTotalCount(), users);
		
		return EasyUI.data(0, null);
	}

	@Override
	public EasyUI delUser(String userid) {
		
		if(userid == null || userid == "")
			return EasyUI.cudMsg(false, "删除失败");
		
		for(String id : userid.split(",")) {
			
			if(userMapper.deleteByPrimaryKey(Integer.parseInt(id)) == 0)
				return EasyUI.cudMsg(false, "删除失败");
		}
		
		return EasyUI.cudMsg(true, "删除成功");
		
	}

	@Override
	public EasyUI addUser(User user) {
		
		if(userMapper.selectByLoginName(user.getLoginName()) != null ) {

			return EasyUI.cudMsg(false, user.getLoginName()+" 登录名已被占用");
		}
		
		if(userMapper.insert(user) != 0)
			return EasyUI.cudMsg(true, "添加成功");
		
		return EasyUI.cudMsg(false, "添加失败");
	}

	@Override
	public EasyUI updUser(User user) {
		
		if(userMapper.updateByPrimaryKey(user) != 0)
			return EasyUI.cudMsg(true, "修改成功");
		
		return EasyUI.cudMsg(false, "修改失败");
	}

	@Override
	public List<User> userCombobox() {
		
		return userMapper.userCombobox();
		
	}

	@Override
	public EasyUI updUserPasswd(User user, String oldLoginPasswd) {
		
		oldLoginPasswd = DigestUtils.md5DigestAsHex(oldLoginPasswd.getBytes());
		System.out.println(oldLoginPasswd+"<<<<<<>>>>>>>>>>>");
		User u = userMapper.selectByLoginName(user.getLoginName());
		System.out.println(u.getLoginPasswd()+"<<<<<<>>>>>>>>>>>");
		if(u.getLoginPasswd().equals(oldLoginPasswd)) {
			String loginPasswd = DigestUtils.md5DigestAsHex(user.getLoginPasswd().getBytes());
			u.setLoginPasswd(loginPasswd);
			if(userMapper.updateByPrimaryKeySelective(u) != 0)
				return EasyUI.cudMsg(true, "修改成功");
			else
				return EasyUI.cudMsg(false, "修改失败");
		}else
			return EasyUI.cudMsg(false, "旧密码不正确");
	}
}
