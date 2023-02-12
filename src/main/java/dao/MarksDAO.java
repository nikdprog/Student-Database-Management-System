package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Marks;

public class MarksDAO {
	 Connection conn;
	 public MarksDAO(Connection conn) {
		 this.conn = conn;
	 } 
	 public ArrayList<Marks> getAll() throws SQLException {
		
	     PreparedStatement st = conn.prepareStatement("select * from marks");
	     
	     ResultSet rs = st.executeQuery();
	     ArrayList<Marks> lst = new ArrayList();
	     while (rs.next()) {
	    	 Marks gp = new Marks();
	    	 gp.setMark(rs.getInt(1));
	    	 gp.setStudent_id(rs.getInt(2));
	    	 gp.setSubject_id(rs.getInt(3));
	    	 gp.setModification_time(rs.getTimestamp(4));
	    	 gp.setMark_id(rs.getInt(5));
	    	 gp.setLecture_id(rs.getInt(6));
	    	 lst.add(gp);
	     }
	     rs.close();
	     st.close();
	     return lst;
	 }
	 public Marks get(int id) throws SQLException {
		 try (
			 PreparedStatement ps = conn.prepareStatement
			 ("SELECT * FROM marks WHERE mark_id = ?")
		     ) {
			 ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
			 if (rs.next()) {
			 Marks obj = new Marks();
			 obj.setMark(rs.getInt("mark"));
			 obj.setStudent_id(rs.getInt("student_id"));
			 obj.setSubject_id(rs.getInt("subject_id"));
			 obj.setLecture_id(rs.getInt("lecture_id"));	
			 obj.setModification_time(rs.getTimestamp("modification_time"));
			 obj.setMark_id(rs.getInt("mark_id"));
			 return obj;
			 }
			 } catch (SQLException e) {
			 e.printStackTrace();
			 }
			 return null;
	 }
	 
	 public int check(Marks obj) throws SQLException {
		 if(obj.getMark_id() == 0)
			 return insert(obj);
		 else return update(obj);
	 }
	 
	 public int insert(Marks obj) throws SQLException {
		 int id = -1;
		 try (
		 PreparedStatement preparedStatement =
		conn.prepareStatement(
		 "INSERT INTO marks (mark, student_id, subject_id, modification_time, lecture_id) VALUES(?, ?, ?, ?, ?)",
		 Statement.RETURN_GENERATED_KEYS
		 )
		 ) {
	     preparedStatement.setInt(1, obj.getMark());
		 preparedStatement.setInt(2, obj.getStudent_id());
		 preparedStatement.setInt(3, obj.getSubject_id());
		 preparedStatement.setTimestamp(4, obj.getModification_time());
		 preparedStatement.setInt(5, obj.getLecture_id());
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
	
	 public int update(Marks obj) throws SQLException {
		 try (
			 PreparedStatement preparedStatement =
			 conn.prepareStatement("UPDATE marks SET mark = ?, student_id = ?, subject_id = ?, lecture_id = ?, modification_time = ? WHERE mark_id = ?")
			 ) {
			 preparedStatement.setInt(1, obj.getMark());
			 preparedStatement.setInt(2, obj.getStudent_id());
			 preparedStatement.setInt(3, obj.getSubject_id());
			 preparedStatement.setInt(4, obj.getLecture_id());
			 preparedStatement.setTimestamp(5, obj.getModification_time());
			 preparedStatement.setInt(6, obj.getMark_id());
			 preparedStatement.executeUpdate();
	     } catch (SQLException e) {
			 e.printStackTrace();
			 }
		 return obj.getLecture_id();	 
	 }
	 
	 public void delete(int id) throws SQLException {
		 try {
			 PreparedStatement preparedStatement =
			 conn.prepareStatement("DELETE FROM marks WHERE mark_id = ?");
			 preparedStatement.setInt(1, id);
			 preparedStatement.executeUpdate();
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	 }
}