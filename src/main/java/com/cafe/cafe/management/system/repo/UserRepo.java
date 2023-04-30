package com.cafe.cafe.management.system.repo;

import com.cafe.cafe.management.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}