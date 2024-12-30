package com.ProyectoWeb.EduTech.Service;

import com.ProyectoWeb.EduTech.Model.Opcion;
import com.ProyectoWeb.EduTech.Model.OpcionDTO;
import com.ProyectoWeb.EduTech.Model.Pregunta;
import com.ProyectoWeb.EduTech.Repository.OpcionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpcionService {

    @Autowired
    private OpcionRepositorio opcionRepositorio;

    public Opcion registrarOpcion(OpcionDTO opcionDTO, Pregunta pregunta) {
        Opcion opcion = new Opcion();
        opcion.setOpcion(opcionDTO.getOpcion());
        opcion.setCorrecta(opcionDTO.getCorrecta());
        opcion.setPregunta(pregunta);

        return opcionRepositorio.save(opcion);
    }
}
