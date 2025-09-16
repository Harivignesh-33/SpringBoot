package com.jvlcode.spring_boot_demo.repository;

import com.jvlcode.spring_boot_demo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
