package com.sura.siniestros.Servicios;

import com.sura.siniestros.Modelos.Siniestro;
import com.sura.siniestros.Repositorios.IRepositorioSiniestro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroServicio {
    @Autowired
    IRepositorioSiniestro IRepositorioSiniestro;

    public Siniestro registrarSiniestro(Siniestro datosSiniestro) throws Exception{
        try{
            // guardar en la BBDD los datos del paciente
            return IRepositorioSiniestro.save(datosSiniestro);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Siniestro> buscarSiniestros() throws Exception{
        try{
            return IRepositorioSiniestro.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Siniestro buscarSiniestrosId(Siniestro datosSiniestro){
        return null;
    }
}

