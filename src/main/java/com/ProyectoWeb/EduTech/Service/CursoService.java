package com.ProyectoWeb.EduTech.Service;

import com.ProyectoWeb.EduTech.Model.Curso;
import com.ProyectoWeb.EduTech.Model.CursoDTO;
import com.ProyectoWeb.EduTech.Model.Categoria;
import com.ProyectoWeb.EduTech.Model.Usuario;
import com.ProyectoWeb.EduTech.Repository.CursoRepositorio;
import com.ProyectoWeb.EduTech.Repository.CategoriaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepositorio cursoRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public Curso registrarCurso(CursoDTO cursoDTO) {
        Categoria categoria = categoriaRepositorio.findById(cursoDTO.getCategoria())
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));

        Curso curso = new Curso();
        curso.setNombre(cursoDTO.getNombre());
        curso.setDescripcion(cursoDTO.getDescripcion());
        curso.setDuracion(cursoDTO.getDuracion());
        curso.setCategoria(categoria);

        return cursoRepositorio.save(curso);
    }

    public List<Curso> listarTodosConCategoria() {
        return cursoRepositorio.findAllWithCategoria();
    }
    
    // Eliminar un usuario por ID
    public void eliminarCurso(int idCurso) {
        cursoRepositorio.deleteById(idCurso);
    }
    
    // Buscar un usuario por ID
    public Optional<Curso> findById(int idCurso) {
        return cursoRepositorio.findById(idCurso);
    }
}
