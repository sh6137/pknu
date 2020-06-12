package com.pknu.test03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetDataJSON")
public class GetDataJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String msg = "";
		msg += "[\r\n" + 
				"{  \"num\": 1 , \"name\": \"효성\", \"age\":21  },\r\n" + 
				"{  \"num\": 2 , \"name\": \"영효\", \"age\":22  },\r\n" + 
				"{  \"num\": 3 , \"name\": \"상훈\", \"age\":23  },\r\n" + 
				"{  \"num\": 4 , \"name\": \"태화\", \"age\":25  }\r\n" + 
				"]";
		out.print(msg);
		
		out.flush();
		out.close();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
