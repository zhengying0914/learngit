package com.sxsys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sxsys.dao.GoodsDao;
import com.sxsys.dao.impl.GoodsDaoImpl;
import com.sxsys.dao.impl.MyBatisUtis;
import com.sxsys.entity.Goods;
import com.sxsys.service.GoodsService;

public class GoodsServiceImpl implements GoodsService{
	private GoodsDao dao = new GoodsDaoImpl();
	
	public int addGoods(Goods goods) {
		int result = 0;
		SqlSession session =  MyBatisUtis.creatSqlSession();
		try {
			result=dao.insertGoods(session, goods);
			session.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return result;
	}

	
	public List<Goods> getAll() {
		List<Goods> result = new ArrayList<Goods>();
		SqlSession session =  MyBatisUtis.creatSqlSession();
		try {
			result=dao.selectAll(session);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return result;
	}
	
}
