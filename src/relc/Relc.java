package relc;

import java.util.ArrayList;
import java.util.List;

import classes.Person;
import models.LoginScreenModel;
import repositories.PersonRepository;
import services.LoginService;

public class Relc {

	public static void main(String[] args) {
		System.out.println("test");
		
		Person p1 = new Person();
		p1.setEmail("stu1801321063@uni-plovdiv.org");
		p1.setPassword("nikipass");
		
		List<Person> persons = new ArrayList<>();
		persons.add(p1);
		PersonRepository personRepository = new PersonRepository(persons);
		LoginService loginService = new LoginService(personRepository);
		
		LoginScreenModel loginScreenModel = new LoginScreenModel(loginService);
		
		loginScreenModel.setEmail("stu1801321063@uni-plovdiv.org");
		loginScreenModel.setPassword("nikipass");
		loginScreenModel.clickLoginButton();
		System.out.println(loginScreenModel.getLoginMessage());
	}

}
