package com.bit.day16.test;

import java.util.ArrayList;

import com.bit.day16.model.Emp02Dao;
import com.bit.day16.model.Emp02Dto;

public class TestDao {
	public static void main(String[] args) {
		Emp02Dao dao = new Emp02Dao();
		
		System.out.println("�����׽�Ʈ");
		System.out.println("TestselectAll");
		System.out.println(dao.selectAll()!=null);
		System.out.println(dao.selectAll().size()>0);
		
		System.out.println("TestselectOne");
		System.out.println(dao.selectOne(1)!=null);
		System.out.println(dao.selectOne(1).getEmpno()==1);

		System.out.println("TestinsertOne");
		int num=dao.selectAll().size();
		dao.insertOne("test", 3800);
		System.out.println(dao.selectAll().size()==num+1);
		
		System.out.println("TestupdateOne");
		
		Emp02Dto bean = new Emp02Dto(); //�� �ϳ�����(�̰�.. sql�o�� �״�ε��°žƴ�?
		bean.setName("test");
		bean.setPay(4200);
		bean.setCnt(0); //�Է¿Ϸ�

		dao.insertOne(bean.getName(), bean.getPay());
		
		ArrayList<Emp02Dto> list = dao.selectAll();
		Emp02Dto last = null;
		for(int i=0; i<list.size(); i++){
			last=list.get(i); //���� �������� �����°� �Է�. 
		}
		bean.setEmpno(last.getEmpno());
		System.out.println(last.equals(bean)); //���� ���������ִ� last�� �������� �������� bean�� ������ ���Ѵ�. 
		
		bean.setName("edit");
		dao.updateOne(bean.getName(), bean.getPay(), bean.getEmpno());

		
		System.out.println("TestdelOne");
		System.out.println(dao.selectOne(bean.getEmpno()).equals(bean));
		dao.delOne(bean.getEmpno());
//		System.out.println(dao.selectOne(bean.getEmpno()).equals(new Emp02Dto()));
		//���� ���� �˻�
		System.out.println(dao.delOne(bean.getEmpno())>0);
	}
}
