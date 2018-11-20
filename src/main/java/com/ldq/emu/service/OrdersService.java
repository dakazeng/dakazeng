package com.ldq.emu.service;

import java.lang.reflect.InvocationTargetException;

import com.ldq.emu.entity.OrdersCustom;
import com.ldq.emu.utils.EasyUI;

public interface OrdersService {
	/**
	 * 查询订单、员工、客户、部门列表
	 * @param ordersCustom
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUI orderList(OrdersCustom ordersCustom, int page, int rows);
	/**
	 * 添加订单信息
	 * @param ordersCustom
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	EasyUI addOrder(OrdersCustom ordersCustom) throws IllegalAccessException, InvocationTargetException;
	/**
	 * 修改订单信息
	 * @param ordersCustom
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	EasyUI updOrder(OrdersCustom ordersCustom) throws IllegalAccessException, InvocationTargetException;
	
	EasyUI delOrder(String ordersId);
}
