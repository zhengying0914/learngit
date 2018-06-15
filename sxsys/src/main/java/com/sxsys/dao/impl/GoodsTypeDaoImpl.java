package com.sxsys.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sxsys.dao.GoodsTypeDao;
import com.sxsys.entity.Goods;
import com.sxsys.entity.GoodsType;

public class GoodsTypeDaoImpl extends MybatisBaseDao implements GoodsTypeDao{

	public List<GoodsType> selectAll(SqlSession session) {
		22 goodses=super.selectList(session, "GoodsTypeMapper.selectAll");
		return goodses;
	}
	
	public int insertgoods(SqlSession session , Goods goods) {
		return 0;
		//26.24
	}
}
