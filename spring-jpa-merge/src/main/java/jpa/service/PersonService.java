package jpa.service;

import jpa.dao.PersonDao;
import jpa.spring.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	@Transactional(transactionManager = "transactionManager2")
	public void savePersons(Person p1, Person p2){
		personDao.save(p1);
		
		//int i = 10 / 0;
		
		personDao.save(p2);
	}
	
}
