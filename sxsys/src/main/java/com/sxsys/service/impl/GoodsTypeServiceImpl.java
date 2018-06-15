package com.sxsys.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.sxsys.dao.GoodsTypeDao;
import com.sxsys.dao.impl.GoodsTypeDaoImpl;
import com.sxsys.dao.impl.MyBatisUtis;
import com.sxsys.entity.GoodsType;
import com.sxsys.service.GoodsTypeService;

public class GoodsTypeServiceImpl implements GoodsTypeService{
	
	private GoodsTypeDao dao = new GoodsTypeDaoImpl();
	
	public List<GoodsType> getAll(){
		List<GoodsType> types = new ArrayList<GoodsType>();
		SqlSession session = MyBatisUtis.creatSqlSession();
		try {
			types = dao.selectAll(session);
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			if(session!=null)
				session.close();
		}
		return types;
	}
}
