package com.ldq.emu.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ldq.emu.entity.Department;
import com.ldq.emu.entity.Employee;
import com.ldq.emu.entity.EmployeeCustom;
import com.ldq.emu.entity.Position;
import com.ldq.emu.service.EmployeeService;
import com.ldq.emu.utils.EasyUI;
import com.ldq.emu.utils.HJUtils;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	/**
	 * 查询员工列表
	 * @param employeeCustom
	 * @param page
	 * @param rows
	 * @return
	 */
	@PostMapping("/employeeList")
	public EasyUI employeeList(EmployeeCustom employeeCustom, int page, int rows) {
		return employeeService.employeeList(employeeCustom, page, rows);
	}
	/**
	 * 添加员工信息
	 * @param employeeCustom
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("/addEmployee")
	public EasyUI addEmployee(EmployeeCustom employeeCustom) throws IllegalAccessException, InvocationTargetException {
		
		Employee employee = new Employee();
		BeanUtils.copyProperties(employee, employeeCustom);//把employeeCustom的值赋给employee
		Department department = employeeService.selectByName(employeeCustom.getDepName());
		employee.setDno(department.getDepId());
		employee.setIsDelete("0");
		//System.out.println("部门id"+department.getDepId());
		//System.out.println("添加员工>>>>>>>>"+employee.getEmpSex());
		return employeeService.addEmployee(employee);
	}
	/**
	 * 删除员工信息
	 * @param empId
	 * @return
	 */
	@RequestMapping("/delEmployee")
	public EasyUI delEmployee(String empId) {
		return employeeService.delEmployee(empId);
	}
	/**
	 * 修改员工信息
	 * @param employeeCustom
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("/updEmployee")
	public EasyUI updEmployee(@RequestParam Map<String,Object> map) {

		Integer id = Integer.parseInt(map.get("empId").toString());
		map.put("empId", id);
		Department department = employeeService.selectByName(map.get("depName").toString());
		map.put("dno", department.getDepId());
		map.put("isDelete", "0");
		Employee employee = new Employee();
		employee = (Employee) HJUtils.map2Object(map, Employee.class);
		System.out.println("修改员工信息>>>>>>>>"+HJUtils.map2Object(map, Employee.class));
		return employeeService.updEmployee(employee);
	}
	/**
	 * 查询所有部门
	 * @return
	 */
	@RequestMapping("/depCombobox")
	public List<Department> depCombobox(){
		return employeeService.depCombobox();
	}
	/**
	 * 查询所有职位信息
	 * @return
	 */
	@RequestMapping("/posCombobox")
	public List<Position> posCombobox(){
		return employeeService.posCombobox();
	}
	@RequestMapping("/empCombobox")
	public List<Employee> empCombobox(){
		return employeeService.empCombobox();
	}
}
