package com.ldq.emu.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ldq.emu.entity.Department;

public interface DepartmentMapper {
	/**
	 * 通过主键删除部门
	 * @param depId
	 * @return 1 or 0
	 */
    int deleteByPrimaryKey(Integer depId);
    /**
     * 添加部门信息
     * @param record
     * @return 1 or 0
     */
    int insert(Department record);
    /**
     * 添加部门信息 （非空判断）
     * @param record
     * @return 1 or 0
     */
    int insertSelective(Department record);
    /**
     * 通过主键查询部门
     * @param depId
     * @return 查询结果的部门信息
     */
    Department selectByPrimaryKey(Integer depId);
    /**
     * 通过主键修改部门信息（非空判断）
     * @param record
     * @return 0 or 1 
     */
    int updateByPrimaryKeySelective(Department record);
    /**
     * 通过主键修改部门信息
     * @param record
     * @return 0 or 1
     */
    int updateByPrimaryKey(Department record);
    /**
     * 通过部门名称查找部门
     * @param depName
     * @return 查询结果的部门信息
     */
    Department selectByName(String depName);
    /**
     * 查询所有部门信息
     * @return 所有部门信息
     */
    List<Department> depCombobox();
    /**
     * 查询所有员工列表
     * @param department
     * @param pageBounds
     * @return
     */
    PageList<Department> departmentList(Department department, PageBounds pageBounds);
}