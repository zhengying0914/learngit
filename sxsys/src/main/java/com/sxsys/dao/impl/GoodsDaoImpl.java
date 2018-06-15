package com.sxsys.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.sxsys.dao.GoodsDao;

import com.sxsys.entity.Goods;

public  class GoodsDaoImpl extends MybatisBaseDao implements GoodsDao{
	
	public List<Goods> selectAll(SqlSession session) {
		List<Goods> goodses = super.selectList(session, "GoodsMapper.selectAll");
		return goodses;
	}

	public int insertGoods(SqlSession session, Goods goods) {
		int result = super.insert(session,  "GoodsMapper.insertGoods", goods);
		return result;
	}


}
