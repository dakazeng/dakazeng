package com.ldq.emu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusErrorController implements ErrorController{

	@RequestMapping("/error")
	public Map<String,Object> handlerError(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		map.put("code", response.getStatus());
		map.put("msg", request.getRequestURI() +" failed");
		return map;
	}
	
	@Override
	public String getErrorPath() {

		return "/error";
	}

}
