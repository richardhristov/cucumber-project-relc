package repositories;

import java.util.ArrayList;
import java.util.List;

import classes.Person;

public class PersonRepository {
	private List<Person> persons;
	
	public PersonRepository() {
		persons = new ArrayList<Person>();
	}
	
	public PersonRepository(List<Person> persons) {
		this.persons = persons;
	}
	
	public Person getPersonByEmail(String email) {
		if (email == null) {
			return null;
		}
		
		for(int i = 0; i < persons.size(); i++) {
			Person p = persons.get(i);
			if (p != null && p.getEmail().equals(email)) {
				return p;
			}
		}
		
		return null;
	}
	
	public void update(Person person) {
		for(int i = 0; i < persons.size(); i++) {
			Person p = persons.get(i);
			if (p.getId() != person.getId()) {
				continue;
			}
			persons.set(i, person);
			break;
		}
	}
}
