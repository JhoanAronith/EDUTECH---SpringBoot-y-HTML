package com.ProyectoWeb.EduTech.Service;

import com.ProyectoWeb.EduTech.Model.Curso;
import com.ProyectoWeb.EduTech.Model.RegistroCurso;
import com.ProyectoWeb.EduTech.Model.Usuario;
import com.ProyectoWeb.EduTech.Repository.CursoRepositorio;
import com.ProyectoWeb.EduTech.Repository.RegistroCursoRepositorio;
import com.ProyectoWeb.EduTech.Repository.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroCursoServicio {

    @Autowired
    private RegistroCursoRepositorio registroCursoRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private CursoRepositorio cursoRepositorio;

    public RegistroCurso registrarUsuarioEnCurso(Integer usuarioId, Integer cursoId) {
        Usuario usuario = usuarioRepositorio.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        Curso curso = cursoRepositorio.findById(cursoId)
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        RegistroCurso registro = new RegistroCurso();
        registro.setUsuario(usuario);
        registro.setCurso(curso);

        return registroCursoRepositorio.save(registro);
    }

    public boolean usuarioRegistradoEnCurso(Integer usuarioId, Integer cursoId) {
        return registroCursoRepositorio.existsByUsuarioIdAndCursoId(usuarioId, cursoId);
    }

    public List<RegistroCurso> listarTodos() {
        return registroCursoRepositorio.findAll();
    }

}
