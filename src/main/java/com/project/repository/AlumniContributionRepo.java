package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.AlumniContributionEntity;

@Repository
public interface AlumniContributionRepo extends JpaRepository<AlumniContributionEntity, String>{

}

