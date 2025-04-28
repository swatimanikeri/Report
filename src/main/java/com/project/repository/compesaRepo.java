package com.project.repository;



import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.entity.CompesaCsi;
import com.project.entity.ExpLecEntity;

public interface compesaRepo extends JpaRepository<CompesaCsi, Integer>{
	List<CompesaCsi> findByDateBetween(Date start, Date end);
}
