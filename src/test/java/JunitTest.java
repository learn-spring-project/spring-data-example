import jpa.domain.*;
import jpa.repository.PersonCompositRepository;
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


/*
*1）加入Junit4的注解 @RunWith，在这里可以指定Spring的的运行器来集成。
*2）加入@ContextConfiguration注解，指定要加载的配置文件的位置。
* */
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
        personCompositeId.setName("李四");
        personCompositeId.setAge(40);
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
        PersonCompositeId2 personCompositeId = new PersonCompositeId2();
        personCompositeId.setName("搜噶");
        personCompositeId.setAge(100);
        //注意：主键要先设置，否则包id为null错误
        person.setPersonCompositeId2(personCompositeId);

        person.setAdress("广州市");
        entityManager.persist(person);

        entityTransaction.commit();
    }

    @Test
    public void testCompositeIdFind(){
        PersonCompositRepository personCompositRepository = (PersonCompositRepository)ctx.getBean("personCompositRepository");
        System.out.println(personCompositRepository.findAll());

    }
}
