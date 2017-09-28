package jpa.repository;

import jpa.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Repository
public class ClassicUserRepository {
    @PersistenceContext(unitName = "myJPA")
    EntityManager em;

    public List<User> findByName(String name) {
        return getEntityManger()
                .createNamedQuery("User.classicQuery", User.class)
                .setParameter("name", name)
                .getResultList();
    }

    public User findByQueryName(String name){
        //使用getSingleResult()方法时如果没有结果会抛出异常，保险的做法是：仍然使用getResultList()方法，无论你是获取一个还是多个结果，获取一个结果的时候做一下处理:
        List<User> users = getEntityManger().createQuery("SELECT u FROM User u where u.name = :name").setParameter("name", name).getResultList();
        if(users.size() > 0)
            return users.get(0);
        else
            return null;
    }

    /**
     * TODO
     * @return
     */
  /*  public Long getSequenct()
    {
        BigDecimal bigDecimal = BigDecimal.valueOf(getEntityManger().createNativeQuery("select sequence.nexValue from dual").getFirstResult());
        return  bigDecimal.longValue();
    }*/


    private EntityManager getEntityManger() {
        return em;
    }
}
