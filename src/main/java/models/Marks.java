package models;
import java.sql.Timestamp;


public class Marks {
	int mark;
	int student_id;
	int subject_id;
	int lecture_id;
	Timestamp modification_time;
	int mark_id;
	public int getMark_id() {
		return mark_id;
	}
	public void setMark_id(int mark_id) {
		this.mark_id = mark_id;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public int getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(int lecture_id) {
		this.lecture_id = lecture_id;
	}
	
	public Timestamp getModification_time() {
		return modification_time;
	}
	public void setModification_time(Timestamp modification_time) {
		this.modification_time = modification_time;
	}
}
