package com.FitnessSACSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FitnessSACSpring.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    
    List<Rol> findAll();

   
    Rol findRolByRolId(int rolId);

    
    Rol findByNombre(String nombre);

    
    void deleteRolByRolId(int rolId);
}
