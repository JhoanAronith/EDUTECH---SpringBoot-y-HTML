package com.ProyectoWeb.EduTech.Repository;

import com.ProyectoWeb.EduTech.Model.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    public Usuario findByEmail(String email);

    List<Usuario> findByRol(String rol);

}
