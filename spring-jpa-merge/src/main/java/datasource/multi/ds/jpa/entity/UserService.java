package datasource.multi.ds.jpa.entity;

import jpa.dao.PersonDao;
import jpa.spring.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional(transactionManager = "transactionManagerPrimary")
	public void saveUsers(User p1, User p2){
		userDao.save(p1);
		
		//int i = 10 / 0;

		userDao.save(p2);
	}
	
}
