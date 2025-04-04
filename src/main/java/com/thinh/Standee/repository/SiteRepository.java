package com.thinh.Standee.repository;

import com.thinh.Standee.entity.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<SiteEntity, String> {
}
