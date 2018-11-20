package com.ldq.emu.dao;

import java.util.List;

import com.ldq.emu.entity.PayMethod;

public interface PayMethodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayMethod record);

    int insertSelective(PayMethod record);

    PayMethod selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayMethod record);

    int updateByPrimaryKey(PayMethod record);

	List<PayMethod> payCombobox();
}