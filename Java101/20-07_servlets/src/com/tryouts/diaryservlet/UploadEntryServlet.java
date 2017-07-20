package com.tryouts.diaryservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DiaryNew")
public class UploadEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/diary";
    private static final String USER = "root";
    private static final String PASS = "root";
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Tym razem pobieramy informacje z obiektu HttpServletRequest 
		String entryTitle = request.getParameter("title");
		String content = request.getParameter("entry");
		// Jedna z kolumn w bazie jest typu DATETIME, potrzebujemy więc obiektu Timestamp z aktualną datą.
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		try {
			Class.forName(JDBC_DRIVER);
			
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			
			// Przygotowujemy dane do wysłania do bazy.
			String sql = "INSERT INTO ENTRIES (content, date, title) values (?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, content);
			statement.setString(3,  entryTitle);
			statement.setTimestamp(2, timestamp);
			
			// Wysyłamy przygotowane dane do bazy i zamykamy połączenia.
			statement.executeUpdate();
			statement.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("DiaryArchive");
	}

}
