package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Groupstudent;

public class Group_studentsDAO {
	 Connection conn;
	 public Group_studentsDAO(Connection conn) {
		 this.conn = conn;
	 } 
	 public ArrayList<Groupstudent> getAll() throws SQLException {
		
	     PreparedStatement st = conn.prepareStatement("select * from groupstudent");
	     
	     ResultSet rs = st.executeQuery();
	     ArrayList<Groupstudent> lst = new ArrayList();
	     while (rs.next()) {
	    	 Groupstudent gp = new Groupstudent();
	    	 gp.setGroup_id(rs.getInt(1));
	    	 gp.setName_group(rs.getString(2));	    	
	    	 gp.setSpecialty(rs.getString(3));
	    	 lst.add(gp);
	     }
	     rs.close();
	     st.close();
	     return lst;
	 }
	 public Groupstudent get(int id) throws SQLException {
		 try (
			 PreparedStatement ps = conn.prepareStatement
			 ("SELECT * FROM groupstudent WHERE group_id = ?")
		     ) {
			 ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
			 if (rs.next()) {
			 Groupstudent obj = new Groupstudent();
			 obj.setGroup_id(rs.getInt("group_id"));
			 obj.setName_group(rs.getString("name_group"));			
			 obj.setSpecialty(rs.getString("specialty"));
			 return obj;
			 }
			 } catch (SQLException e) {
			 e.printStackTrace();
			 }
			 return null;
	 }
	 public int check(Groupstudent obj) throws SQLException {
		 if(obj.getGroup_id() == 0)
			 return insert(obj);
		 else return update(obj);
	 }
	 public int insert(Groupstudent obj) throws SQLException {
		 int id = -1;
		 try (
		 PreparedStatement preparedStatement =
		conn.prepareStatement(
		 "INSERT INTO groupstudent (name_group, specialty) VALUES(?, ?)",
		 Statement.RETURN_GENERATED_KEYS
		 )
		 ) {
		 preparedStatement.setString(1, obj.getName_group());		 
		 preparedStatement.setString(2, obj.getSpecialty());
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
	
	 public int update(Groupstudent obj) throws SQLException {
		 try (
			 PreparedStatement preparedStatement =
			 conn.prepareStatement("UPDATE groupstudent SET name_group = ?, specialty = ? WHERE group_id = ?")
			 ) {
		
			 preparedStatement.setString(1, obj.getName_group());			
			 preparedStatement.setString(2, obj.getSpecialty());
			 preparedStatement.setInt(3, obj.getGroup_id());
			 preparedStatement.executeUpdate();
	     } catch (SQLException e) {
			 e.printStackTrace();
			 }
		 return obj.getGroup_id();	 
	 }
	 
	 public void delete(int id) throws SQLException {
		 try {
			 PreparedStatement preparedStatement =
			 conn.prepareStatement("DELETE FROM groupstudent WHERE group_id = ?");
			 preparedStatement.setInt(1, id);
			 preparedStatement.executeUpdate();
			  
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	 }
}
