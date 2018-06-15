package com.zy.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.zy.dao.GoodsMapper;
import com.zy.dao.SqlsessionDao;
import com.zy.entity.Goods;
@Service
public abstract class GoodsMapperImpl implements GoodsMapper {
	
//ɾ����Ʒ��Ϣ
	public int deleteByPrimaryKey(int goods_id) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		int result=sqlsession.delete("GoodsMapper.deleteGoods",goods_id);
		sqlsession.commit();
		return result;
	}
//������Ʒ��Ϣ
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
//����id������Ʒ
	public Goods selectByPrimaryKey(int goods_id) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		Goods goods=sqlsession.selectOne("GoodsMapper.selectById",goods_id);
		return goods;
	}

	public int updateByPrimaryKeySelective(Goods record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
     //��Ʒ��Ϣ�޸�
	public int updateByPrimaryKey(Goods record) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		int result=sqlsession.update("GoodsMapper.updateGoods",record);
		sqlsession.commit();
		return result;
		
	}

	//�õ�������Ϣ
	public List<Goods> selectAll() {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		List<Goods> goods = sqlsession.selectList("GoodsMapper.selectAll");
		sqlsession.commit();
		return goods;
	}

}
