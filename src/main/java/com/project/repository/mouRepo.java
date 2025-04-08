package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.entity.Mou;

public interface mouRepo extends JpaRepository<Mou, Integer> {
}
