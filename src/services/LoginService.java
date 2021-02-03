package services;

import classes.Person;
import repositories.PersonRepository;

public class LoginService {
	private PersonRepository personRepository = null;
		
	public LoginService() {
		personRepository = new PersonRepository();
	}
	
	public LoginService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public String login(String email, String password) {
		if (email == null || "".equals(email)) {
			return "Please input a valid email!";
		}
		if (password == null || "".equals(password)) {
			return "Please input a valid password!";
		}
		
		Person person = personRepository.getPersonByEmail(email);
		if (person == null || !person.verifyPassword(password)) {
			return "The login credentials were invalid!";
		}
		
		return "You have successfully logged in!";
	}
}
