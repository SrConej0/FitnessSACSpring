package com.FitnessSACSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FitnessSACSpring.entity.Sancion;

@Repository
public interface SancionRepository extends JpaRepository<Sancion, Integer> {

    List<Sancion> findAll();

    Sancion findSancionBySancionId(int sancionId);

    Sancion findByUsuarioUsuarioId(int usuarioId);

    void deleteSancionBySancionId(int sancionId);
}
