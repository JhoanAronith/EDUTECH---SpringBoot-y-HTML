package com.ProyectoWeb.EduTech.Controller;

import com.ProyectoWeb.EduTech.Model.CursoDTO;
import com.ProyectoWeb.EduTech.Model.Modulo;
import com.ProyectoWeb.EduTech.Model.Usuario;
import com.ProyectoWeb.EduTech.Repository.*;
import com.ProyectoWeb.EduTech.Service.CursoService;
import com.ProyectoWeb.EduTech.Service.ModuloServicio;
import com.ProyectoWeb.EduTech.Service.RegistroCursoServicio;
import com.ProyectoWeb.EduTech.Service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class CursoController {

    @Autowired
    private CursoService cursoServicio;

    @Autowired
    private CursoRepositorio cursoRepo;

    @Autowired
    private CategoriaRepositorio catRepo;

    @Autowired
    private ModuloServicio moduloServicio;

    @Autowired
    private RegistroCursoServicio registroCursoServicio;

    @Autowired
    private UsuarioRepositorio repo;

    //Mostrar lista de Cursos
    @GetMapping("/administrador/cursos")
    public String todosCursos(Model model) {
        List<com.ProyectoWeb.EduTech.Model.Curso> cursos = cursoServicio.listarTodosConCategoria();

        model.addAttribute("cursos", cursos);

        CursoDTO cursoDTO = new CursoDTO();
        model.addAttribute(cursoDTO);
        model.addAttribute("success", false);
        return "admin/cursos";
    }

//    @GetMapping("/cursos/{cursoId}/detalles")
//    public String verDetallesCurso(@PathVariable Integer cursoId, Model model) {
//        com.ProyectoWeb.EduTech.Model.Curso curso = cursoServicio.findById(cursoId).orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
//        List<Modulo> modulos = moduloServicio.listarModulosPorCursoId(cursoId);
//        model.addAttribute("curso", curso);
//        model.addAttribute("modulos", modulos);
//        return "detallesCurso";
//    }
//    @GetMapping("cursos/{cursoId}/detalles")
//    public String verDetallesCursoUsuario(@PathVariable Integer cursoId, Authentication authentication, Model model) {
//        com.ProyectoWeb.EduTech.Model.Curso curso = cursoServicio.findById(cursoId).orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
//        List<Modulo> modulos = moduloServicio.listarModulosPorCursoId(cursoId);
//        Usuario usuario = (Usuario) authentication.getPrincipal();
//        boolean registrado = registroCursoServicio.usuarioRegistradoEnCurso(usuario.getIdUsuario(), cursoId);
//        model.addAttribute("curso", curso);
//        model.addAttribute("modulos", modulos);
//        model.addAttribute("registrado", registrado);
//        return "detallesCurso";
//    }
    
    @GetMapping("cursos/{cursoId}/detalles")
    public String verDetallesCursoUsuario(@PathVariable Integer cursoId, Authentication auth, Model model) {
        // Obtener el curso y los módulos
        com.ProyectoWeb.EduTech.Model.Curso curso = cursoServicio.findById(cursoId)
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
        List<Modulo> modulos = moduloServicio.listarModulosPorCursoId(cursoId);

        // Buscar al usuario autenticado por correo
        Usuario usuario = repo.findByEmail(auth.getName());
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario autenticado no encontrado en la base de datos");
        }

        // Verificar si el usuario está registrado en el curso
        boolean registrado = registroCursoServicio.usuarioRegistradoEnCurso(usuario.getIdUsuario(), cursoId);

        // Agregar datos al modelo
        model.addAttribute("curso", curso);
        model.addAttribute("modulos", modulos);
        model.addAttribute("registrado", registrado);

        return "detallesCurso";
    }

//    @PostMapping("/cursos/{cursoId}/registrarse")
//    public String registrarseCurso(@PathVariable Integer cursoId, Authentication authentication) {
//        Usuario usuario = (Usuario) authentication.getPrincipal();
//        registroCursoServicio.registrarUsuarioEnCurso(usuario.getIdUsuario(), cursoId);
//        return "redirect:/cursos/" + cursoId + "/detalles";
//    }
    @PostMapping("/cursos/{cursoId}/registrarse")
    public String registrarseCurso(@PathVariable Integer cursoId, Authentication authentication) {
        // Obtener el correo del usuario autenticado
        String email = authentication.getName();

        // Buscar al usuario en la base de datos
        Usuario usuario = repo.findByEmail(email);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario no encontrado en la base de datos");
        }

        // Registrar al usuario en el curso
        registroCursoServicio.registrarUsuarioEnCurso(usuario.getIdUsuario(), cursoId);
        return "redirect:/cursos/" + cursoId + "/detalles";
    }

    @GetMapping("cursos/{cursoId}/contenido")
    public String verContenidoDelCurso(@PathVariable Integer cursoId, Authentication auth, Model model) {
        // Obtener el curso y los módulos
        com.ProyectoWeb.EduTech.Model.Curso curso = cursoServicio.findById(cursoId)
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
        List<Modulo> modulos = moduloServicio.listarModulosPorCursoId(cursoId);

        // Buscar al usuario autenticado por correo
        Usuario usuario = repo.findByEmail(auth.getName());
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario autenticado no encontrado en la base de datos");
        }

        // Verificar si el usuario está registrado en el curso
        boolean registrado = registroCursoServicio.usuarioRegistradoEnCurso(usuario.getIdUsuario(), cursoId);

        // Agregar datos al modelo
        model.addAttribute("curso", curso);
        model.addAttribute("modulos", modulos);
        model.addAttribute("registrado", registrado);

        return "contenidoCurso";
    }
    
    //Eliminar un curso
    @GetMapping("/administrador/cursos/eliminar")
    public String eliminarCurso(@RequestParam int idCurso) {
        cursoServicio.eliminarCurso(idCurso);
        return "redirect:/administrador/cursos";
    }

    // Agregar nuevo curso
    @PostMapping("/administrador/nuevoCurso")
    public String registrarCurso(Model model, @Valid @ModelAttribute CursoDTO cursoDTO, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("categorias", catRepo.findAll());
            model.addAttribute("cursos", cursoRepo.findAll());
            return "admin/nuevoCurso";
        }

        try {
            cursoServicio.registrarCurso(cursoDTO);
            model.addAttribute("cursoDTO", new CursoDTO());
            model.addAttribute("categorias", catRepo.findAll());
            model.addAttribute("cursos", cursoRepo.findAll());
            model.addAttribute("successCurso", true);
        } catch (Exception ex) {
            result.addError(new FieldError("cursoDTO", "nombre", ex.getMessage()));
            model.addAttribute("categorias", catRepo.findAll());
            model.addAttribute("cursos", cursoRepo.findAll());
            return "admin/nuevoCurso";
        }

        return "redirect:/administrador/nuevoCurso";

    }

}
