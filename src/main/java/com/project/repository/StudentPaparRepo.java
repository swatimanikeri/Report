package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.project.entity.PaperbyStudents;

@Repository
public interface StudentPaparRepo  extends JpaRepository<PaperbyStudents, Integer> {

}
