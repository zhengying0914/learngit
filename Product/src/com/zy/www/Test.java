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
			System.out.println("��������Ҫ���еĲ�����ţ�");
			System.out.println("1.���Ӳ�Ʒ");
			System.out.println("2.ɾ����Ʒ");
			System.out.println("3.�޸Ĳ�Ʒ");
			System.out.println("4.��ѯ��Ʒ");
			System.out.println("0.�˳�");
			n=sc.nextInt();
			//��
			if(n==1) {
				System.out.println("��������Ҫ����Ĳ�Ʒid��");
				pt.setId(sc.nextInt());
				System.out.println("��������Ҫ����Ĳ�Ʒ����");
				pt.setName(sc.next());
				if(pts.insert(pt)==true) {
					System.out.println("���������ϣ�");
				}
				else{
					System.out.println("�������ʧ�ܣ�");
				}
			}
			//ɾ
			else if(n==2) {
				System.out.println("��������Ҫɾ���Ĳ�Ʒid�ţ�");
				int id=sc.nextInt();
				if(pts.delete(id)==true) {
					System.out.println("����ɾ����ϣ�");
				}
				else{
					System.out.println("����ɾ��ʧ�ܣ�");
				}
			}
			//��
			else if(n==3) {
				System.out.println("��������Ҫ����Ĳ�Ʒid��");
				pt.setId(sc.nextInt());
				System.out.println("��������Ҫ����Ĳ�Ʒ����");
				pt.setName(sc.next());
				
				if(pts.update(pt)==true) {
					System.out.println("�����޸���ϣ�");
				}
				else{
					System.out.println("�����޸�ʧ�ܣ�");
				}

			}
			
			
			//��
			else if(n==4) {
				List<ProductType> ls = pts.select();
					
				for (int i =0 ; i < ls.size(); i ++ ) { 
					ProductType tmp = ls.get(i);
					System.out.println("��Ʒ��idΪ"+tmp.getId()+"��Ʒ������Ϊ"+tmp.getName());
				}
					
			}
			//����0�˳�
			else if(n==0) {
				break;
			}
			//�����������
			else {
				System.out.println("������1-4�����֣�");
			}
		}

	}
}
