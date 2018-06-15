package com.sxsys.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxsys.entity.GoodsType;
import com.sxsys.service.GoodsService;
import com.sxsys.service.GoodsTypeService;
import com.sxsys.service.impl.GoodsServiceImpl;
import com.sxsys.service.impl.GoodsTypeServiceImpl;

public class GoodsServlet extends HttpServlet{
	
	private GoodsService service = new GoodsServiceImpl();
	private GoodsTypeService typeservice = new GoodsTypeServiceImpl();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void toadd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<GoodsType> types = typeservice.getAll();
		req.setAttribute("types", types);
		req.getRequestDispatcher("/admin/goods_toadd.jsp").forward(req, resp);
	}
}
