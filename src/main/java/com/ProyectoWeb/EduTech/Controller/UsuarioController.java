package com.ProyectoWeb.EduTech.Controller;

import com.ProyectoWeb.EduTech.Model.RegistroDTO;
import com.ProyectoWeb.EduTech.Model.Usuario;
import com.ProyectoWeb.EduTech.Repository.UsuarioRepositorio;
import com.ProyectoWeb.EduTech.Service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio repo;

    @Autowired
    private UserService usuarioService;
    
    //Mostrar Registrar Usuario
    @GetMapping("/registro")
    public String registro(Model model) {
        RegistroDTO registroDTO = new RegistroDTO();
        model.addAttribute(registroDTO);
        model.addAttribute("success", false);
        return "registro";
    }

    //Registrar Usuario
    @PostMapping("/registro")
    public String registro(Model model, @Valid @ModelAttribute RegistroDTO registroDTO, BindingResult result) {
        if (!registroDTO.getPassword().equals(registroDTO.getConfirmPassword())) {
            result.addError(new FieldError("registroDTO", "confirmPassword",
                    "Las contraseñas no son iguales"));
        }

        Usuario usuario = repo.findByEmail(registroDTO.getEmail());

        if (usuario != null) {
            result.addError(new FieldError("registroDTO", "email", "El correo ya está en uso"));
        }

        if (result.hasErrors()) {
            return "registro";
        }

        try {
            var bCryptEncoder = new BCryptPasswordEncoder();
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(registroDTO.getNombre());
            nuevoUsuario.setApellido(registroDTO.getApellido());
            nuevoUsuario.setDni(registroDTO.getDni());
            nuevoUsuario.setEmail(registroDTO.getEmail());
            nuevoUsuario.setRol(registroDTO.getRol());
            nuevoUsuario.setPassword(bCryptEncoder.encode(registroDTO.getPassword()));
            repo.save(nuevoUsuario);
            model.addAttribute("registroDTO", new RegistroDTO());
            model.addAttribute("success", true);
        } catch (Exception ex) {
            result.addError(new FieldError("registroDTO", "nombre",
                    ex.getMessage()));
        }
        return "registro";
    }

    //Mostrar Perfil de Usuario
    @GetMapping("/profile")
    public String profile(Authentication auth, Model model) {
        Usuario usuario = repo.findByEmail(auth.getName());
        model.addAttribute("usuario", usuario);
        return "profile";
    }

    //Registrar Admin
    @PostMapping("/administrador/administradores")
    public String registroAdmin(Model model, @Valid @ModelAttribute RegistroDTO registroDTO, BindingResult result) {
        if (!registroDTO.getPassword().equals(registroDTO.getConfirmPassword())) {
            result.addError(new FieldError("registroDTO", "confirmPassword",
                    "Las contraseñas no son iguales"));
        }

        Usuario usuario = repo.findByEmail(registroDTO.getEmail());

        if (usuario != null) {
            result.addError(new FieldError("registroDTO", "email", "El correo ya está en uso"));
        }

        if (result.hasErrors()) {
            return "registro";
        }

        try {
            var bCryptEncoder = new BCryptPasswordEncoder();
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(registroDTO.getNombre());
            nuevoUsuario.setApellido(registroDTO.getApellido());
            nuevoUsuario.setDni(registroDTO.getDni());
            nuevoUsuario.setEmail(registroDTO.getEmail());
            nuevoUsuario.setRol(registroDTO.getRol());
            nuevoUsuario.setPassword(bCryptEncoder.encode(registroDTO.getPassword()));
            repo.save(nuevoUsuario);
            model.addAttribute("registroDTO", new RegistroDTO());
            model.addAttribute("success", true);
        } catch (Exception ex) {
            result.addError(new FieldError("registroDTO", "nombre",
                    ex.getMessage()));
        }

        return "redirect:/administrador/administradores";
    }

    //Mostrar Administrador
    @GetMapping("/administrador")
    public String administrador() {
        return "/admin/administrador";
    }

    //Lista Estudiantes
    @GetMapping("/administrador/usuarios")
    public String ListarUsuariosEstudiantes(Model modelo) {

        List<Usuario> estudiantes = usuarioService.listarPorRol("ESTUDIANTE");

        // Añadir las listas al modelo
        modelo.addAttribute("estudiantes", estudiantes);

        return "admin/usuarios";
    }

    //Lista Administradores
    @GetMapping("/administrador/administradores")
    public String ListarUsuariosAdministradores(Model modelo) {

        List<Usuario> admins = usuarioService.listarPorRol("ADMIN");

        // Añadir las listas al modelo
        modelo.addAttribute("admins", admins);

        RegistroDTO registroDTO = new RegistroDTO();
        modelo.addAttribute(registroDTO);
        modelo.addAttribute("success", false);

        return "admin/administradores";
    }

    // Mostrar formulario para crear o editar un usuario
    @GetMapping("/form")
    public String mostrarFormulario(@RequestParam(required = false) Integer idUsuario, Model modelo) {
        Usuario usuario = idUsuario != null
                ? usuarioService.buscarPorId(idUsuario).orElse(new Usuario())
                : new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "admin/form-usuario";
    }

    // Eliminar usuarios
    @GetMapping("/administrador/usuarios/eliminar")
    public String eliminarUsuario(@RequestParam int idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
        return "redirect:/administrador/usuarios";
    }

    // Eliminar usuarios
    @GetMapping("/administrador/administradores/eliminar")
    public String eliminarUsuarioAdmin(@RequestParam int idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
        return "redirect:/administrador/administradores";
    }

}
