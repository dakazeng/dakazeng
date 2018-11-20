package com.ldq.emu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ldq.emu.dao.DepartmentMapper;
import com.ldq.emu.dao.EmployeeMapper;
import com.ldq.emu.dao.OrdersMapper;
import com.ldq.emu.entity.Department;
import com.ldq.emu.service.DepartmentService;
import com.ldq.emu.utils.EasyUI;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Override
	public EasyUI departmentList(Department department, int page, int rows) {
		
		PageList<Department> departments = departmentMapper.departmentList(department, new PageBounds(page, rows));
		if(departments != null)
			return EasyUI.data(departments.getPaginator().getTotalCount(), departments);
		
		return EasyUI.data(0, null);
		
	}
	
	@Override
	public EasyUI addDepartment(Department department) {
		
		if(departmentMapper.selectByName(department.getDepName()) != null) {
			return EasyUI.cudMsg(false, department.getDepName()+" 部门名称已存在");
		}
		
		if(departmentMapper.insertSelective(department) != 0)
			return EasyUI.cudMsg(true, "添加成功");
		
		return EasyUI.cudMsg(false, "添加失败");
		
	}
	
	@Override
	public EasyUI delDepartment(String depId) {

		if(depId == null || depId == "")
			return EasyUI.cudMsg(false, "删除失败");
		
		for(String id : depId.split(",")){
			if(ordersMapper.selectByDno(Integer.parseInt(id)).size() == 0) {
				if (employeeMapper.selectByDno(Integer.parseInt(id)).size() == 0) {
					if(departmentMapper.deleteByPrimaryKey(Integer.parseInt(id)) == 0)
						return EasyUI.cudMsg(false, "删除失败");
				} else 
					return EasyUI.cudMsg(false, "有该部门下的员工，暂时不能删除");
			}else 
				return EasyUI.cudMsg(false, "有该部门下的订单，暂时不能删除");
		}
		
		return EasyUI.cudMsg(true, "删除成功");
		
	}
	
	@Override
	public EasyUI updDepartment(Department department) {
		
		if(departmentMapper.updateByPrimaryKeySelective(department) != 0)
			return EasyUI.cudMsg(true, "修改成功");
		
		return EasyUI.cudMsg(false, "修改失败");
		
	}

}
