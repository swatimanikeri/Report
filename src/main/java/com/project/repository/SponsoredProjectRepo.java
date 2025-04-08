package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.SponsoredProjectEntity;

public interface SponsoredProjectRepo extends JpaRepository<SponsoredProjectEntity, Integer> {

}
