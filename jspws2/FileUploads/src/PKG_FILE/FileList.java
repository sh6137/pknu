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

import PKG_DB.DBCon;


@WebServlet("/FileList")
public class FileList extends HttpServlet {

    public FileList() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request, response);
	}
	
	protected void doWork(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String strFileName = "";
		
		DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "testdb", "1234");
		
		String strProcName = "CALL PKG_FILES.PROC_SEL_FILES(?,?)";
		String[] strParams = {strFileName, ""};
		String[] strInOut = {"IN", "OUT"};
		int[] sqlTypes = {0, oracle.jdbc.OracleTypes.CURSOR};
		
		ResultSet rs = db.getResultSet(strProcName, strParams, strInOut, sqlTypes);
		
		ArrayList<FileVO> arrList = new ArrayList<>();
		
		try {
			
				while(rs.next()) {
					FileVO fileVO = new FileVO();
					fileVO.setIdx(rs.getString("IDX"));
					fileVO.setName(rs.getString("NAME"));
					fileVO.setOrgFileName(rs.getString("FILENAME1"));
					fileVO.setNewFileName(rs.getString("FILENAME2"));
					fileVO.setFilesize(rs.getString("FILESIZE"));
					
					arrList.add(fileVO);
				}
				
				request.setAttribute("fileList", arrList);
				
				String strURL= "./FileUploads/list.jsp";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(strURL);
				dispatcher.forward(request, response);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
