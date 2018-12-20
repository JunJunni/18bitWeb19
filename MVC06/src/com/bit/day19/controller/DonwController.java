package com.bit.day19.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.http11.filters.BufferedInputFilter;

/**
 * Servlet implementation class DonwController
 */
@WebServlet("/download.do")
public class DonwController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename=request.getParameter("file");
		String origin=request.getParameter("fname");
		String saveDirectory=request.getRealPath("/up");
		File file = new File(saveDirectory+"\\"+filename);
		
		//파일을 읽어와서 사용자에게(response)쏴 주어야 한다. 
		
		FileInputStream is = null;
		ServletOutputStream sos=null;
		
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		//문서인지 사진인지모름
		//브라우저가 모르게끔 한다. 
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment' filename="+origin);
		
		try{
			is=new FileInputStream(file);
			sos=response.getOutputStream();
			
			bis=new BufferedInputStream(is);
			bos=new BufferedOutputStream(sos);
			
			byte[] buf = new byte[1024];
			
			int num = 0;
			
			while((num=bis.read(buf,0,buf.length))>0){
				//버퍼보다 값이 클태니 반복해서 -1이 될때까지!
				bos.write(buf,0,num);
			}
			bos.flush();
			
		}catch(Exception e){
			
		}finally{
			if(bis!=null)bis.close();
			if(bos!=null)bos.close();
			if(sos!=null)sos.close();
			if(is!=null)is.close();
			
		}
	}
}
