package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.WorkshopOrganized;

@Repository
public interface WorkshopOrganizedRepo extends JpaRepository<WorkshopOrganized, Integer> {

}
