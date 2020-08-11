package PKG_FILE;

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

import PKG_DB.DBConn;

@WebServlet("/FileList")
public class FileList extends HttpServlet {
       
    public FileList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doWork(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doWork(request, response);
		
	}
	
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String strFilename = "";//request.getParameter("");
		
		DBConn dbConn = new DBConn("jdbc:oracle:thin:@localhost:1521:xe", "ey", "1234");
		
		String strProcSql = "CALL PKG_FILES.PROC_SEL_FILES(?, ?)";
		String [] strInParams	= {strFilename,	""};
		String [] strInOut		= {"IN",		"OUT"};
		int [] sqlTypes			= {0,			oracle.jdbc.OracleTypes.CURSOR};
		
		ResultSet rs = dbConn.getResultSet(strProcSql, strInParams, strInOut, sqlTypes);
		
		ArrayList<FileVO> arrFile = new ArrayList<>();
		
		try {
			
			while (rs.next()) {
				
				FileVO fileVO = new FileVO();
				fileVO.setIdx(rs.getString("IDX"));
				fileVO.setWname(rs.getString("WNAME"));
				fileVO.setCfname(rs.getString("CFNAME"));
				fileVO.setSfname(rs.getString("SFNAME"));
				fileVO.setFsize(rs.getString("FSIZE"));
				
				arrFile.add(fileVO);
				
			}
			
			request.setAttribute("fileList", arrFile);
			
			String strURL = "./FileUpload/list.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(strURL);
	    	dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
