
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import classes.Person;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.LoginScreenModel;
import repositories.PersonRepository;
import services.LoginService;

public class LoginTest {
	LoginScreenModel loginScreenModel;
	LoginService loginService;
	PersonRepository personRepository;
	
	public LoginTest() {
		Person p1 = new Person();
		p1.setEmail("stu1801321063@uni-plovdiv.org");
		p1.setPassword("nikipass");
		
		List<Person> persons = new ArrayList<>();
		persons.add(p1);
		personRepository = new PersonRepository(persons);
		loginService = new LoginService(personRepository);
		
		loginScreenModel = new LoginScreenModel(loginService);
	}
	

	@Given("^The system login screen is opened$")
	public void openLoginScreen() throws Throwable {
		loginScreenModel.navigateToMe();
	}

	@When("^The following e-mail is entered: \"([^\"]*)\"$")
	public void addEmail(String email) throws Throwable {
		loginScreenModel.setEmail(email);
	}

	@When("^The following password is entered: \"([^\"]*)\"$")
	public void addPassword(String password) throws Throwable {
		loginScreenModel.setPassword(password);
	}

	@When("^The login button is clicked$")
	public void clickLoginButton() throws Throwable {
		loginScreenModel.clickLoginButton();
	}

	@Then("^A login result message is seen: \"([^\"]*)\"$")
	public void checkLoginMessage(String expectedMessage) throws Throwable {
		String resultMessage = loginScreenModel.getLoginMessage();
		assertEquals(expectedMessage, resultMessage);
	}
}
