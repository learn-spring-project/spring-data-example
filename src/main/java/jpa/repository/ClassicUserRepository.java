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
