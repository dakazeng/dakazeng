package com.ldq.emu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldq.emu.dao.PayMethodMapper;
import com.ldq.emu.entity.PayMethod;
import com.ldq.emu.service.PayMethodService;
@Service
public class PayMethodServiceImpl implements PayMethodService {
	
	@Autowired
	private PayMethodMapper payMethodMapper;

	@Override
	public List<PayMethod> payCombobox() {
		return payMethodMapper.payCombobox();
	}
}
