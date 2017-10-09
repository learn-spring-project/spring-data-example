package jpa.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/9/28.
 */
@Entity
@Table(name = "person2")
public class Person2 {
    @EmbeddedId
    private PersonCompositeId2 personCompositeId2;


    private String adress;


    public PersonCompositeId2 getPersonCompositeId2() {
        return personCompositeId2;
    }

    public void setPersonCompositeId2(PersonCompositeId2 personCompositeId2) {
        this.personCompositeId2 = personCompositeId2;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "personCompositeId2=" + personCompositeId2 +
                ", adress='" + adress + '\'' +
                '}';
    }
}