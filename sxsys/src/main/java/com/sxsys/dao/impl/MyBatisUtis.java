package com.sxsys.dao.impl;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtis {
	
	private static SqlSessionFactory sqlSessionFactory=null;
	
	public static SqlSession creatSqlSession() {
		SqlSession session = null;
		if(sqlSessionFactory==null) {
			String resource = "config/Configuration.xml";
			Reader reader;
			SqlSessionFactory sqlSessionFactory = null;
			SqlSession sqlsession = null;
			try {
				reader = Resources.getResourceAsReader(resource);//34:55
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				session = sqlSessionFactory.openSession();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			session = sqlSessionFactory.openSession();
		}
		
		return session;
	}
}
