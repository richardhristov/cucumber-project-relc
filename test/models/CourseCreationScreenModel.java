package models;

import services.CourseService;

public class CourseCreationScreenModel {
	private CourseService courseService;
	
	public CourseCreationScreenModel() {
		
	}
	
	public CourseCreationScreenModel(CourseService courseCreationService) {
		this.courseService = courseCreationService;
	}

	private String teacherEmail;
	private String name;
	private String message;

	public void navigateToMe() {
		System.out.println("The course creation page has been navigated to!");
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public void setName(String name) {
		this.name = name;		
	}

	public void clickCreateButton() {
		message = courseService.createCourse(name, teacherEmail);
	}

	public String getMessage() {
		return message;
	}

}
