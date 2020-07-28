package PKG_SERV;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cal")
public class Cal extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public Cal() {
        super();
    }

    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String strGubun = request.getParameter("gubun");
       
       if(strGubun.equals("1")) {
          cal01(request, response);
       }
       if(strGubun.equals("2")) {
          cal02(request, response);
       }
       if(strGubun.equals("3")) {
          cal01(request, response);
       }
   }
    
    
    protected void cal01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String strURL = request.getParameter("strURL");
       String strNum = request.getParameter("num");
       int num = Integer.parseInt(strNum);
       
       int result = num * 2;
       
       request.setAttribute("result", Integer.toString(result));
       
       String strGubun = request.getParameter("gubun");
       
       if(strGubun.equals("3")) {
          cal02(request, response);
       }
       else {
          RequestDispatcher dispatcher = request.getRequestDispatcher(strURL);
          dispatcher.forward(request, response);
       }
   }
    
    
    protected void cal02(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String strURL = request.getParameter("strURL");
       String strNum = request.getParameter("num");
       int num = Integer.parseInt(strNum);
       
       int result = num * 3;
       
       request.setAttribute("result2", Integer.toString(result));
       
       String strGubun = request.getParameter("gubun");
       
       if(strGubun.equals("3")) {
          String result1 = (String) request.getAttribute("result");
          request.setAttribute("result1", result1);
          
          RequestDispatcher dispatcher = request.getRequestDispatcher(strURL);
          dispatcher.forward(request, response);
       }
       else {
          RequestDispatcher dispatcher = request.getRequestDispatcher(strURL);
          dispatcher.forward(request, response);
       }
   }
    
    
    /*
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }
   */
}