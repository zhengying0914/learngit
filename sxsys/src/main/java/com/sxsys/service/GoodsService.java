package com.sxsys.service;

import java.util.List;

import com.sxsys.entity.Goods;

public interface GoodsService {
	public int addGoods(Goods goods);
	public List<Goods> getAll();
}
