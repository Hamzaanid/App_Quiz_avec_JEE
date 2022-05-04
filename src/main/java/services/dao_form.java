package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.form;

public class dao_form {
	static Connection cnx = null;
	public static void   startConnection() {
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbqcm", "root", "");
	  }catch(Exception e) {
		System.out.println(e);
	  }
	}
	// recuperer tous forms des QCM
	public static List<form> getForms() {
		List<form> lsform = new ArrayList<form>();
		try {
			startConnection();
			String sql = "select * from form ;";
			PreparedStatement s =  cnx.prepareStatement(sql);
			ResultSet rs =s.executeQuery();
			while(rs.next()) {
				form fo = new form();
				fo.setId_form(rs.getInt(1));
				fo.setLib_form(rs.getString(2));
				lsform.add(fo);
			}
			cnx.close();
		}catch(Exception e1) {System.out.println(e1);}
		return lsform;
	}
	
	public static form find(int id) {
		form fo = new form();
		try {
			String sql = "select * from reponse where id_form = ? ;";
			PreparedStatement s =  cnx.prepareStatement(sql);
			s.setInt(1, id);
			ResultSet rs =s.executeQuery();
			rs.next();
			fo.setId_form(rs.getInt(1));
			fo.setLib_form(rs.getString(2));
			cnx.close();
		}catch(Exception e1) {System.out.println(e1);}
		//return lsreponse;
		return fo;
	}
}
