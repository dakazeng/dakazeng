package com.ldq.emu.dao;

import java.util.List;

import com.ldq.emu.entity.Position;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
    
    List<Position> posCombobox(); 
}