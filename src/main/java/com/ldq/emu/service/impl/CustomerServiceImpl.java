package com.ldq.emu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ldq.emu.dao.CustomerMapper;
import com.ldq.emu.dao.OrdersMapper;
import com.ldq.emu.entity.Customer;
import com.ldq.emu.service.CustomerService;
import com.ldq.emu.utils.EasyUI;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Override
	public List<Customer> cusCombobox() {
		return customerMapper.cusCombobox();
	}
	
	@Override
	public EasyUI CustomerList(Customer customer, int page, int rows) {
		
		if(customer.getCreatDateStart() != null && customer.getCreatDateEnd() != null) {
			
			String creatDateStart = customer.getCreatDateStart().trim();
			String creatDateEnd = customer.getCreatDateEnd().trim();
			System.out.println(creatDateStart);
			customer.setCreatDateStart(creatDateStart);
			customer.setCreatDateEnd(creatDateEnd);
		}
		PageList<Customer> customers = customerMapper.CustomerList(customer, new PageBounds(page, rows));
		if(customers != null)
			return EasyUI.data(customers.getPaginator().getTotalCount(), customers);
		return EasyUI.data(0, null);
		
	}
	
	@Override
	public EasyUI addCustomer(Customer customer) {
		
		if(customerMapper.insertSelective(customer) != 0)
			return EasyUI.cudMsg(true, "添加成功");
		return EasyUI.cudMsg(false, "添加失败");
		
	}

	@Override
	public EasyUI delCustomer(String cusId) {
		
		if(cusId == null || cusId == "")
			return EasyUI.cudMsg(false, "删除失败");
		for(String id : cusId.split(",")) {
			if(ordersMapper.selectByCno(Integer.parseInt(id)).size() == 0) {
				if(customerMapper.deleteByPrimaryKey(Integer.parseInt(id)) == 0)
					return EasyUI.cudMsg(false, "删除失败");
			}else
				return EasyUI.cudMsg(false, "有该客户的订单，暂时不能删除");
		}
		return EasyUI.cudMsg(true, "删除成功");
		
	}

	@Override
	public EasyUI updCustomer(Customer customer) {
		if(customerMapper.updateByPrimaryKeySelective(customer) != 0)
			return EasyUI.cudMsg(true, "修改成功");
		return EasyUI.cudMsg(false, "修改失败");
	}
}
