package com.tesis.teamsoft.persistence.repository;

import com.tesis.teamsoft.persistence.entity.CompetenceImportanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompetenceImportanceRepository extends JpaRepository<CompetenceImportanceEntity, Long> {

    List<CompetenceImportanceEntity> findAllByOrderByIdAsc();

}