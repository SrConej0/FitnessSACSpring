package com.FitnessSACSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FitnessSACSpring.entity.Sesion;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Integer> {

    List<Sesion> findAll();

    Sesion findSesionBySesionId(int sesionId);

    List<Sesion> findByTrainerTrainerId(int trainerId);

    void deleteSesionBySesionId(int sesionId);
}
