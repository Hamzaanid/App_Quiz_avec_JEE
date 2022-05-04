package services;

import beans.question; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class dao_question {
	static Connection cnx = null;
	public static void   startConnection() {
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbqcm", "root", "");
	  }catch(Exception e) {
		System.out.println(e);
	  }
	}
	
	public static List<question> getQuestions(int id_form) {
		List<question> lsquest = new ArrayList<question>();
		try {
			startConnection();
			String sql = "select * from question where id_form=? ;";
			PreparedStatement s =  cnx.prepareStatement(sql);
			s.setInt(1, id_form);
			ResultSet rs =s.executeQuery();
			while(rs.next()) {
				question qi = new question();
			      qi.setId_question(rs.getInt(1));
			      qi.setId_form(rs.getInt(2));
			      qi.setLib_question(rs.getString(3));
			      
			    lsquest.add(qi);
			}
			cnx.close();
		}catch(Exception e1) {System.out.println(e1);}
		return lsquest;
	}
	
	
	}
	
	
