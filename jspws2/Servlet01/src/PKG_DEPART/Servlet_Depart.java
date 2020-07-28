package PKG_DEPART;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PKG_DB.DBCon;


@WebServlet("/Depart")
public class Servlet_Depart extends HttpServlet {
	    
   
    public Servlet_Depart() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doWork(request,response);
	}

	protected void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String strDoWork = request.getParameter("doWork");
		
		if(strDoWork.equals("list")) {
			
			Depart_List(request,response);
		}
		else if(strDoWork.equals("update")) {
			Depart_Update(request,response);
		}
		else if(strDoWork.equals("updateOK")) {
			Depart_UpdateOK(request,response);
		}
	}
	

	protected void Depart_List(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "testdb", "1234");
		
		String strSql = "SELECT * FROM COMMONS_TBL " + 
				"START WITH PARENT_ID='ROOT' AND GRP_ID='GRP002' " + 
				"CONNECT BY PRIOR COM_ID = PARENT_ID AND GRP_ID = 'GRP002' ";
		ResultSet rs = db.getResultSet(strSql);
		
		ArrayList arr = new ArrayList();
		
		try {
			while(rs.next()) {
				DepartVO depart = new DepartVO();
				depart.setCom_id(rs.getString("COM_ID"));
				depart.setGrp_id(rs.getString("GRP_ID"));
				depart.setCom_val(rs.getString("COM_VAL"));
				depart.setCom_lvl(rs.getString("COM_LVL"));
				
				arr.add(depart);
			}
			request.setAttribute("departList", arr);
			
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/03_Departs/Departs_List.jsp");
		 dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	protected void Depart_Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String strGrpID = request.getParameter("grp_id");
		String strComID = request.getParameter("com_id");
		
		DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "testdb", "1234");
		
		String strSql = "SELECT*FROM COMMONS_TBL WHERE GRP_ID='"+strGrpID+"'AND COM_ID='"+strComID+"'";
		ResultSet rs = db.getResultSet(strSql);
		
		try {
			rs.next();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		DepartVO dpt = new DepartVO();
		try {
			dpt.setCom_id(rs.getString("COM_ID"));
			dpt.setGrp_id(rs.getString("GRP_ID"));
			dpt.setCom_val(rs.getString("COM_VAL"));
			dpt.setCom_lvl(rs.getString("COM_LVL"));
			
			request.setAttribute("depart", dpt);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/03_Departs/Departs_update.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void Depart_UpdateOK(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String strGrpID = request.getParameter("grp_id");
		String strComID = request.getParameter("com_id");
		String strComVal = request.getParameter("com_val");
		String strComLvl = request.getParameter("com_lvl");
		
		DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "testdb", "1234");
		
		String strSql = "UPDATE COMMONS_TBL ";
		strSql +="SET COM_VAL='"+strComVal+"', COM_LVL = '"+strComLvl+"' ";
		strSql +="WHERE COM_ID = '"+strComID+"' AND GRP_ID ='"+strGrpID+"'";
		
		db.setCUD(strSql);
		//list 로 돌아간다.
		Depart_List(request,response);
	}
	
	
	
	


	
}
