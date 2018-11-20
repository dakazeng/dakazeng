package com.ldq.emu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldq.emu.entity.PayMethod;
import com.ldq.emu.service.PayMethodService;

@RestController
public class PayMethodController {
	
	@Autowired
	private PayMethodService payMethodService;
	
	@RequestMapping("/payCombobox")
	public List<PayMethod> payCombobox(){
		return payMethodService.payCombobox();
	}
}
