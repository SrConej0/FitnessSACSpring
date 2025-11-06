package com.FitnessSACSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FitnessSACSpring.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    List<Reserva> findAll();

    Reserva findReservaByReservaId(int reservaId);

    List<Reserva> findByUsuarioUsuarioId(int usuarioId);

    void deleteReservaByReservaId(int reservaId);
}
