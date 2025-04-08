package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.TechnicalEventEntity;

@Repository
public interface TechnicalEventRepo extends JpaRepository<TechnicalEventEntity, Integer> {

}
