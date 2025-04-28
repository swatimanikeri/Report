package com.project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.FacultyPaparEntity;
import com.project.entity.SponsoredProjectEntity;

public interface SponsoredProjectRepo extends JpaRepository<SponsoredProjectEntity, Integer> {

	List<SponsoredProjectEntity> findByDateBetween(Date start,Date end);
}
