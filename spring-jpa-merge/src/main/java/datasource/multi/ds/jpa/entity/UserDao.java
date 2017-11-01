package datasource.multi.ds.jpa.entity;

import jpa.spring.entities.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class UserDao {

	//如何获取到和当前事务关联的 EntityManager 对象呢 ?
	//通过 @PersistenceContext 注解来标记成员变量!
	//@PersistenceContext(unitName = "aaaUnit")
	@PersistenceContext(unitName = "MyTestPU")
/*	@Qualifier(value = "entityManagerFactory2")*/
	private EntityManager entityManager;

/*	@PersistenceUnit(unitName = "bbbUnit")
	private EntityManagerFactory entityManagerFactory2;*/

	public void save(User user){
		entityManager.persist(user);
	}
	
}
