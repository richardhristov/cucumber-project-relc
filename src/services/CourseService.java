package services;

import classes.Course;
import classes.Teacher;
import repositories.CourseRepository;
import repositories.TeacherRepository;

public class CourseService {
	private TeacherRepository teacherRepository = null;
	private CourseRepository courseRepository = null;
		
	public CourseService() {
		teacherRepository = new TeacherRepository();
		courseRepository = new CourseRepository();
	}
	
	public CourseService(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
		courseRepository = new CourseRepository();
	}
	
	public String createCourse(String name, String teacherEmail) {
		if (name == null || "".equals(name)) {
			return "Please input a valid course name!";
		}
		if (teacherEmail == null || "".equals(teacherEmail)) {
			return "Please input a valid teacher e-mail!";
		}
		
		Teacher teacher = teacherRepository.getTeacherByEmail(teacherEmail);
		if (teacher == null) {
			return "The teacher could not be found!";
		}
		
		Course course = new Course();
		course.setName(name);
		course.addTeacher(teacher);
		
		course = courseRepository.add(course);
		teacher.addCourse(course);
		teacherRepository.update(teacher);
		
		return "You have successfully created the course!";
	}
}
