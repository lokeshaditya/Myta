package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Enter extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			
			if(request.getParameter("login") != null){
				PreparedStatement ps = con.prepareStatement("select pass from occasional_user where email = ?"
						,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ps.setString(1, request.getParameter("email1"));
			
				if(ps.execute()){
					ResultSet rs = ps.executeQuery();
					System.out.println(rs.getRow());
					rs.first();
					System.out.println(rs.getRow());
					if(rs.getString("pass").compareTo(request.getParameter("passl")) ==0 ){
						System.out.println("login successfull");
						request.setAttribute("email", request.getParameter("email1"));
						RequestDispatcher rd = request.getRequestDispatcher("/servlethtml/Occasion.jsp");
						rd.forward(request, response);
					}
					else{
						System.out.println("frm db="+rs.getString("pass"));
						System.out.println("frm usr="+request.getParameter("passl"));
						pw.println("Password didnot match");
					}
				}
			}
			else if(request.getParameter("Regester") != null){
				String email = request.getParameter("email");
				String pass = request.getParameter("pass2");
				PreparedStatement ps = con.prepareStatement("insert into occasional_user(email,pass) values(?,?)");
				ps.setString(1, email);
				ps.setString(2, pass);
				if(ps.executeUpdate() > 0){
					pw.print("User created <h3>Successfully!!</h3>");
					pw.println("click <a href=\"http://localhost:8888/Mypractice/servlethtml/Entrance.html\">here</a> to login");
				}
				else{
					pw.print("Error creating a User :(");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
