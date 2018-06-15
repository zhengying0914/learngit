package com.zy.dao;



import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class SqlsessionDao {
	public static SqlSession  getSqlsession() {
		String resource = "config/Configuration.xml";//�����ļ�
		Reader reader;
		SqlSessionFactory sqlSessionFactory = null;//�Ự����
		SqlSession sqlsession = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlsession = sqlSessionFactory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return sqlsession;
		
	}
}
