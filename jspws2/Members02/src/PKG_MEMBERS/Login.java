package PKG_MEMBERS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import PKG_DB.DBCon;


@WebServlet("/Login")
public class Login extends HttpServlet {

    public Login() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doWork(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException 
		
	{
		doWork(request, response);
	}
	
	protected void doWork(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		String strGubun = request.getParameter("gubun");
		if(strGubun == null) {
			 
		}
		//ajax 요청이 오면 여기를 실행
		else if(strGubun.equals("ajax")) {
			do_Ajax(request, response);
		}
		else if(strGubun.equals("login")) {
			Login(request, response);
		}
		else if(strGubun.equals("LogSuc")) {
			LogSuc(request, response);
		}
		else {
			LogOut(request, response);
		}
		
	}
	
	protected void Login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		//1.login
		
		String strUserID = request.getParameter("userID");
		String strUserPass = request.getParameter("userPass");
		
		DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "lje", "1");
		
		String strProcName = "CALL PKG_MEMBERS.PROC_LOGIN(?,?,?)";
		String[] strParams = {strUserID, strUserPass, ""};
		String[] strInOuts = {"IN", "IN", "OUT"};
		int[] strTypes = {0,0, oracle.jdbc.OracleTypes.CURSOR};
		
		ResultSet rs = db.getResultSet(strProcName, strParams, strInOuts, strTypes);
		
		try {
			
			rs.next();
			
			int cnt = Integer.parseInt(rs.getString("CNT"));
			
			String strURL = "";
			boolean isSuc = false;
			
			if(cnt > 0) {
				//로그인 성공
				
				strURL = "./WebPage/fileupload.jsp";
				isSuc = true;
				
				//Session변수 생성
				session.setAttribute("userID", strUserID);
				
				request.setAttribute("isSuc", isSuc);
			}
			else {
				//로그인 실패
				
				strURL = "./Members/login.jsp";
				isSuc = false;
				request.setAttribute("isSuc", isSuc);
			}
			
			PrintWriter out = response.getWriter();
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(strURL);
			dispatcher.forward(request, response);
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}
	
	
	protected void LogOut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		request.setAttribute("isSuc", false);
		
		String strURL = "./index.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(strURL);
		dispatcher.forward(request, response);
	}
	
	protected void do_Ajax(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1.login
		
		String strUserID = request.getParameter("userID");
		String strUserPass = request.getParameter("userPass");
		
		DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "lje", "1");
		
		String strProcName = "CALL PKG_MEMBERS.PROC_LOGIN(?,?,?)";
		String[] strParams = {strUserID, strUserPass, ""};
		String[] strInOuts = {"IN", "IN", "OUT"};
		int[] strTypes = {0,0, oracle.jdbc.OracleTypes.CURSOR};
		
		ResultSet rs = db.getResultSet(strProcName, strParams, strInOuts, strTypes);
		
	
			
			try {
				rs.next();
				
				JSONObject obj = new JSONObject();
				obj.put("result", rs.getString("CNT"));
				
				PrintWriter out = response.getWriter();	
				response.setContentType("Application/json");
				out.println(obj);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			

			
			
	}
	
	
	protected void LogSuc(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String strUserID = request.getParameter("sendUserID");
		
		HttpSession session = request.getSession();
		
		String strURL = "./index.jsp";
		boolean isSuc = true;
		
		//Session변수 생성
		session.setAttribute("userID", strUserID);
		
		request.setAttribute("isSuc", isSuc);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(strURL);
		dispatcher.forward(request, response);
	}
	

}
