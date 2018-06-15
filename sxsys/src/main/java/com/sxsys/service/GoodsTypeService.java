package com.sxsys.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sxsys.entity.GoodsType;

public interface GoodsTypeService {
	public List<GoodsType> getAll();
}
