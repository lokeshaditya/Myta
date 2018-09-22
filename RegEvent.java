package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegEvent extends HttpServlet {

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement ps = con
					.prepareStatement("insert into occasion (name,description,dated,email) values(?,?,?,?)");
			ps.setString(1, request.getParameter("name"));
			ps.setString(2, request.getParameter("description"));
			System.out.println(request.getParameter("dated"));
			java.util.Date date1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(request.getParameter("dated"));
			java.sql.Date dated = new java.sql.Date(date1.getTime());
			ps.setDate(3,dated);
			ps.setString(4, request.getParameter("email"));
			
			if (ps.executeUpdate() != 0) {
				
				pw.println("<h3>inserted successfully</h3><br/>");
				request.setAttribute("email", request.getParameter("email"));
				RequestDispatcher rd = request.getRequestDispatcher("/servlethtml/Occasion.jsp");
				rd.forward(request, response);
				pw.println("<a href=\"http://localhost:8888/Mypractice/servlethtml/Occasion.jsp\">"
						+ " select * from Occasions</a>");
				pw.close();
			}
			else{

				pw.println("Error in insertion");
				pw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("Please enter required details :-(");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
