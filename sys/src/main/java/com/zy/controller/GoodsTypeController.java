package com.zy.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zy.entity.GoodsType;
import com.zy.service.GoodsTypeMapperImpl;



@Controller
@RequestMapping(value="/shop")//表示对类型修改
public class GoodsTypeController {
	@Autowired
	GoodsTypeMapperImpl goodsTypeMapperImpl;
	
	//前往显示商品类别页面
	@RequestMapping(value="/type")
	 public String showType(HttpServletRequest request) {
		List<GoodsType> type=goodsTypeMapperImpl.selectAll();
		request.setAttribute("types", type);
		return "ShopType";
		 
	 }
	//添加商品类别
	@RequestMapping(value="/addType",method = RequestMethod.POST)
	 public String addType(GoodsType record) {
		System.out.println(record.getName());
		int result=goodsTypeMapperImpl.insert(record);
		System.out.println("result"+result);
		return "successAddType";
	 }
	//跳转到增加页面
	@RequestMapping(value="/addDo")
	public String toadd() {
		return "addType";
		
	}
	
	//商品类型信息修改,从数据库中读取原来数据
	@RequestMapping(value="/updateDo/{id}")
	public String getType(@PathVariable String id,HttpServletRequest request) {
		int tid=Integer.parseInt(id);
		GoodsType goodsType=goodsTypeMapperImpl.selectByPrimaryKey(tid);
		System.out.println(goodsType);
		request.setAttribute("type", goodsType);
		return "updateType";
		
	}
	
	//商品类型信息修改,将新数据写回数据库
	@RequestMapping(value="/toUpdate")
	public String toUpdata(GoodsType record) {
		int result=goodsTypeMapperImpl.updateByPrimaryKey(record);
		System.err.println(result);
		return "successTypeUpdate";
		//return "redirect:com.ylw.shopsys/shop/type";
		
	}
	//删除商品类型
	@RequestMapping(value="/toDelete/{id}")
	public String toDelete(@PathVariable String id) {
		int tid=Integer.parseInt(id);
		int result=goodsTypeMapperImpl.deleteByPrimaryKey(tid);
		System.out.println(result);
		return "successTypeUpdate";
		
	}
}
