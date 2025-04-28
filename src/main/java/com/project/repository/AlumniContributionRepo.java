package com.project.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.AlumniContributionEntity;
import com.project.entity.CompesaCsi;

@Repository
public interface AlumniContributionRepo extends JpaRepository<AlumniContributionEntity, Integer>{
	List<AlumniContributionEntity> findByDateBetween(Date start, Date end);
}

