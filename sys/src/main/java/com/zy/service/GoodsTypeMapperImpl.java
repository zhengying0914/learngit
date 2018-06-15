package com.zy.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.zy.dao.GoodsTypeMapper;
import com.zy.dao.SqlsessionDao;
import com.zy.entity.GoodsType;
@Service
public abstract class GoodsTypeMapperImpl implements GoodsTypeMapper {
	//删除商品类别信息
	public int deleteByPrimaryKey(int type_id) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		int result=sqlsession.delete("GoodsTypeMapper.deleteType",type_id);
		sqlsession.commit();
		return result;
	}
	//增加商品类别
	public int insert(GoodsType record) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		int result=sqlsession.insert("GoodsTypeMapper.insertType",record);
		sqlsession.commit();
		return result;
	}
	
	// 更新商品类别
	public int updateByPrimaryKey(GoodsType record) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		int result=sqlsession.update("GoodsTypeMapper.updateType",record);
		sqlsession.commit();
		return result;
	}

	//商品类别显示
	public List<GoodsType> selectAll() {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		List<GoodsType> goodsType = sqlsession.selectList("GoodsTypeMapper.selectAll");
		sqlsession.close();
		return goodsType;
	}
	//根据id找到商品别类
	public GoodsType selectByPrimaryKey(int type_id) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		GoodsType goodsType=sqlsession.selectOne("GoodsTypeMapper.selectById",type_id);
		return goodsType;
		
	}

}
