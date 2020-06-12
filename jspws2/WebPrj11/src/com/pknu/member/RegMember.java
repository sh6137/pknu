package com.pknu.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegMember")
public class RegMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//<form>에서 넘어온 정보처리
		
		String userid = request.getParameter("userid");
		String userpass = request.getParameter("userpass");
		
		//db 저장
		
		//html 결과를 내려보내준다.
		response.setContentType("text/html; charset-utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<h2>회원가입완료</h2>");
		out.print("<h2>"+userid+" 님 환영합니다.</h2>");
		
		
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
