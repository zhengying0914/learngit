package com.sxsys.dao;

import java.util.List;

import com.sxsys.entity.Goods;
import org.apache.ibatis.session.SqlSession;

public interface GoodsDao {
	public List<Goods> selectAll(SqlSession session);
	public int insertGoods(SqlSession session,Goods goods);
}
