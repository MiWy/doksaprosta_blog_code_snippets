package com.tryouts.diaryservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DiaryArchive")
public class DiaryArchive extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/diary";
    private static final String USER = "root";
    private static final String PASS = "root";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "My Db Diary";
		String docType =  "<!DOCTYPE html>\n";
		
		out.println(docType + 
				"<html>\n" +
				"<head><title>" + title + "</title></header>\n" +
				"<body bgcolor = \"#f3f3f3\">\n" +
				"<h1 align = \"center\">" + title + "</h1>\n" +
				"<h3 align = \"center\"><a href=\"http://localhost:8080/DiaryServlet/DiaryMain.html\">Add new entry</a></h3>");
		
		try {	
			// Rejestrujemy sterownik.
			Class.forName(JDBC_DRIVER);
			
		    // Podłączamy się do naszej bazy MySQL
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			
		    // Przygotowujemy zapytanie do bazy oraz obiekt klasy ResultSet z danymi zwrotnymi.
			Statement stmt = con.createStatement();
			String sql = "SELECT id, date, title, content FROM ENTRIES";
			ResultSet rs = stmt.executeQuery(sql);
			
		        // Parsujemy każdy kolejny wiersz pobrany do obiektu ResultSet do kodu HTML.
			while(rs.next()) {
				int id = rs.getInt("id");
				Timestamp ts = rs.getTimestamp("date");
				String entryTitle = rs.getString("title");
				String entryContent = rs.getString("content");
				
				out.println("<h3 align = \"center\">" + id + ": " + ts.toString() + "</h3>");
				out.println("<h2 align = \"center\">" + entryTitle + "</h2><br>");
				out.println(entryContent + "<br>");
			}
			out.println("</body></html>");
			
		    // Zamykamy połączenia z bazą danych (dla przejrzystości przykładu zakładamy, że nie wystąpią w tym miejscu wyjątki).	
			rs.close();
			stmt.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
