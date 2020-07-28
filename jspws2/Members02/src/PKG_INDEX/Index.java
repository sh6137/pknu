package PKG_INDEX;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JW.Fire")
public class Index extends HttpServlet {
	
       
 
    public Index() {
        super();
       
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
			String strGubun = request.getParameter("gubun");
			
			if(strGubun == null){
				GoIndex(request, response);
			}
			else if(strGubun.equals("login")) {
				GoLogin(request, response);
			}
			
			
			
		
	}
	
	protected void GoIndex(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	

		
		//index.jsp 필요한 데이터들을 가져와서
				//index.jsp로 이동.
		//학생리스트 가필요해
		
		request.setAttribute("isSuc", false);
		String strURL = "./index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(strURL);
		dispatcher.forward(request, response);
		
	}
	
	protected void GoLogin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		

		//index.jsp 필요한 데이터들을 가져와서
				//index.jsp로 이동.
		//학생리스트 가필요해
		request.setAttribute("isSuc", true);
		String strURL = "./Members/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(strURL);
		dispatcher.forward(request, response);
		
	}	

}
