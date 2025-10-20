package com.FitnessSACSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FitnessSACSpring.entity.Membresia;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {

    List<Membresia> findAll();

    Membresia findMembresiaByMembresiaId(int membresiaId);

    List<Membresia> findByUsuarioUsuarioId(int usuarioId);

    void deleteMembresiaByMembresiaId(int membresiaId);
}
