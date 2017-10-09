package jpa.repository;

import jpa.domain.Person2;
import jpa.domain.PersonCompositeId2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/10/1.
 */

@Repository("personCompositRepository")
public interface PersonCompositRepository extends JpaRepository<Person2, PersonCompositeId2> {
}
