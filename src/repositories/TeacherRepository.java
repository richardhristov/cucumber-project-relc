package repositories;

import java.util.ArrayList;
import java.util.List;

import classes.Person;
import classes.Teacher;

public class TeacherRepository {
	private List<Teacher> teachers;
	
	public TeacherRepository() {
		teachers = new ArrayList<Teacher>();
	}
	
	public TeacherRepository(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	public Teacher getTeacherByEmail(String email) {
		if (email == null) {
			return null;
		}
		
		for(int i = 0; i < teachers.size(); i++) {
			Teacher t = teachers.get(i);
			if (t != null && t.getEmail().equals(email)) {
				return t;
			}
		}
		
		return null;
	}
	
	public void update(Teacher teacher) {
		for(int i = 0; i < teachers.size(); i++) {
			Person p = teachers.get(i);
			if (p.getId() != teacher.getId()) {
				continue;
			}
			teachers.set(i, teacher);
			break;
		}
	}
}
