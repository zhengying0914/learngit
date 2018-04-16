package com.zy.www;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Test extends ProductTest{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(driverClassName);
		
		ProductTest pts =new ProductTest();
		Scanner sc = new Scanner(System.in);

		
		ProductType pt = new ProductType();
		while(true) {	
			int n=-1;
			System.out.println("请输入您要进行的操作编号：");
			System.out.println("1.增加产品");
			System.out.println("2.删除产品");
			System.out.println("3.修改产品");
			System.out.println("4.查询产品");
			System.out.println("0.退出");
			n=sc.nextInt();
			//增
			if(n==1) {
				System.out.println("请输入您要存入的产品id：");
				pt.setId(sc.nextInt());
				System.out.println("请输入您要存入的产品名：");
				pt.setName(sc.next());
				if(pts.insert(pt)==true) {
					System.out.println("数据添加完毕！");
				}
				else{
					System.out.println("数据添加失败！");
				}
			}
			//删
			else if(n==2) {
				System.out.println("请输入您要删除的产品id号：");
				int id=sc.nextInt();
				if(pts.delete(id)==true) {
					System.out.println("数据删除完毕！");
				}
				else{
					System.out.println("数据删除失败！");
				}
			}
			//改
			else if(n==3) {
				System.out.println("请输入您要存入的产品id：");
				pt.setId(sc.nextInt());
				System.out.println("请输入您要存入的产品名：");
				pt.setName(sc.next());
				
				if(pts.update(pt)==true) {
					System.out.println("数据修改完毕！");
				}
				else{
					System.out.println("数据修改失败！");
				}

			}
			
			
			//查
			else if(n==4) {
				List<ProductType> ls = pts.select();
					
				for (int i =0 ; i < ls.size(); i ++ ) { 
					ProductType tmp = ls.get(i);
					System.out.println("产品的id为"+tmp.getId()+"产品的名字为"+tmp.getName());
				}
					
			}
			//输入0退出
			else if(n==0) {
				break;
			}
			//数据输入错误
			else {
				System.out.println("请输入1-4的数字！");
			}
		}

	}
}
