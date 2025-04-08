package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.ExpLecEntity;

@Repository
public interface ExpLecRepo extends JpaRepository<ExpLecEntity, Integer> {

}