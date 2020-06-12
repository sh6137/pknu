package com.pknu.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetMember")
public class GetMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//넘어올 정보
		String userid = request.getParameter("userid");
		
		//조회
		String msg = "";
		if(userid.equals("sky"))
			msg="<b class = 'red'http://localhost:9090/WebPrj11/GetMember?userid=sky>사용할 수 없는 아이디입니다.";
		else	
			msg="<b class = 'green'>사용가능한 아이디입니다.";
		//넘겨줄정보
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//out.print();
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
