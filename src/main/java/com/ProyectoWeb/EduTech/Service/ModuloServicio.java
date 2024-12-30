package com.ProyectoWeb.EduTech.Service;

import com.ProyectoWeb.EduTech.Model.Modulo;
import com.ProyectoWeb.EduTech.Model.ModuloDTO;
import com.ProyectoWeb.EduTech.Model.Curso;
import com.ProyectoWeb.EduTech.Repository.ModuloRepositorio;
import com.ProyectoWeb.EduTech.Repository.CursoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuloServicio {

    @Autowired
    private ModuloRepositorio moduloRepositorio;

    @Autowired
    private CursoRepositorio cursoRepositorio;

    public Modulo registrarModulo(ModuloDTO moduloDTO) {
        Curso curso = cursoRepositorio.findById(moduloDTO.getCursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        Modulo modulo = new Modulo();
        modulo.setNombre(moduloDTO.getNombre());
        modulo.setDescripcion(moduloDTO.getDescripcion());
        modulo.setOrden(moduloDTO.getOrden());
        modulo.setEnlaceVideo(moduloDTO.getEnlaceVideo());
        modulo.setEnlacePDF(moduloDTO.getEnlacePDF());
        modulo.setCurso(curso);

        return moduloRepositorio.save(modulo);
    }

    // Método para listar módulos por curso 
    public List<Modulo> listarModulosPorCursoId(Integer cursoId) {
        return moduloRepositorio.findByCursoId(cursoId);
    }

}
