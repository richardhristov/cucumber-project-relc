
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import classes.Teacher;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.CourseCreationScreenModel;
import repositories.TeacherRepository;
import services.CourseService;

public class CourseCreationTest {
	CourseCreationScreenModel courseCreationScreenModel;
	CourseService courseService;
	TeacherRepository teacherRepository;
	
	public CourseCreationTest() {
		Teacher t1 = new Teacher();
		t1.setEmail("john.brek@uni-plovdiv.org");
		t1.setPassword("continue");
		t1.setHonoraryPrefix("The honorable");
		t1.setName("John Brek");
		
		List<Teacher> teachers = new ArrayList<>();
		teachers.add(t1);
		teacherRepository = new TeacherRepository(teachers);
		courseService = new CourseService(teacherRepository);
		
		courseCreationScreenModel = new CourseCreationScreenModel(courseService);
	}
	

	@Given("^The course creation screen is opened$")
	public void openLoginScreen() throws Throwable {
		courseCreationScreenModel.navigateToMe();
	}

	@When("^The following teacher e-mail is entered: \"([^\"]*)\"$")
	public void addEmail(String email) throws Throwable {
		courseCreationScreenModel.setTeacherEmail(email);
	}

	@When("^The following course name is entered: \"([^\"]*)\"$")
	public void addName(String name) throws Throwable {
		courseCreationScreenModel.setName(name);
	}

	@When("^The create course button is clicked$")
	public void clickCreateButton() throws Throwable {
		courseCreationScreenModel.clickCreateButton();
	}

	@Then("^A message is seen: \"([^\"]*)\"$")
	public void checkMessage(String expectedMessage) throws Throwable {
		String resultMessage = courseCreationScreenModel.getMessage();
		assertEquals(expectedMessage, resultMessage);
	}
}
