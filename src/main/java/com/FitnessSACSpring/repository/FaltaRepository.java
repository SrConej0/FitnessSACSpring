package com.FitnessSACSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FitnessSACSpring.entity.Falta;

@Repository
public interface FaltaRepository extends JpaRepository<Falta, Integer> {

    List<Falta> findAll();

    Falta findFaltaByFaltaId(int faltaId);

    Falta findByUsuarioUsuarioId(int usuarioId);

    void deleteFaltaByFaltaId(int faltaId);
}
