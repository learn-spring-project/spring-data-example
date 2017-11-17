package com.spring.jpa.repository;


import com.spring.jpa.entity.User;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/17.
 */

@Repository("userDao")
public class UserDao {
    @PersistenceContext(unitName = "myJPA")
    private EntityManager em;

    /**
     * 保存
     *
     * @param t
     * @return
     */
    public User save(User t) {
        this.em.persist(t);
        return t;
    }

    /**
     * 更新
     *
     * @param t
     * @return
     */
    public User update(User t) {
        return this.em.merge(t);
    }


    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(Long id) {
        User t = this.em.find(User.class, id);
        this.em.remove(t);
    }


    /**
     * 查找
     *
     * @param id
     * @return
     */
    public User findOne(Long id) {
        return this.em.find(User.class, id);

    }

    /**
     * 查询列表
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        Query query = this.em.createQuery("select t from User t ", User.class);
        return query.getResultList();
    }


    /**
     * 通过原生sql查询某些字段
     *
     * @return
     */
    public List<Object[]> findTuple() {

        Query query = this.em.createNativeQuery("select t.id ,t.task_name from tb_task t ");

        return query.getResultList();
    }

    /**
     * 查询字段映射成map
     *
     * @return
     */
    public List<Map<String, Object>> findMap() {

        Query query = this.em.createQuery("select t.id as id ,t.taskName as taskName ,t.createTime as createTime from User t ");
        query.unwrap(org.hibernate.Query.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();

    }

    public User findOneByQueryName(String name) {
        //使用getSingleResult()方法时如果没有结果会抛出异常，保险的做法是：仍然使用getResultList()方法，无论你是获取一个还是多个结果，获取一个结果的时候做一下处理:
        List<User> users = em.createQuery("SELECT u FROM User u where u.name = :name").setParameter("name", name).getResultList();
        if (users.size() > 0)
            return users.get(0);
        else
            return null;
    }

    public List<User> findByName(String name) {
        return em.createNamedQuery("User.classicQuery", User.class)
                .setParameter("name", name)
                .getResultList();
    }

}
