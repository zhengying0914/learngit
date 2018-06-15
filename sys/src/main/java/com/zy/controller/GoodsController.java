package com.zy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zy.entity.Goods;
import com.zy.entity.GoodsType;
import com.zy.service.GoodsMapperImpl;
import com.zy.service.GoodsTypeMapperImpl;

@Controller
@RequestMapping(value="/goods")//首先增加goods表示是对goods进行操作
public class GoodsController {
@Autowired
GoodsMapperImpl goodsMapperImpl;
@Autowired
GoodsTypeMapperImpl goodsTypeMapperImpl;

//去往跳转页面addGoods
@RequestMapping(value="/toAddGoods")
public String toadd(HttpServletRequest request) {
	List<String> listType=new ArrayList<String>(); 
	List<GoodsType> type= goodsTypeMapperImpl.selectAll();
	System.out.println(type);
	for(GoodsType t:type) {
		System.out.println(1);
		listType.add(t.getName());
	}
	request.setAttribute("listType", listType);
	return "addGoods";
	
}
//添加商品
@RequestMapping(value="/addGoods")
 public String addType(Goods record) {
	System.out.println(record);
	return "goodsInsertSuccess";//添加成功就去成功页面
	 
 }
//展示商品
@RequestMapping(value="/showGoods")
public String goodShow(HttpServletRequest request) {
	List<Goods> goods=goodsMapperImpl.selectAll();
	System.out.println(goods.size());
	request.setAttribute("goods", goods);
	return "goodsDisplay";
}
//删除商品（通过id）
@RequestMapping(value="toDelete/{id}")
public String doDelete(@PathVariable String goods_id,HttpServletRequest request) {
	int id=Integer.parseInt(goods_id);
	int result=goodsMapperImpl.deleteByPrimaryKey(id);
	System.out.println(result);
	return "Success";
	
}
//前往商品修改页面
@RequestMapping(value="toUpdate/{id}")
public String doUpdate(@PathVariable String goods_id,HttpServletRequest request) {
	int id=Integer.parseInt(goods_id);
	Goods goods=goodsMapperImpl.selectByPrimaryKey(id);
	System.out.println("修改取数据"+goods);
	request.setAttribute("goods", goods);
	return "goodsEdit";
	
}
//商品信息修改,将新数据写回数据库
	@RequestMapping(value="/doUpdate")
	public String toUpdata(Goods record) {
		int result=goodsMapperImpl.updateByPrimaryKey(record);
		System.err.println("goods修改结果"+result);
		return "Success";
	}
}
