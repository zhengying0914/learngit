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
@RequestMapping(value="/goods")//��������goods��ʾ�Ƕ�goods���в���
public class GoodsController {
@Autowired
GoodsMapperImpl goodsMapperImpl;
@Autowired
GoodsTypeMapperImpl goodsTypeMapperImpl;

//ȥ����תҳ��addGoods
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
//�����Ʒ
@RequestMapping(value="/addGoods")
 public String addType(Goods record) {
	System.out.println(record);
	return "goodsInsertSuccess";//��ӳɹ���ȥ�ɹ�ҳ��
	 
 }
//չʾ��Ʒ
@RequestMapping(value="/showGoods")
public String goodShow(HttpServletRequest request) {
	List<Goods> goods=goodsMapperImpl.selectAll();
	System.out.println(goods.size());
	request.setAttribute("goods", goods);
	return "goodsDisplay";
}
//ɾ����Ʒ��ͨ��id��
@RequestMapping(value="toDelete/{id}")
public String doDelete(@PathVariable String goods_id,HttpServletRequest request) {
	int id=Integer.parseInt(goods_id);
	int result=goodsMapperImpl.deleteByPrimaryKey(id);
	System.out.println(result);
	return "Success";
	
}
//ǰ����Ʒ�޸�ҳ��
@RequestMapping(value="toUpdate/{id}")
public String doUpdate(@PathVariable String goods_id,HttpServletRequest request) {
	int id=Integer.parseInt(goods_id);
	Goods goods=goodsMapperImpl.selectByPrimaryKey(id);
	System.out.println("�޸�ȡ����"+goods);
	request.setAttribute("goods", goods);
	return "goodsEdit";
	
}
//��Ʒ��Ϣ�޸�,��������д�����ݿ�
	@RequestMapping(value="/doUpdate")
	public String toUpdata(Goods record) {
		int result=goodsMapperImpl.updateByPrimaryKey(record);
		System.err.println("goods�޸Ľ��"+result);
		return "Success";
	}
}
