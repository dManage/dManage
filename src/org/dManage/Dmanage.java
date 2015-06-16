package org.dManage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dManage.jdbc.db.JDBCMySQLConnection;
import org.dManage.jdbc.db.User;

/**
 * Servlet implementation class Dmanage
 */
@WebServlet(description = "simple servlet", urlPatterns = { "/Dmanage" })
public class Dmanage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
		
	        String id = request.getParameter("id");
		try {
			
			int userId = Integer.parseInt(id);
			Dmanage demo = new Dmanage();
			User user = demo.getUser(userId);
			out.println(user);			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<html><form method=\"post\" action=\"Dmanage\">Id:<input type=\"text\""+
		"name=\"id\" /><br/><input type=\"submit\" value=\"register\" />"+
		"</form></html>");
	}


	private User getUser(int id) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null; 
		
		User user = null;
		String query = "SELECT * FROM users WHERE id=" + id;
		try {			
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword((rs.getString("password")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

}
