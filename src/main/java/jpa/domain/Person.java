package jpa.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/9/28.
 */
@Entity
@Table(name = "person1")
@IdClass(PersonCompositeId.class)
public class Person {
    @Column(name = "name1")
    private String name;

    @Column(name = "age1")
    private long age;

    @Column(name = "address1")
    private String address;

    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getAdress() {
        return address;
    }
    public void setAdress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", adress='" + address + '\'' +
                '}';
    }
}