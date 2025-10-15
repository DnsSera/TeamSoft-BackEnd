package com.tesis.teamsoft.persistence.repository;

import com.tesis.teamsoft.persistence.entity.ReligionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReligionRepository extends JpaRepository<ReligionEntity, Long> {

    List<ReligionEntity> findAllByOrderByIdAsc();
}
