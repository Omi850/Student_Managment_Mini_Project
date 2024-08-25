package Com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.bean.student;
import Com.dau.Query;

/**
 * Servlet implementation class Controllerservlet
 */
@WebServlet("/Controllerservlet")
public class Controllerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controllerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter pw=response.getWriter();
	  String data=request.getParameter("data");
      if(data.equals("insert")) {
    	  student ob=new student();
    	  ob.setName(request.getParameter("name"));
    	  ob.setMobile(request.getParameter("mobile"));
    	  ob.setGender(request.getParameter("gender"));
    	  ob.setCity(request.getParameter("city"));
    	  ob.setPassword(request.getParameter("password"));
    	  try {
			if(Query.insert(ob)!=0) {
				  pw.print("<html><script>alert('Data has been Inserted!!');window.location.replace('login.jsp');</script></html>");
			  }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }else if(data.equals("login")) {
    	  try {
			if(Query.login(request.getParameter("mobile"),request.getParameter("password"))==true) {
				  pw.print("<html><script>alert('Login Successfull!!');window.location.replace('home.jsp');</script></html>");
			  }else {
				  pw.print("<html><script>alert('Login Failed passowrd or mobile Incorret!!');window.location.replace('login.jsp');</script></html>"); 
			  }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }else if(data.equals("updatefetch")) {
    	  RequestDispatcher td=request.getRequestDispatcher("Update.jsp");
    	  td.include(request, response);
      }else if(data.equals("update")) {
    	  student ob=new student();
    	  ob.setId(Integer.parseInt(request.getParameter("id")));
    	  ob.setName(request.getParameter("name"));
    	  ob.setMobile(request.getParameter("mobile"));
    	  ob.setPassword(request.getParameter("password"));
    	  ob.setCity(request.getParameter("city"));
    	  ob.setGender(request.getParameter("gender"));
    	  try {
			if(Query.update(ob)!=0) {
				  pw.print("<html><script>alert('Data Updated Successfully!!');window.location.replace('fetch.jsp');</script></html>");
			  }else {
				  pw.print("<html><script>alert('Data Failed Updated !!');window.location.replace('fetch.jsp');</script></html>");
			  }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }else if(data.equals("delete")) {
    	  try {
			if(Query.delete(Integer.parseInt(request.getParameter("id")))!=0) {
				  pw.print("<html><script>alert('Data Deleted Successfully!!');window.location.replace('fetch.jsp');</script></html>");
			  }else {
				  pw.print("<html><script>alert('Data Failed Deleted !!');window.location.replace('fetch.jsp');</script></html>");
			  }
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
      }
	}

}
