package com.ldq.emu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldq.emu.entity.Department;
import com.ldq.emu.service.DepartmentService;
import com.ldq.emu.utils.EasyUI;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/departmentList")
	public EasyUI departmentList(Department department, int page, int rows) {
		
		return departmentService.departmentList(department, page, rows);
	}
	
	@RequestMapping("/addDepartment")
	public EasyUI addDepartment(Department department) {
		
		return departmentService.addDepartment(department);
	}
	
	@RequestMapping("/delDepartment")
	public EasyUI delDepartment(String depId) {
		
		return departmentService.delDepartment(depId);
	}
	
	@RequestMapping("/updDepartment")
	public EasyUI updDepartment(Department department) {
		
		return departmentService.updDepartment(department);
	}
}
