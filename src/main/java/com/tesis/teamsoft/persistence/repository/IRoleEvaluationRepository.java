package com.tesis.teamsoft.persistence.repository;

import com.tesis.teamsoft.persistence.entity.RoleEvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRoleEvaluationRepository extends JpaRepository<RoleEvaluationEntity, Long> {

    List<RoleEvaluationEntity> findAllByOrderByIdAsc();
}