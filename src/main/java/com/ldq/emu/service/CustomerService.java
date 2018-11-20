package com.ldq.emu.service;

import java.util.List;

import com.ldq.emu.entity.Customer;
import com.ldq.emu.utils.EasyUI;

public interface CustomerService {

	List<Customer> cusCombobox();

	EasyUI CustomerList(Customer customer, int page, int rows);

	EasyUI addCustomer(Customer customer);

	EasyUI delCustomer(String cusId);

	EasyUI updCustomer(Customer customer);
}
