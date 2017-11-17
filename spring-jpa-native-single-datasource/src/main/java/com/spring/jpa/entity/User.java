package com.spring.jpa.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Administrator on 2017/11/17.
 */
@Table(name = "jpa_user")
@Entity
@NamedQueries( {
        @NamedQuery( name="User.findByUser5", query = "SELECT u FROM User u where u.name = :name" ),
        @NamedQuery( name="User.classicQuery", query = "SELECT u FROM User u where u.name = :name" )
})
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

/*    public User() {
    }*/

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
