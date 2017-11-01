package datasource.multi.ds.jpa.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/11/1.
 */

@Table(name="JPA_UserS_CONFIG")
@Entity
public class User {

    private Integer id;
    private String lastName;

    private String email;
    private int age;

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
