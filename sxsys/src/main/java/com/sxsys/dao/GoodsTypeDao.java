package com.sxsys.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sxsys.entity.Goods;
import com.sxsys.entity.GoodsType;

public interface GoodsTypeDao {
	public List<GoodsType> selectAll(SqlSession session);
	public int insertGoods(SqlSession session,Goods goods);
}
