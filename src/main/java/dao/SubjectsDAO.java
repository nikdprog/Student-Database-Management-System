package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Subjects;

public class SubjectsDAO {
	 Connection conn;
	 public SubjectsDAO(Connection conn) {
		 this.conn = conn;
	 } 
	 public ArrayList<Subjects> getAll() throws SQLException {
	     PreparedStatement st = conn.prepareStatement("select * from subjects");
	     ResultSet rs = st.executeQuery();
	     ArrayList<Subjects> lst = new ArrayList();
	     while (rs.next()) {
	    	 Subjects gp = new Subjects();
	    	 gp.setSubject_id(rs.getInt(1));
	    	 gp.setSubject(rs.getString(2));
	    	 gp.setHours(rs.getInt(3));
	    	 lst.add(gp);
	     }
	     rs.close();
	     st.close();
	     return lst;
	 }
	 public Subjects get(int id) throws SQLException {
		 try (
			 PreparedStatement ps = conn.prepareStatement
			 ("SELECT * FROM subjects WHERE subject_id = ?")
		     ) {
			 ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
			 if (rs.next()) {
			 Subjects obj = new Subjects();
			 obj.setSubject_id(rs.getInt("subject_id"));
			 obj.setSubject(rs.getString("subject"));
			 obj.setHours(rs.getInt("hours"));
			 return obj;
			 }
			 } catch (SQLException e) {
			 e.printStackTrace();
			 }
			 return null;
	 }
	 public int check(Subjects obj) throws SQLException {
		 if(obj.getSubject_id() == 0)
			 return insert(obj);
		 else return update(obj);
	 }
	 public int insert(Subjects obj) throws SQLException {
		 int id = -1;
		 // INSERT INTO subjects (lecture_id, subject, hours) VALUES(?, ?, ?)",
		 try (
				 
		 PreparedStatement preparedStatement =
		conn.prepareStatement(
		 "INSERT INTO subjects (subject, hours) VALUES(?, ?)",
		 Statement.RETURN_GENERATED_KEYS
		 )
		 ) {
	     preparedStatement.setString(1, obj.getSubject());
		 preparedStatement.setInt(2, obj.getHours());
		 ResultSet rs = preparedStatement.getGeneratedKeys();
		 if (rs != null && rs.next()) {
		 id = rs.getInt(1);
		 rs.close();
		 }
		 preparedStatement.executeUpdate();
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		 return id;
	 }
	
	 public int update(Subjects obj) throws SQLException {
		 try (
			 PreparedStatement preparedStatement =
			 conn.prepareStatement("UPDATE subjects SET subject = ?, hours = ? WHERE subject_id = ?")
			 ) {		
			 preparedStatement.setString(1, obj.getSubject());
			 preparedStatement.setInt(2, obj.getHours());
			 preparedStatement.setInt(3, obj.getSubject_id());
			 preparedStatement.executeUpdate();
	     } catch (SQLException e) {
			 e.printStackTrace();
			 }
		 return obj.getSubject_id();	 
	 }
	 
	 public void delete(int id) throws SQLException {
		 try {
			 PreparedStatement prepStatement = 
			 conn.prepareStatement("DELETE FROM marks WHERE subject_id = ?");
			 prepStatement.setInt(1, id);
			 prepStatement.executeUpdate();
			 
			 PreparedStatement preparedStatement =
			 conn.prepareStatement("DELETE FROM subjects WHERE subject_id = ?");
			 preparedStatement.setInt(1, id);
			 preparedStatement.executeUpdate();
			  
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	 }
}