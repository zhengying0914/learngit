package com.zy.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class ProductTest extends ProductType {

	public static final String url = "jdbc:mysql://localhost:3306/xmm";

	public static final String driverClassName = "com.mysql.jdbc.Driver";

	public static final String user = "root";

	public static final String password = "123456";

	Connection conn = null;

	PreparedStatement pstm = null;

	ResultSet rs = null;


	// 增
	public boolean insert(ProductType pt) throws SQLException {
		conn = DriverManager.getConnection(url, user, password);
		
		String name = pt.getName();
		if (findName(name)) {
			System.out.println("数据添加失败，有相同名称产品！");
			return false;
		}

		String sql = "INSERT INTO product(id,name) VALUES (?,?)";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, pt.getId());
		pstm.setString(2, pt.getName());
		System.out.println(pstm.execute());
		return pstm.execute();
		
	}

	// 删
	public boolean delete(int id) throws SQLException {
		conn = DriverManager.getConnection(url, user, password);

		String sql = "DELETE FROM product WHERE id="+id;
		pstm = conn.prepareStatement(sql);
		return pstm.execute();
	}

	// 改
	public boolean update(ProductType pt) throws SQLException {
		conn = DriverManager.getConnection(url, user, password);
		
		String name = pt.getName();
		if (findName(name)) {
			System.out.println("数据添加失败，有相同名称产品！");
			return false;
		}
		
		String sql = "UPDATE product set name="+ pt.getName()+"WHERE id="+pt.getId();
		pstm = conn.prepareStatement(sql);
		return pstm.execute();
	}

	// 查
	public List<ProductType> select() throws SQLException {
		conn = DriverManager.getConnection(url, user, password);
		String sql = "SELECT * FROM product";
		pstm = conn.prepareStatement(sql);
		rs = pstm.executeQuery();
		
		ProductType pt =new ProductType();
		List<ProductType> ls =new ArrayList<ProductType>();
		while(rs.next()) {
			pt.setId(rs.getInt("id"));
			pt.setName(rs.getString("name"));
			ls.add(pt);
		}
		
		return ls;
	}

	// 查看是否名字重复

	public boolean findName(String name) throws SQLException {
		conn = DriverManager.getConnection(url, user, password);

		String sql = "select * from product where name=" + name;
		pstm = conn.prepareStatement(sql);

		return pstm.execute();
	}
}
