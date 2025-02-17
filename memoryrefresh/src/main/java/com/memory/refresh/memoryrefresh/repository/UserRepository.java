package com.memory.refresh.memoryrefresh.repository;

import com.memory.refresh.memoryrefresh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //add custom queries if required
    boolean existsByEmail(String email);
}
