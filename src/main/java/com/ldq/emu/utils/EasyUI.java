package com.ldq.emu.utils;

import java.util.HashMap;

public class EasyUI extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	public static EasyUI data(Integer total,Object rows){
		EasyUI r = new EasyUI();
        r.put("code", 0);
        r.put("msg", "");
        r.put("total", total);
        r.put("rows", rows);
        return r;
    }
	
	public static EasyUI loginMsg(boolean success,String msg, String userName){
		EasyUI r = new EasyUI();
		r.put("success", success);
        r.put("msg", msg);
        r.put("userName", userName);
        return r;
    }
	
	public static EasyUI cudMsg(boolean success,String msg){
		EasyUI r = new EasyUI();
		r.put("success", success);
        r.put("msg", msg);
        return r;
    }
}
