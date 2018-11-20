package com.ldq.emu.service;

import com.ldq.emu.entity.Department;
import com.ldq.emu.utils.EasyUI;

public interface DepartmentService {
	/**
	 * 查询部门列表
	 * @param department
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUI departmentList(Department department, int page, int rows);
	/**
	 * 添加部门信息
	 * @param department
	 * @return
	 */
	EasyUI addDepartment(Department department);
	/**
	 * 删除部门信息
	 * @param department
	 * @return
	 */
	EasyUI delDepartment(String depId);
	/**
	 * 修改部门信息
	 * @param department
	 * @return
	 */
	EasyUI updDepartment(Department department);
}
