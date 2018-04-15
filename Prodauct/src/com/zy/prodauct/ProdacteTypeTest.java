package com.zy.prodauct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ProdacteTypeTest extends ProdactType {
	// 增删改查四个方法
	// 查询:不直接输出而是变成一个list集合
	// 增加、修改：类别存在无法增加 类别名无法重复
	// 删除：可以直接删除
	// 13989815478@163.com
	
	// 链接zy prodacte
	
	public static void main(String[] args) {
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql//localhost:3306/xmm" ;
		String user= "zy" ;
		String password= "123456" ;

		Connection conn = null;
		try { 
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序 
		      conn= DriverManager.getConnection( url, user, password); 
		      System.out.println("Success loading Mysql Driver!"); 
		    } catch (Exception e) { 
		      System.out.print("Error loading Mysql Driver!"); 
		      e.printStackTrace(); 
		    } 
		
		ProdactType pt= new ProdactType();
		Scanner sc = new Scanner(System.in);
		int id = 0;
		String name = null;
		String type = null;
		int price =0;
		
		//增
		System.out.println("请输入您要存入的产品名：");
		pt.setName(sc.next());
		System.out.println("请输入您要存入的产品价格：");
		pt.setPrice(sc.nextInt());
		System.out.println("请输入您要存入的产品类别：");
		pt.setType(sc.next());
		insertUsers(pt);
		
		//删
		System.out.println("请输入您要删除的产品id号：");
		id=sc.nextInt();
		deleteUsers(id);
		
		//改
		System.out.println("请输入您要存入的产品名：");
		pt.setName(sc.next());
		System.out.println("请输入您要存入的产品价格：");
		pt.setPrice(sc.nextInt());
		System.out.println("请输入您要存入的产品类别：");
		pt.setType(sc.next());
		updateUsers(pt);
		
		//查
		selectUsers();
	}	
	
	//查询
	public static void selectUsers() {
		String url = "jdbc:mysql//localhost:3306/xmm" ;
		String user= "zy" ;
		String password= "123456" ;

		Connection conn = null;	
		PreparedStatement pstm = null;
		ResultSet rs = null;//定义在try外面方便释放资源
		//查询
		try {
			//数据库连接对象，相当于桥梁
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "select * from prodacte" ;//
			pstm = conn.prepareStatement(sql);//相当于专门执行sql命令的工人
			
			rs = pstm.executeQuery();//得到一组查询结果
			
			ProdactType pt = new ProdacteTypeTest();
			ArrayList<ProdactType> ls = new ArrayList<ProdactType>();
			while(rs.next()) {
				pt.setId(rs.getInt("id"));
				pt.setName(rs.getString("name"));
				pt.setType(rs.getString("type"));
				pt.setPrice(rs.getInt("price"));
				
				ls.add(pt);
			}
			for (ProdactType tmp : ls) {  
	            System.out.println("产品的id为"+tmp.getId()+"产品的名字为"+tmp.getName()+"产品的价格为"+tmp.getPrice()+"产品的种类为"+tmp.getType());
	        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//释放资源
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstm!=null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//删除
	public static void deleteUsers(int id) {
		String url = "jdbc:mysql//localhost:3306/xmm" ;
		String user= "zy" ;
		String password= "123456" ;

		Connection conn = null;	
		PreparedStatement pstm = null;
		ResultSet rs = null;//定义在try外面方便释放资源
		
		try {
			//数据库连接对象，相当于桥梁
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "DELETE * from prodacte WHERE id=?" ;//
			pstm = conn.prepareStatement(sql);//相当于专门执行sql命令的工人
			
			pstm.setInt(1, id); 
			rs = pstm.executeQuery();//得到结果
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//释放资源
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstm!=null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//修改
	public static void updateUsers(ProdactType pt) {
		String url = "jdbc:mysql//localhost:3306/xmm" ;
		String user= "zy" ;
		String password= "123456" ;

		Connection conn = null;	
		PreparedStatement pstm = null;
		ResultSet rs = null;//定义在try外面方便释放资源
			
		try {
			//数据库连接对象，相当于桥梁
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "select name from prodacte" ;//
			pstm = conn.prepareStatement(sql);//相当于专门执行sql命令的工人
			rs = pstm.executeQuery();//得到一组查询结果
			ArrayList<String> ls = new ArrayList<String>();
			while(rs.next()) {
				ls.add(rs.getString("name"));
			}
			for (String tmp : ls) {  
	            if(tmp.equals(pt.getName()))System.out.println("有相同名字的产品，添加失败！");//判断名字是否相等
	            else {
	            	sql = "update prodacte set price=?,type=? WHERE name=?"; 
	            	pstm.setInt(1, pt.getPrice());
	            	pstm.setString(2, pt.getType());
					pstm.setString(3, pt.getName());
					rs = pstm.executeQuery();//得到结果
	            }
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//释放资源
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstm!=null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//增加
	public static void insertUsers(ProdactType pt) {
		String url = "jdbc:mysql//localhost:3306/xmm" ;
		String user= "zy" ;
		String password= "123456" ;

		Connection conn = null;	
		PreparedStatement pstm = null;
		ResultSet rs = null;//定义在try外面方便释放资源
				
		try {
			//数据库连接对象，相当于桥梁
			conn = DriverManager.getConnection(url, user, password);
				
			String sql = "select name from prodacte" ;//
			pstm = conn.prepareStatement(sql);//相当于专门执行sql命令的工人
			rs = pstm.executeQuery();//得到一组查询结果
			ArrayList<String> ls = new ArrayList<String>();
			while(rs.next()) {
				ls.add(rs.getString("name"));
			}
			for (String tmp : ls) {  
		       if(tmp.equals(pt.getName()))System.out.println("有相同名字的产品，添加失败！");//判断名字是否相等
		       else {
		           sql ="insert into prodacte(name,price,type) values(?,?,?)";; 
		           pstm.setString(1, pt.getName());
		           pstm.setInt(2, pt.getPrice());
		           pstm.setString(3, pt.getType());

		           rs = pstm.executeQuery();//得到结果
		            }
		        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//释放资源
			finally {
				if(conn!=null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(pstm!=null) {
					try {
						pstm.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

}
