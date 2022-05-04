package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.reponse;

public class dao_reponse {

	static Connection cnx = null;
	public static void   startConnection() {
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbqcm", "root", "");
	  }catch(Exception e) {
		System.out.println(e);
	  }
	}
	
	public static List<reponse> getReponseFor(int id_question) {
		List<reponse> lsreponse = new ArrayList<reponse>();
		try {
			startConnection();
			String sql = "select * from reponse where id_question=? ;";
			PreparedStatement s =  cnx.prepareStatement(sql);
			s.setInt(1, id_question);
			ResultSet rs =s.executeQuery();
			while(rs.next()) {
				reponse re = new reponse();
				
				re.setId_reponse(rs.getInt(1));
				re.setId_question(rs.getInt(2));
			      re.setLib_reponse(rs.getString(3));
			      //re.setCorrect(rs.getBoolean(4));
			      lsreponse.add(re);
			}
			cnx.close();
		}catch(Exception e1) {System.out.println(e1);}
		return lsreponse;
	}
	// get score
	public static boolean isCorrect(int reponse) {
		boolean result=false;
		try {
			startConnection();
			String sql = "select correct from reponse where id_reponse = ? ;";
			PreparedStatement s =  cnx.prepareStatement(sql);
			s.setInt(1, reponse);
			ResultSet rs =s.executeQuery();
			rs.next();
			result = rs.getBoolean(1);
			cnx.close();
		}catch(Exception e1) {System.out.println(e1);}
		//return lsreponse;
		return result;
	}
}
