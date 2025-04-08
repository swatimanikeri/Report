package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.entity.ValueaddEntity;

@Repository

	public interface ValueaddRepo extends JpaRepository<ValueaddEntity,String>{

	}


