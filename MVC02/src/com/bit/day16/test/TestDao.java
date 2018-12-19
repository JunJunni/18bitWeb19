package com.bit.day16.test;

import java.util.ArrayList;

import com.bit.day16.model.Emp02Dao;
import com.bit.day16.model.Emp02Dto;

public class TestDao {
	public static void main(String[] args) {
		Emp02Dao dao = new Emp02Dao();
		
		System.out.println("단위테스트");
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
		
		Emp02Dto bean = new Emp02Dto(); //빈 하나생성(이게.. sql엗도 그대로들어가는거아님?
		bean.setName("test");
		bean.setPay(4200);
		bean.setCnt(0); //입력완료

		dao.insertOne(bean.getName(), bean.getPay());
		
		ArrayList<Emp02Dto> list = dao.selectAll();
		Emp02Dto last = null;
		for(int i=0; i<list.size(); i++){
			last=list.get(i); //가장 마지막에 나오는것 입력. 
		}
		bean.setEmpno(last.getEmpno());
		System.out.println(last.equals(bean)); //제일 마지막에있는 last를 기준으로 내가만든 bean과 같은지 비교한다. 
		
		bean.setName("edit");
		dao.updateOne(bean.getName(), bean.getPay(), bean.getEmpno());

		
		System.out.println("TestdelOne");
		System.out.println(dao.selectOne(bean.getEmpno()).equals(bean));
		dao.delOne(bean.getEmpno());
//		System.out.println(dao.selectOne(bean.getEmpno()).equals(new Emp02Dto()));
		//쉽게 삭제 검사
		System.out.println(dao.delOne(bean.getEmpno())>0);
	}
}
