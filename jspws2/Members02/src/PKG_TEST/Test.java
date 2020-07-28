package PKG_TEST;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Test.do")
public class Test extends HttpServlet {

    public Test() {
        super();

    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		/*
		HttpSession session = request.getSession();
		
		String strUserID = (String)session.getAttribute("userID");
		
		String strURL = "";
		
	
		if(strUserID == null || strUserID.equals("")) {
			
			request.setAttribute("isSuc", true);
			strURL = "./Members/login.jsp";
			
		}
		else {
			strURL = "./WebPage/test1.jsp";
		}
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		*/
		String str = request.getParameter("a");
		
		request.setAttribute("a", str);
		String strURL = "./WebPage/test1.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(strURL);
		dispatcher.forward(request, response);
		
		
		
	}


}
