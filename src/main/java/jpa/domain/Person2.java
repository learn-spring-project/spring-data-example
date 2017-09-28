package jpa.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/9/28.
 */
@Entity
@Table
public class Person2 {
    private PersonCompositeId personCompositeId;

    @EmbeddedId
    public PersonCompositeId getPersonCompositeId() {
        return personCompositeId;
    }
    public void setPersonCompositeId(PersonCompositeId personCompositeId) {
        this.personCompositeId = personCompositeId;
    }
    private String adress;


    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
}