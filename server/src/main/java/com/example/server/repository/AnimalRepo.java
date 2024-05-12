package com.example.server.repository;

import com.example.server.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author duchieu212
 */
@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {
}
