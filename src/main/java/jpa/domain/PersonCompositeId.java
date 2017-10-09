package jpa.domain;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/28.
 */
public class PersonCompositeId implements Serializable {
    @Column(name = "namet")
    private String name;

    @Column(name = "aget")
    private long age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getAge() {
        return age;
    }
    public void setAge(long age) {
        this.age = age;
    }
}
