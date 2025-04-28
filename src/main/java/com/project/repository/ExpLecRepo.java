package com.project.repository;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.ExpLecEntity;

@Repository
public interface ExpLecRepo extends JpaRepository<ExpLecEntity, Integer> {
//void findByda() between(from 2023-2024);
	List<ExpLecEntity> findByDateBetween(Date start,Date end);
}