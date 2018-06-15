package com.zy.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.zy.dao.GoodsMapper;
import com.zy.dao.SqlsessionDao;
import com.zy.entity.Goods;
@Service
public abstract class GoodsMapperImpl implements GoodsMapper {
	
//删除商品信息
	public int deleteByPrimaryKey(int goods_id) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		int result=sqlsession.delete("GoodsMapper.deleteGoods",goods_id);
		sqlsession.commit();
		return result;
	}
//插入商品信息
	public int insert(Goods record) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		int result=sqlsession.insert("GoodsMapper.insertGoods",record);
		sqlsession.commit();
		return result;
	}

	public int insertSelective(Goods record) {
		// TODO Auto-generated method stub
		return 0;
	}
//根据id查找商品
	public Goods selectByPrimaryKey(int goods_id) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		Goods goods=sqlsession.selectOne("GoodsMapper.selectById",goods_id);
		return goods;
	}

	public int updateByPrimaryKeySelective(Goods record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
     //商品信息修改
	public int updateByPrimaryKey(Goods record) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		int result=sqlsession.update("GoodsMapper.updateGoods",record);
		sqlsession.commit();
		return result;
		
	}

	//得到所有信息
	public List<Goods> selectAll() {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		List<Goods> goods = sqlsession.selectList("GoodsMapper.selectAll");
		sqlsession.commit();
		return goods;
	}

}
