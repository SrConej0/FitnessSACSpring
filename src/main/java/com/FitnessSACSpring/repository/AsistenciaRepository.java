package com.FitnessSACSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FitnessSACSpring.entity.Asistencia;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {

    List<Asistencia> findAll();

    Asistencia findAsistenciaByAsistenciaId(int asistenciaId);

    List<Asistencia> findByReservaReservaId(int reservaId);

    void deleteAsistenciaByAsistenciaId(int asistenciaId);
}
