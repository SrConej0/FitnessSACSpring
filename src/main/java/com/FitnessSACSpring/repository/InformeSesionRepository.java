package com.FitnessSACSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FitnessSACSpring.entity.InformeSesion;

@Repository
public interface InformeSesionRepository extends JpaRepository<InformeSesion, Integer> {

    List<InformeSesion> findAll();

    InformeSesion findInformeSesionByInformeId(int informeId);

    List<InformeSesion> findBySesionSesionId(int sesionId);

    void deleteInformeSesionByInformeId(int informeId);
}
