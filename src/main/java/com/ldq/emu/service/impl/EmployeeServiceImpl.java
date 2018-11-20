package com.ldq.emu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ldq.emu.dao.DepartmentMapper;
import com.ldq.emu.dao.EmployeeMapper;
import com.ldq.emu.dao.OrdersMapper;
import com.ldq.emu.dao.PositionMapper;
import com.ldq.emu.entity.Department;
import com.ldq.emu.entity.Employee;
import com.ldq.emu.entity.EmployeeCustom;
import com.ldq.emu.entity.Position;
import com.ldq.emu.service.EmployeeService;
import com.ldq.emu.utils.EasyUI;

/**
 * 员工业务控制器接口的实现类
 * 
 * @author 叶宏杰
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private PositionMapper positionMapper;
	@Autowired
	private OrdersMapper ordersMapper;

	@Override
	public EasyUI employeeList(EmployeeCustom employeeCustom, int page, int rows) {
		
		if(employeeCustom.getCreatDateStart() != null && employeeCustom.getCreatDateEnd() != null) {
			
			String creatDateStart = employeeCustom.getCreatDateStart().trim();
			String creatDateEnd = employeeCustom.getCreatDateEnd().trim();
			System.out.println(creatDateStart);
			employeeCustom.setCreatDateStart(creatDateStart);
			employeeCustom.setCreatDateEnd(creatDateEnd);
		}
		PageList<EmployeeCustom> employees = employeeMapper.employeeList(employeeCustom, new PageBounds(page, rows));
		System.out.println("查询员工列表>>>>>>>>" + employees);
			/*if(creatDateStart != null) {
				
				int result = "1997-08-05".compareTo(creatDateStart);
				if (result==0)
					System.out.print("a=b");
				else if (result < 0 )
					System.out.print("a<b");
				else System.out.print("a>b");
			}*/
		
		if (employees != null) {
			return EasyUI.data(employees.getPaginator().getTotalCount(), employees);
		} else {
			return EasyUI.data(0, null);
		}
	}

	@Override
	public EasyUI addEmployee(Employee employee) {
		int i = employeeMapper.insertSelective(employee);
		if (i != 0) {
			return EasyUI.cudMsg(true, "添加成功");
		} else {
			return EasyUI.cudMsg(false, "添加失败");
		}
	}

	@Override
	public Department selectByName(String depName) {

		return departmentMapper.selectByName(depName);
	}
	
	@Override
	@Transactional
	public EasyUI delEmployee(String empId) {

		if (empId == null || empId == "")
			return EasyUI.cudMsg(false, "删除失败");
		for (String id : empId.split(",")) {
			if (ordersMapper.selectByEno(Integer.parseInt(id)).size() == 0) {
				if (employeeMapper.deleteByPrimaryKey(Integer.parseInt(id)) == 0)
					return EasyUI.cudMsg(false, "删除失败");
			} else
				return EasyUI.cudMsg(false, "有该员工负责的订单，暂时不能删除");
		}
		return EasyUI.cudMsg(true, "删除成功");

	}

	@Override
	public EasyUI updEmployee(Employee employee) {
		int i = employeeMapper.updateByPrimaryKeySelective(employee);
		if (i != 0) {
			return EasyUI.cudMsg(true, "修改成功");
		} else {
			return EasyUI.cudMsg(false, "修改失败");
		}
	}

	@Override
	public List<Department> depCombobox() {
		return departmentMapper.depCombobox();
	}

	@Override
	public List<Position> posCombobox() {
		return positionMapper.posCombobox();
	}

	@Override
	public List<Employee> empCombobox() {
		return employeeMapper.empCombobox();
	}

}
