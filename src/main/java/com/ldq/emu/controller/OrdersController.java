package com.ldq.emu.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldq.emu.entity.OrdersCustom;
import com.ldq.emu.service.OrdersService;
import com.ldq.emu.utils.EasyUI;

@RestController
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping("/orderList")
	public EasyUI orderList(OrdersCustom ordersCustom, int page, int rows) {
		
		System.out.println("执行查询订单列表操作>>>>>>>>>>>>>>");
		return ordersService.orderList(ordersCustom, page, rows);
	}
	
	@RequestMapping("/addOrder")
	public EasyUI addOrder(OrdersCustom ordersCustom) throws IllegalAccessException, InvocationTargetException {
		
		System.out.println("执行添加订单操作>>>>>>>>>>>>>>>>");
		return ordersService.addOrder(ordersCustom);
	}
	
	@RequestMapping("/delOrder")
	public EasyUI delOrder(String orderId) {

		System.out.println("执行删除订单操作>>>>>>>>>>>>>>>>");
		return ordersService.delOrder(orderId);
	}
	
	@RequestMapping("/updOrder")
	public EasyUI updOrder(OrdersCustom ordersCustom) throws IllegalAccessException, InvocationTargetException {
		
		System.out.println("执行修改订单操作>>>>>>>>>>>>>>>>");
		return ordersService.updOrder(ordersCustom);
	}
	
}
