package com.ldq.emu.service;

import java.util.List;

import com.ldq.emu.entity.Department;
import com.ldq.emu.entity.Employee;
import com.ldq.emu.entity.EmployeeCustom;
import com.ldq.emu.entity.Position;
import com.ldq.emu.utils.EasyUI;

/**
 * 员工业务控制器接口
 * @author 叶宏杰
 *
 */
public interface EmployeeService {
	/**
	 * 查询员工列表并分页
	 * @param employeeDepartment
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUI employeeList(EmployeeCustom employeeCustom, int page, int rows);
	/**
	 * 添加员工信息
	 * @param employee
	 * @return EasyUI
	 */
	EasyUI addEmployee(Employee employee);
	/**
	 * 通过部门名称查找部门
	 * @param depName
	 * @return 查询结果的部门信息
	 */
	Department selectByName(String depName);
	/**
	 * 删除员工信息
	 * @param empId
	 * @return
	 */
	EasyUI delEmployee(String empId);
	/**
	 * 修改员工信息
	 * @param employee
	 * @return
	 */
	EasyUI updEmployee(Employee employee);
	/**
	 * 查询所有部门信息
	 * @return 所有部门信息
	 */
	List<Department> depCombobox();
	/**
	 * 查询所有职位信息
	 * @return
	 */
	List<Position> posCombobox(); 
	/**
	 * 查询所有员工信息
	 * @return
	 */
	List<Employee> empCombobox();
	
	
}
