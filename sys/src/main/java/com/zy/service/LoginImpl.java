package com.zy.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.zy.entity.Login;
import com.zy.dao.LoginMapper;
import com.zy.dao.SqlsessionDao;
@Service
public abstract class LoginImpl implements LoginMapper {

    //µÇÂ½ÅÐ¶Ï
	public String selsetByUsername(String username,String password) {
		String flag="no";
		SqlSession sqlsession = SqlsessionDao.getSqlsession();
		Login loginEntity=sqlsession.selectOne("LoginMapper.selectByUsername", username);
		if(loginEntity!=null) {
			if(loginEntity.getPassword().equals(password)) {
				//request.setAttribute("loginUser", loginEntity.getUsername());
				return loginEntity.getUsername();
			}
		}
		
		return flag;
	}

}
