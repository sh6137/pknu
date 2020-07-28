package PKG_STUDENT;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PKG_DB.DBCon;


@WebServlet("/Students")
public class Students extends HttpServlet {
	

    public Students() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		try {
			do_work(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			do_work(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void do_work(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException
	{
			String strDoWork = request.getParameter("doWork");
			
			
			
			if(strDoWork.equals("list")) {
				student_List(request, response);
			}
			if(strDoWork.equals("detail")) {
				student_Detail(request, response);
			}
	}
	
	protected void student_List(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "testdb", "1234");
		
		String strSql = "SELECT * FROM STUDENTS_TBL ORDER BY STU_ID ASC";
		ResultSet rs = db.getResultSet(strSql);
				
		ArrayList<Student> arrStudents = new ArrayList<>();
				
		while(rs.next()) {
		
			Student student = new Student();
			student.setStu_id(rs.getString("STU_ID"));
			student.setStu_name(rs.getString("STU_NAME"));
			student.setStu_tel(rs.getString("STU_TEL"));
			
			arrStudents.add(student);
		}
		
		request.setAttribute("students", arrStudents);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/02_Students/students_list.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void student_Detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException
		{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
				
		//1. db연결해서 원하는 데이터 가져오기
		String strStu_ID = request.getParameter("stu_id");
		
		DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "testdb", "1234");
		
		String strSql = "SELECT * FROM STUDENTS_TBL WHERE STU_ID='" + strStu_ID + "' ORDER BY STU_ID ASC";
		
		ResultSet rs = db.getResultSet(strSql);
		
		rs.next();
		
		Student stud = new Student();
		
		stud.setStu_id(rs .getString("STU_ID"));
		stud.setStu_name(rs .getString("STU_NAME"));
		stud.setStu_tel(rs .getString("STU_TEL"));
		
		request.setAttribute("student", stud);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/02_Students/students_detail.jsp");
		dispatcher.forward(request, response);
				
		}

}
