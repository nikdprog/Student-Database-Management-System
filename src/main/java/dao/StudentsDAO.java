package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Students;

public class StudentsDAO {
	 Connection conn;
	 public StudentsDAO(Connection conn) {
		 this.conn = conn;
	 } 

	public ArrayList<Students> getAll() throws SQLException {
	     PreparedStatement st = conn.prepareStatement("select * from students");
	     ResultSet rs = st.executeQuery();
	     ArrayList<Students> lst = new ArrayList();
	     while (rs.next()) {
	    	 Students gp = new Students();
	    	 gp.setStudent_id(rs.getInt(1));
	    	 gp.setGroup_id(rs.getInt(2));
	    	 gp.setSurname(rs.getString(3));
	    	 gp.setName_(rs.getString(4));
	    	 gp.setSecond_name(rs.getString(5));
	    	 gp.setPhone_number(rs.getString(6));
	    	 gp.setGrant_(rs.getDouble(7));
	    	 lst.add(gp);
	     } 
	     rs.close();
	     st.close();
	     return lst;
	 }
	
	public Students get(int id) throws SQLException {
		 try (
			 PreparedStatement ps = conn.prepareStatement
			 ("SELECT * FROM students WHERE student_id = ?")
		     ) {
			 ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
			 if (rs.next()) {
			 Students obj = new Students();
			 obj.setStudent_id(rs.getInt("student_id"));
			 obj.setGroup_id(rs.getInt("group_id"));
			 obj.setSurname(rs.getString("surname"));
			 obj.setName_(rs.getString("name_"));
			 obj.setSecond_name(rs.getString("second_name"));
			 obj.setPhone_number(rs.getString("phone_number"));
			 obj.setGrant_(rs.getDouble("grant_"));
			 return obj;
			 }
			 } catch (SQLException e) {
			 e.printStackTrace();
			 }
			 return null;
	 }
	
	 public int check(Students obj) throws SQLException {
		 if(obj.getStudent_id() == 0)
			 return insert(obj);
		 else return update(obj);
	 }
	
	 public int insert(Students obj) throws SQLException {
		 int id = -1;
		 try (
		 PreparedStatement preparedStatement =
		conn.prepareStatement(
		 "INSERT INTO students (group_id, surname, name_, second_name, phone_number, grant_ ) VALUES(?, ?, ?, ?, ?, ?)",
		 Statement.RETURN_GENERATED_KEYS
		 )
		 ) {
	     preparedStatement.setInt(1, obj.getGroup_id());
		 preparedStatement.setString(2, obj.getSurname());
		 preparedStatement.setString(3, obj.getName_());
		 preparedStatement.setString(4, obj.getSecond_name());
		 preparedStatement.setString(5, obj.getPhone_number());
		 preparedStatement.setDouble(6, obj.getGrant_());
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
	
	 public int update(Students obj) throws SQLException {
		 try (
			 PreparedStatement preparedStatement =
			 conn.prepareStatement("UPDATE students SET group_id = ?, surname = ?, name_ = ?, second_name = ?, phone_number = ?, grant_ = ? WHERE student_id = ?")
			 ) {
			 preparedStatement.setInt(1, obj.getGroup_id());
			 preparedStatement.setString(2, obj.getSurname());
			 preparedStatement.setString(3, obj.getName_());
			 preparedStatement.setString(4, obj.getSecond_name());
			 preparedStatement.setString(5, obj.getPhone_number());
			 preparedStatement.setDouble(6, obj.getGrant_());
			 preparedStatement.setInt(7, obj.getStudent_id());
			 preparedStatement.executeUpdate();
	     } catch (SQLException e) {
			 e.printStackTrace();
			 }
		 return obj.getStudent_id();	 
	 }
	 
	 public void delete(int id) throws SQLException {
		 try {
		     PreparedStatement prepStatement = conn.prepareStatement("DELETE FROM marks WHERE student_id = ?"); 
			 prepStatement.setInt(1, id);
		     prepStatement.executeUpdate();
			 PreparedStatement preparedStatement =
			 conn.prepareStatement("DELETE FROM students WHERE student_id = ?");
			 preparedStatement.setInt(1, id);
			 preparedStatement.executeUpdate();
			  
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	 }
}