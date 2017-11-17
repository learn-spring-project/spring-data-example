package com.spring.jpa.repository;


import com.spring.jpa.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Repository("userRepository")
public  interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);

    List<User> findByName(String name, Sort sort);

    List<User> findByName(String name, Pageable paging);

    List<User> findByUser5(@Param("name") String name);

    @Transactional(timeout = 2, propagation = Propagation.REQUIRED)
    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> findByGivenQuery(@Param("name") String name);

    List<User> findByIdAndName(@Param("id") Long id, @Param("name") String name);
}
