package com.jvlcode.spring_boot_demo.repository;

import com.jvlcode.spring_boot_demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserEntity , Long >{

}
