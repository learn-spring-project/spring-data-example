package jpa.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/28.
 */
@Embeddable
public class PersonCompositeId2 implements Serializable {
    private String name;
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