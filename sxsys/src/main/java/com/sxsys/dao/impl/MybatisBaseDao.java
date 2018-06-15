package com.sxsys.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MybatisBaseDao {
	public int insert(SqlSession session,String sqlid,Object ... values) {
		int result=0;
		result = session.insert(sqlid,values);
		return result;
	}
	public int update(SqlSession session,String sqlid,Object ... values) {
		int result=0;
		result = session.update(sqlid,values);
		return result;
	}
	public int delete(SqlSession session,String sqlid,Object ... values) {
		int result=0;
		result = session.delete(sqlid,values);
		return result;
	}
	public List selectList(SqlSession session,String sqlid,Object ... values) {
		List result;
		result = session.selectList(sqlid,values);
		return result;
	}
	public Object selectone(SqlSession session,String sqlid,Object ... values) {
		Object result;
		result = session.selectOne(sqlid,values);
		return result;
	}
}
