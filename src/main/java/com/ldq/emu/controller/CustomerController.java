package com.ldq.emu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldq.emu.entity.Customer;
import com.ldq.emu.service.CustomerService;
import com.ldq.emu.utils.EasyUI;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/cusCombobox")
	public List<Customer> cusCombobox(){
		
		return customerService.cusCombobox();
	}
	
	@RequestMapping("/customerList")
	public EasyUI customerList(Customer customer, int page, int rows){
		
		System.out.println("执行查找客户列表操作>>>>>>>>>>>>>");
		return customerService.CustomerList(customer, page, rows);
	}
	
	@RequestMapping("/addCustomer")
	public EasyUI addCustomer(Customer customer){
		
		System.out.println("执行添加客户信息操作>>>>>>>>>>>>>>");
		return customerService.addCustomer(customer);
	}
	
	@RequestMapping("/delCustomer")
	public EasyUI delCustomer(String cusId){
		
		System.out.println("执行删除客户信息操作>>>>>>>>>>>>>>");
		return customerService.delCustomer(cusId);
	}
	
	@RequestMapping("/updCustomer")
	public EasyUI updCustomer(Customer customer){
		
		System.out.println("执行修改客户信息操作>>>>>>>>>>>>>>");
		return customerService.updCustomer(customer);
	}
	
}
