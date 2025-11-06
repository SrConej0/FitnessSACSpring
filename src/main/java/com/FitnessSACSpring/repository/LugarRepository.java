package com.FitnessSACSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FitnessSACSpring.entity.Lugar;

@Repository
public interface LugarRepository extends JpaRepository<Lugar, Integer> {

    List<Lugar> findByNombreContainingIgnoreCaseOrDireccionContainingIgnoreCase(String nombre, String direccion);

    Lugar findLugarByLugarId(int lugarId);

    Lugar findByNombre(String nombre);

    void deleteLugarByLugarId(int lugarId);
}
