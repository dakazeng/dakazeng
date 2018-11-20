package com.ldq.emu.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ldq.emu.entity.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer cusId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer cusId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

	List<Customer> cusCombobox();
	
	PageList<Customer> CustomerList(Customer customer, PageBounds pageBounds);
	
}