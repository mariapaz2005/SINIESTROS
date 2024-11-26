package com.sura.siniestros.Controladores;

import com.sura.siniestros.Modelos.Siniestro;
import com.sura.siniestros.Servicios.SiniestroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/siniestro")
public class siniestroControlador {
    @Autowired
    SiniestroServicio siniestroServicio;
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Siniestro datos){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(siniestroServicio.registrarSiniestro(datos));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodo(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(siniestroServicio.buscarSiniestros());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}

