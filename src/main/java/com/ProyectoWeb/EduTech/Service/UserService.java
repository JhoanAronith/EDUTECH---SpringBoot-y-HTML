package com.ProyectoWeb.EduTech.Service;

import com.ProyectoWeb.EduTech.Model.Usuario;
import com.ProyectoWeb.EduTech.Repository.UsuarioRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio repo;

    //Buscar Usuarios por Correo
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = repo.findByEmail(email);
        if (usuario != null) {
            var springUser = User.withUsername(usuario.getEmail())
                    .password(usuario.getPassword())
                    .roles(usuario.getRol().toUpperCase())
                    .build();
            return springUser;
        }
        return null;
    }

    //Listar por rol
    public List<Usuario> listarPorRol(String rol) {
        return repo.findByRol(rol);
    }

    // Listar todos los usuarios
    public List<Usuario> listarTodos() {
        return repo.findAll();
    }

    // Buscar un usuario por ID
    public Optional<Usuario> buscarPorId(int idUsuario) {
        return repo.findById(idUsuario);
    }

    // Crear o actualizar un usuario
    public Usuario guardarUsuario(Usuario usuario) {
        return repo.save(usuario);
    }

    // Eliminar un usuario por ID
    public void eliminarUsuario(int idUsuario) {
        repo.deleteById(idUsuario);
    }

}
