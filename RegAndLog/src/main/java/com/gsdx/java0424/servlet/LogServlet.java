package com.gsdx.java0424.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsdx.java0424.entity.Userinfo;
import com.gsdx.java0424.service.UserinfoService;

public class LogServlet extends HttpServlet{
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("op");
		if("log".equals(action)) {
			doLog(req, resp);
		}
	}
	
	protected void doLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Userinfo user = new Userinfo();
		user.setUsername(username);
		user.setPassword(password);
		UserinfoService service = new UserinfoService();
		PrintWriter out = resp.getWriter();
		int result1 = service.registerUser(user);
		if(result1>0) {
			boolean result2 = service.login(user);
			if(result2) {
				resp.sendRedirect("success.jsp");;
			}
			else {
				out.println("<script>ÃÜÂë´íÎó£¡;history.go(-1);<script/>");
			}
		}
		else {
			out.println("<script>ÓÃ»§Ãû´íÎó£¡;history.go(-1);<script/>");
		}
	}

}
