package com.zy.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.zy.dao.GoodsTypeMapper;
import com.zy.dao.SqlsessionDao;
import com.zy.entity.GoodsType;
@Service
public abstract class GoodsTypeMapperImpl implements GoodsTypeMapper {
	//ɾ����Ʒ�����Ϣ
	public int deleteByPrimaryKey(int type_id) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		int result=sqlsession.delete("GoodsTypeMapper.deleteType",type_id);
		sqlsession.commit();
		return result;
	}
	//������Ʒ���
	public int insert(GoodsType record) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		int result=sqlsession.insert("GoodsTypeMapper.insertType",record);
		sqlsession.commit();
		return result;
	}
	
	// ������Ʒ���
	public int updateByPrimaryKey(GoodsType record) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		int result=sqlsession.update("GoodsTypeMapper.updateType",record);
		sqlsession.commit();
		return result;
	}

	//��Ʒ�����ʾ
	public List<GoodsType> selectAll() {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		List<GoodsType> goodsType = sqlsession.selectList("GoodsTypeMapper.selectAll");
		sqlsession.close();
		return goodsType;
	}
	//����id�ҵ���Ʒ����
	public GoodsType selectByPrimaryKey(int type_id) {
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		GoodsType goodsType=sqlsession.selectOne("GoodsTypeMapper.selectById",type_id);
		return goodsType;
		
	}

}
