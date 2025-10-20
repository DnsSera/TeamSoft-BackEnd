package com.tesis.teamsoft.persistence.repository;

import com.tesis.teamsoft.persistence.entity.RoleLoadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRoleLoadRepository extends JpaRepository<RoleLoadEntity, Long> {

    List<RoleLoadEntity> findAllByOrderByIdAsc();
}