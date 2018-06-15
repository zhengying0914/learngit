package com.zy.dao;

import java.util.List;

import com.zy.entity.GoodsType;;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(int type_id);

    int insert(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
    
    List<GoodsType> selectAll();
}