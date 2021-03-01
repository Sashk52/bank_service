package com.example.bank.service.demo.repository;

import com.example.bank.service.demo.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "from User u join fetch u.roles where u.id =?1")
    Optional<User> findById(Long id);

    @Query(value = "from User u join fetch u.roles where u.phoneNumber =?1")
    Optional<User> findByPhoneNumber(String phoneNumber);
}
