package com.thinh.Standee.repository;

import com.thinh.Standee.entity.RoleEntity;
import com.thinh.Standee.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, String> {
    Optional<RoleEntity> findByName(RoleName name);
}
