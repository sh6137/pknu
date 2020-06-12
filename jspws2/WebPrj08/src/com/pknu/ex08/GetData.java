package com.pknu.ex08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/get")
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//출력할 html 모양을 만든다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//넘어오는 값 처리
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid"); // name = "userid"
		String userpass = request.getParameter("userpass");// = "userpass"
		String username = request.getParameter("username");// = "username"
		System.out.println(userid);
		System.out.println(userpass);
		System.out.println(username);
		//출력할 html 모양을 만든다.
		//출력될 내용을 html로 받아서 처리하라
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String html = "<html>";
				html += "<head>";
				html += "<meta content-type = text/html; charset = utf-8>";
				html += "</head>";
				html += "<body>";
				
				html += "<div>아이디 : " + userid + "</div>";
				html += "<div>암호 : " + userpass + "</div>";
				html += "<div>이름 : " + username + "</div>";
				
				html += "</body>";
				html += "</html>";
		out.print(html);
		out.flush();
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
