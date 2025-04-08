package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.CommunityServiceEntity;

@Repository

public interface CommunityServicesRepo extends JpaRepository<CommunityServiceEntity, Integer> {

}
