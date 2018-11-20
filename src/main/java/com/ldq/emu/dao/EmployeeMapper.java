package com.ldq.emu.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ldq.emu.entity.Employee;
import com.ldq.emu.entity.EmployeeCustom;
/**
 * 员工mapper接口
 * @author 叶宏杰
 *
 */
public interface EmployeeMapper {
	int deleteByPrimaryKey(Integer empId);

	int insert(Employee record);

	int insertSelective(Employee employee);

	Employee selectByPrimaryKey(Integer empId);

	int updateByPrimaryKeySelective(Employee record);

	int updateByPrimaryKey(Employee record);
	/**
	 * 查询员工列表
	 * @param employeeCustom
	 * @param pageBounds
	 * @return
	 */
	PageList<EmployeeCustom> employeeList(EmployeeCustom employeeCustom, PageBounds pageBounds);
	/**
	 * 查找所有员工
	 * @return
	 */
	List<Employee> empCombobox();
	/**
	 * 通过部门id查询员工
	 * @param dno
	 * @return
	 */
	List<Employee> selectByDno(Integer dno);
	
}