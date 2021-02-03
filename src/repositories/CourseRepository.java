package repositories;

import java.util.ArrayList;
import java.util.List;

import classes.Course;

public class CourseRepository {
	private List<Course> courses;
	
	public CourseRepository() {
		courses = new ArrayList<Course>();
	}
	
	public CourseRepository(List<Course> courses) {
		this.courses = courses;
	}
	
	public void update(Course course) {
		for(int i = 0; i < courses.size(); i++) {
			Course c = courses.get(i);
			if (c.getId() != course.getId()) {
				continue;
			}
			courses.set(i, course);
			break;
		}
	}
	
	public Course add(Course course) {
		course.setId(courses.size());
		courses.add(course);
		return course;
	}
}
