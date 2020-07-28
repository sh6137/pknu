package PKG_SERV;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Hello extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
		/*
		 * PrintWriter out = response.getWriter();
		 * out.println("<font color = 'red'>hello world!!!</font>");
		 */
		
		/*
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userID = request.getParameter("id");
		String btn1 = request.getParameter("btn1");
		String btn2 = request.getParameter("btn2");
		
		out.println("hello"+userID);
		out.println("hello"+btn1);
		out.println("hello"+btn2);
		
		request.setAttribute("id", userID);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/01_test/list.jsp");
		dispatcher.forward(request, response);
		*/
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userID = request.getParameter("id");
		String btn1 = request.getParameter("btn1");
		String btn2 = request.getParameter("btn2");
		
		out.println("hello"+userID);
		out.println("hello"+btn1);
		out.println("hello"+btn2);
		
		
		request.setAttribute("id", userID);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/01_test/list.jsp");
		dispatcher.forward(request, response);
		
		response.sendRedirect("/01_test/list.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userID = request.getParameter("id");
		String btn1 = request.getParameter("btn1");
		String btn2 = request.getParameter("btn2");
		
		out.println("hello"+userID);
		out.println("hello"+btn1);
		out.println("hello"+btn2);
		
		request.setAttribute("id", userID);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/01_test/list.jsp");
		dispatcher.forward(request, response);
		
		response.sendRedirect("/01_test/list.jsp");
	}
}
