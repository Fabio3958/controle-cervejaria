package com.evangelista.controlecervejaria.repository;

import com.evangelista.controlecervejaria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
