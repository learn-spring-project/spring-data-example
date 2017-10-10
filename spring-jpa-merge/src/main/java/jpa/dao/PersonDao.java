package jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import jpa.spring.entities.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class PersonDao {

	//如何获取到和当前事务关联的 EntityManager 对象呢 ?
	//通过 @PersistenceContext 注解来标记成员变量!
	//@PersistenceContext(unitName = "aaaUnit")
	@PersistenceContext(unitName = "bbbUnit")
/*	@Qualifier(value = "entityManagerFactory2")*/
	private EntityManager entityManager;

/*	@PersistenceUnit(unitName = "bbbUnit")
	private EntityManagerFactory entityManagerFactory2;*/

	public void save(Person person){
		entityManager.persist(person);
	}
	
}
