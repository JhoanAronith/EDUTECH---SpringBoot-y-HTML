package com.ProyectoWeb.EduTech.Controller;

import com.ProyectoWeb.EduTech.Model.RegistroCurso;
import com.ProyectoWeb.EduTech.Service.RegistroCursoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroController {

    @Autowired
    private RegistroCursoServicio registroCursoServicio;

    @GetMapping("/administrador/registros")
    public String verRegistros(Model model) {
        List<RegistroCurso> registros = registroCursoServicio.listarTodos();
        model.addAttribute("registros", registros);
        return "admin/registros";
    }
}


