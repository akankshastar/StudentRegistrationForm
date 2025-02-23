package cscorner;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		PrintWriter out=response.getWriter();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "niveditha123*");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
      
        PreparedStatement ps = con.prepareStatement("INSERT INTO student(first_name, last_name, username, password, address, contact) VALUES (?, ?, ?,?,?,?)");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3,username);
            ps.setString(4, password);
            ps.setString(5, address);
            ps.setString(6, contact);
            
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted >=0) {
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
            } 
            else {
                out.println("<font color='red' size='18'>Registration Failed!<br>");
                out.println("<a href='studentregistration.jsp'>Try Again !! </a>");
            } 
		}
        catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
		      
			e.printStackTrace();
		}
	};

}
