package com.ldq.emu.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ldq.emu.entity.Orders;
import com.ldq.emu.entity.OrdersCustom;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    /**
     * 查询订单、员工、部门、客户列表信息
     * @param ordersCustom
     * @param pageBounds
     * @return
     */
    PageList<OrdersCustom> orderList(OrdersCustom ordersCustom,PageBounds pageBounds);
    /**
     * 通过客户id查找订单
     * @param cno
     * @return
     */
	List<Orders> selectByCno(Integer cno);
	/**
	 * 通过部门id查询订单
	 * @param dno
	 * @return
	 */
	List<Orders> selectByDno(int dno);
	
	/**
	 * 通过员工id查询订单
	 * @param parseInt
	 * @return
	 */
	List<Orders> selectByEno(int eno);


	
}