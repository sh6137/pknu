package PKG_INIT;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//	@WebFilter("/*")
public class InitFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		String loginGubun = request.getParameter("gubun");
		
		//System.out.println(loginGubun);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		  HttpSession session = request.getSession();
		  
		  String strUserID = (String)session.getAttribute("userID");
		  
		  if(
				  (strUserID == null || strUserID.equals("")) 
				  && (loginGubun == null || !loginGubun.equals("login")) 
			) {
			  System.out.println(loginGubun);
			    String strURL = "./Members/login.jsp";
				boolean isSuc = false;
				request.setAttribute("isSuc", isSuc);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(strURL);
				dispatcher.forward(request, response);
				
		  }
		  else {
			  //System.out.println("--------");
			  
			  chain.doFilter(req, res);
		  }
		
		  
		 
		 
		  
	}
	


}
