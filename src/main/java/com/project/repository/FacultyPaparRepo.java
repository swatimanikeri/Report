package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.FacultyPaparEntity;

@Repository

public interface FacultyPaparRepo extends JpaRepository<FacultyPaparEntity, Integer> {

}
