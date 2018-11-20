package com.ldq.emu.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ldq.emu.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /**
     * 通过用户名查找用户
     * @param loginName
     * @return
     */
    User selectByLoginName(String loginName);
    /**
     * 查询用户列表并分页
     * @param user
     * @param pageBounds
     * @return
     */
    PageList<User> userList(User user, PageBounds pageBounds);
    /**
     * 查询所有用户
     * @return
     */
    List<User> userCombobox();
}