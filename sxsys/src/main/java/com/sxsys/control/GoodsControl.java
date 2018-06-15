package com.sxsys.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gsdxsys.entity.Goods;
import com.gsdxsys.entity.GoodsType;
import com.gsdxsys.service.GoodsService;
import com.gsdxsys.service.GoodsTypeService;

@Controller
public class GoodsControl {
	@Autowired
  private GoodsTypeService service;
	@Autowired
	private GoodsService goodsService;
	@RequestMapping("/admin/goods/toadd.do")
	public String toadd(HttpServletRequest request)  {
		List<GoodsType> types= service.getAll();
		request.setAttribute("types", types);
		return "admin/goods_toadd";
	}
	@RequestMapping("/admin/goods/doadd.do")
	public String doadd(PrintWriter out,Goods goods)  {
		
		int result= goodsService.addGoods(goods);
		if(result>0){
			return  "redirect:/admin/goods/list.do";
		}else{
			out.println("ÃÌº” ß∞‹");
			return null;
		}
	}
	@RequestMapping("/admin/goods/list.do")
	public String list(HttpServletRequest req) {
		List<Goods> goods= goodsService.getAll();
		req.setAttribute("goods", goods);
		return "admin/goods_list";
		
	}
}
