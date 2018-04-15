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
	// ��ɾ�Ĳ��ĸ�����
	// ��ѯ:��ֱ��������Ǳ��һ��list����
	// ���ӡ��޸ģ��������޷����� ������޷��ظ�
	// ɾ��������ֱ��ɾ��
	// 13989815478@163.com
	
	// ����zy prodacte
	
	public static void main(String[] args) {
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql//localhost:3306/xmm" ;
		String user= "zy" ;
		String password= "123456" ;

		Connection conn = null;
		try { 
			Class.forName("com.mysql.jdbc.Driver"); // ����MYSQL JDBC�������� 
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
		
		//��
		System.out.println("��������Ҫ����Ĳ�Ʒ����");
		pt.setName(sc.next());
		System.out.println("��������Ҫ����Ĳ�Ʒ�۸�");
		pt.setPrice(sc.nextInt());
		System.out.println("��������Ҫ����Ĳ�Ʒ���");
		pt.setType(sc.next());
		insertUsers(pt);
		
		//ɾ
		System.out.println("��������Ҫɾ���Ĳ�Ʒid�ţ�");
		id=sc.nextInt();
		deleteUsers(id);
		
		//��
		System.out.println("��������Ҫ����Ĳ�Ʒ����");
		pt.setName(sc.next());
		System.out.println("��������Ҫ����Ĳ�Ʒ�۸�");
		pt.setPrice(sc.nextInt());
		System.out.println("��������Ҫ����Ĳ�Ʒ���");
		pt.setType(sc.next());
		updateUsers(pt);
		
		//��
		selectUsers();
	}	
	
	//��ѯ
	public static void selectUsers() {
		String url = "jdbc:mysql//localhost:3306/xmm" ;
		String user= "zy" ;
		String password= "123456" ;

		Connection conn = null;	
		PreparedStatement pstm = null;
		ResultSet rs = null;//������try���淽���ͷ���Դ
		//��ѯ
		try {
			//���ݿ����Ӷ����൱������
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "select * from prodacte" ;//
			pstm = conn.prepareStatement(sql);//�൱��ר��ִ��sql����Ĺ���
			
			rs = pstm.executeQuery();//�õ�һ���ѯ���
			
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
	            System.out.println("��Ʒ��idΪ"+tmp.getId()+"��Ʒ������Ϊ"+tmp.getName()+"��Ʒ�ļ۸�Ϊ"+tmp.getPrice()+"��Ʒ������Ϊ"+tmp.getType());
	        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ͷ���Դ
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
	
	//ɾ��
	public static void deleteUsers(int id) {
		String url = "jdbc:mysql//localhost:3306/xmm" ;
		String user= "zy" ;
		String password= "123456" ;

		Connection conn = null;	
		PreparedStatement pstm = null;
		ResultSet rs = null;//������try���淽���ͷ���Դ
		
		try {
			//���ݿ����Ӷ����൱������
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "DELETE * from prodacte WHERE id=?" ;//
			pstm = conn.prepareStatement(sql);//�൱��ר��ִ��sql����Ĺ���
			
			pstm.setInt(1, id); 
			rs = pstm.executeQuery();//�õ����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ͷ���Դ
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
	
	//�޸�
	public static void updateUsers(ProdactType pt) {
		String url = "jdbc:mysql//localhost:3306/xmm" ;
		String user= "zy" ;
		String password= "123456" ;

		Connection conn = null;	
		PreparedStatement pstm = null;
		ResultSet rs = null;//������try���淽���ͷ���Դ
			
		try {
			//���ݿ����Ӷ����൱������
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "select name from prodacte" ;//
			pstm = conn.prepareStatement(sql);//�൱��ר��ִ��sql����Ĺ���
			rs = pstm.executeQuery();//�õ�һ���ѯ���
			ArrayList<String> ls = new ArrayList<String>();
			while(rs.next()) {
				ls.add(rs.getString("name"));
			}
			for (String tmp : ls) {  
	            if(tmp.equals(pt.getName()))System.out.println("����ͬ���ֵĲ�Ʒ�����ʧ�ܣ�");//�ж������Ƿ����
	            else {
	            	sql = "update prodacte set price=?,type=? WHERE name=?"; 
	            	pstm.setInt(1, pt.getPrice());
	            	pstm.setString(2, pt.getType());
					pstm.setString(3, pt.getName());
					rs = pstm.executeQuery();//�õ����
	            }
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ͷ���Դ
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
	
	//����
	public static void insertUsers(ProdactType pt) {
		String url = "jdbc:mysql//localhost:3306/xmm" ;
		String user= "zy" ;
		String password= "123456" ;

		Connection conn = null;	
		PreparedStatement pstm = null;
		ResultSet rs = null;//������try���淽���ͷ���Դ
				
		try {
			//���ݿ����Ӷ����൱������
			conn = DriverManager.getConnection(url, user, password);
				
			String sql = "select name from prodacte" ;//
			pstm = conn.prepareStatement(sql);//�൱��ר��ִ��sql����Ĺ���
			rs = pstm.executeQuery();//�õ�һ���ѯ���
			ArrayList<String> ls = new ArrayList<String>();
			while(rs.next()) {
				ls.add(rs.getString("name"));
			}
			for (String tmp : ls) {  
		       if(tmp.equals(pt.getName()))System.out.println("����ͬ���ֵĲ�Ʒ�����ʧ�ܣ�");//�ж������Ƿ����
		       else {
		           sql ="insert into prodacte(name,price,type) values(?,?,?)";; 
		           pstm.setString(1, pt.getName());
		           pstm.setInt(2, pt.getPrice());
		           pstm.setString(3, pt.getType());

		           rs = pstm.executeQuery();//�õ����
		            }
		        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//�ͷ���Դ
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
