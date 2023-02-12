package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Lectures;

public class LecturesDAO {
	 Connection conn;
	 public LecturesDAO(Connection conn) {
		 this.conn = conn;
	 } 
	 public ArrayList<Lectures> getAll() throws SQLException {
	     PreparedStatement st = conn.prepareStatement("select * from lectures");
	     ResultSet rs = st.executeQuery();
	     ArrayList<Lectures> lst = new ArrayList();
	     while (rs.next()) {
	    	 Lectures gp = new Lectures();
	    	 gp.setLecture_id(rs.getInt(1));
	    	 gp.setSurname(rs.getString(2));
	    	 gp.setName_(rs.getString(3));
	    	 gp.setSecond_name(rs.getString(4));
	    	 gp.setPhone_number(rs.getString(5));
	    	 gp.setWork_experience(rs.getString(6));
	    	 lst.add(gp);
	     }
	     rs.close();
	     st.close();
	     return lst;
	 }
	 public Lectures get(int id) throws SQLException {
		 try (
			 PreparedStatement ps = conn.prepareStatement
			 ("SELECT * FROM lectures WHERE lecture_id = ?")
		     ) {
			 ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
			 if (rs.next()) {
			 Lectures obj = new Lectures();
			 obj.setLecture_id(rs.getInt("lecture_id"));
			 obj.setSurname(rs.getString("surname"));
			 obj.setName_(rs.getString("name_"));
			 obj.setSecond_name(rs.getString("second_name"));
			 obj.setPhone_number(rs.getString("phone_number"));
			 obj.setWork_experience(rs.getString("work_experience"));
			 return obj;
			 }
			 } catch (SQLException e) {
			 e.printStackTrace();
			 }
			 return null;
	 }
	 public int check(Lectures obj) throws SQLException {
		 if(obj.getLecture_id() == 0)
			 return insert(obj);
		 else return update(obj);
	 }
	 public int insert(Lectures obj) throws SQLException {
		 int id = -1;
		 try (
		 PreparedStatement preparedStatement =
		conn.prepareStatement(
		 "INSERT INTO lectures (surname, name_, second_name, phone_number, work_experience) VALUES(?, ?, ?, ?, ?)",
		 Statement.RETURN_GENERATED_KEYS
		 )
		 ) {
		 preparedStatement.setString(1, obj.getSurname());
		 preparedStatement.setString(2, obj.getName_());
		 preparedStatement.setString(3, obj.getSecond_name());
		 preparedStatement.setString(4, obj.getPhone_number());
		 preparedStatement.setString(5, obj.getWork_experience());
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
	
	 public int update(Lectures obj) throws SQLException {
		 try (
			 PreparedStatement preparedStatement =
			 conn.prepareStatement("UPDATE lectures SET surname = ?, name_ = ?, second_name = ?, phone_number = ?, work_experience = ? WHERE lecture_id = ?")
			 ) {
			 preparedStatement.setString(1, obj.getSurname());
			 preparedStatement.setString(2, obj.getName_());
			 preparedStatement.setString(3, obj.getSecond_name());
			 preparedStatement.setString(4, obj.getPhone_number());
			 preparedStatement.setString(5, obj.getWork_experience());
			 preparedStatement.setInt(6, obj.getLecture_id());
			 preparedStatement.executeUpdate();
	     } catch (SQLException e) {
			 e.printStackTrace();
			 }
		 return obj.getLecture_id();	 
	 }
	 
	 public void delete(int id) throws SQLException {
		 try {
			 PreparedStatement prepStatement =
			 conn.prepareStatement("DELETE FROM marks WHERE lecture_id = ?");
			 prepStatement.setInt(1, id);
			 prepStatement.executeUpdate();
					 
			 PreparedStatement preparedStatement =
			 conn.prepareStatement("DELETE FROM lectures WHERE lecture_id = ?");
			 preparedStatement.setInt(1, id);
			 preparedStatement.executeUpdate();
			  
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	 }
}


