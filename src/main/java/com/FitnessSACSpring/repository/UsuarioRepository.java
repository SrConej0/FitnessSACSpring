package com.FitnessSACSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FitnessSACSpring.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    
    List<Usuario> findAll();
    
    
    Usuario findByEmailAndPasswordHash(String email, String passwordHash);

    
    Usuario findUsuarioByUsuarioId(int usuarioId);

    
    Usuario findByNombre(String nombre);

    
    List<Usuario> findByNombreContainingIgnoreCaseOrEmailContainingIgnoreCase(String nombre, String email);

    
    void deleteUsuarioByUsuarioId(int usuarioId);
}
