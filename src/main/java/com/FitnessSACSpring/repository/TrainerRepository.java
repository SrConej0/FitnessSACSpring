package com.FitnessSACSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FitnessSACSpring.entity.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

    List<Trainer> findAll();

    Trainer findTrainerByTrainerId(int trainerId);

    Trainer findByEspecialidad(String especialidad);

    List<Trainer> findByUsuarioUsuarioId(int usuarioId);

    void deleteTrainerByTrainerId(int trainerId);
}
