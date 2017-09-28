import jpa.domain.Person;
import jpa.domain.Person2;
import jpa.domain.PersonCompositeId;
import jpa.domain.User;
import jpa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Created by Administrator on 2017/9/28.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JunitTest {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Test
    public void testAdd() {
        UserService userService = (UserService) ctx.getBean("userService");
        User user = new User();
        user.setName("李坏");
        user.setAge(111);
        userService.saveUser(user);
    }

    @Test
    public void testCompositeId1Save()
    {
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = manager.getTransaction();
        entityTransaction.begin();
        Person person = new Person();
        person.setName("李四");
        person.setAge(40);
        person.setAdress("广州市");
        manager.persist(person);
        entityTransaction.commit();
    }

    @Test
    public void testCompositeId1Find()
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        PersonCompositeId personCompositeId = new PersonCompositeId();
        personCompositeId.setName("张三");
        personCompositeId.setAge(50);
        Person person = entityManager.find(Person.class, personCompositeId);
        if (person != null) {
            System.out.println("name:" + person.getName() + " age:" + person.getAge());
        }
        entityTransaction.commit();
    }

    @Test
    public  void testCompositeId2Save(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Person2 person = new Person2();
        PersonCompositeId personCompositeId = new PersonCompositeId();
        personCompositeId.setName("搜噶");
        personCompositeId.setAge(100);
        person.setPersonCompositeId(personCompositeId);

        person.setAdress("广州市");
        entityManager.persist(person);

        entityTransaction.commit();
    }
}
