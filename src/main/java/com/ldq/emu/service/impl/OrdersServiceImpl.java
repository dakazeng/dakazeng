package com.ldq.emu.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ldq.emu.dao.CustomerMapper;
import com.ldq.emu.dao.EmployeeMapper;
import com.ldq.emu.dao.OrdersMapper;
import com.ldq.emu.entity.Customer;
import com.ldq.emu.entity.Employee;
import com.ldq.emu.entity.Orders;
import com.ldq.emu.entity.OrdersCustom;
import com.ldq.emu.service.OrdersService;
import com.ldq.emu.utils.EasyUI;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public EasyUI orderList(OrdersCustom ordersCustom, int page, int rows) {
		PageList<OrdersCustom> orders = ordersMapper.orderList(ordersCustom, new PageBounds(page, rows));
		if(orders != null) {
			return EasyUI.data(orders.getPaginator().getTotalCount(), orders);
		}
		return EasyUI.data(0, null);
	}
	@Override
	public EasyUI addOrder(OrdersCustom ordersCustom) throws IllegalAccessException, InvocationTargetException {
		
		Orders order = new Orders();
		BeanUtils.copyProperties(order, ordersCustom);//把ordersCustom的值赋给order
		Integer empId = Integer.parseInt(ordersCustom.getEmpName());
		Integer cusId = Integer.parseInt(ordersCustom.getCusName());
		Customer customer = customerMapper.selectByPrimaryKey(cusId);
		Employee employee = employeeMapper.selectByPrimaryKey(empId);
		order.setCno(cusId);
		order.setEno(empId);
		order.setDno(employee.getDno());
		order.setCompany(customer.getCusAddr());
		order.setOrderNumber("0"+cusId+new SimpleDateFormat("ssmmHHyyMMdd").format(new Date()));
		order.setCreationTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		order.setEndEditTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		if(ordersMapper.insertSelective(order) != 0)
			return EasyUI.cudMsg(true, "添加成功");
		return EasyUI.cudMsg(false, "添加失败");
	}
	@Override
	public EasyUI updOrder(OrdersCustom ordersCustom) throws IllegalAccessException, InvocationTargetException {
		
		Orders order = new Orders();
		BeanUtils.copyProperties(order, ordersCustom);//把ordersCustom的值赋给order
		if(isInteger(ordersCustom.getEmpName())) {
			
			Integer empId = Integer.parseInt(ordersCustom.getEmpName());
			//通过员工empId查询部门外键dno
			Employee employee = employeeMapper.selectByPrimaryKey(empId);
			order.setDno(employee.getDno());
			order.setEno(empId);
		}else {
			order.setEno(null);
			order.setDno(null);
		}
		if(isInteger(ordersCustom.getCusName())) {
			
			Integer cusId = Integer.parseInt(ordersCustom.getCusName());
			//通过客户主键查询客户地址（单位）
			Customer customer = customerMapper.selectByPrimaryKey(cusId);
			order.setCno(cusId);
			order.setCompany(customer.getCusAddr());
		}
		order.setEndEditTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		if(ordersMapper.updateByPrimaryKeySelective(order) != 0)
			return EasyUI.cudMsg(true, "修改成功");
		return EasyUI.cudMsg(false, "修改失败");
	}
	@Override
	public EasyUI delOrder(String ordersId) {
		
		if(ordersId == null || ordersId == "")
			return EasyUI.cudMsg(false, "删除失败");
		else
			for(String id : ordersId.split(",")){
				if(ordersMapper.deleteByPrimaryKey(Integer.parseInt(id)) == 0)
					return EasyUI.cudMsg(false, "删除失败");
			}
		return EasyUI.cudMsg(true, "删除成功");
		
	}
	
	/*方法二：推荐，速度最快
	  * 判断是否为整数 
	  * @param str 传入的字符串 
	  * @return 是整数返回true,否则返回false 
	*/

	  public static boolean isInteger(String str) {  
	        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	        return pattern.matcher(str).matches();  
	  }

}
