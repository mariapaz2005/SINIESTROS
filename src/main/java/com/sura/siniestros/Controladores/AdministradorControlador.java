package com.sura.siniestros.Controladores;

import com.sura.siniestros.Modelos.Administrador;
import com.sura.siniestros.Modelos.Siniestro;
import com.sura.siniestros.Repositorios.IRepositorioAdministrador;
import com.sura.siniestros.Servicios.AdministradorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorControlador {


    @Autowired
    private AdministradorServicio administradorServicio;

    // Endpoint para autenticar al administrador
    @PostMapping ("/login")
    public ResponseEntity<?> login(@RequestParam String usuario, @RequestParam String contrasena) {
        try {
            boolean autenticado = administradorServicio.autenticarAdministrador(usuario, contrasena);

            if (autenticado) {
                // Retornar respuesta 200 OK si la autenticación es exitosa
                return ResponseEntity.status(HttpStatus.OK).body("Autenticación exitosa");
            } else {
                // Retornar respuesta 401 Unauthorized si las credenciales son incorrectas
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
            }
        } catch (Exception e) {
            // En caso de error, retornar un error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Endpoint para crear un nuevo administrador (opcional)
    @PostMapping("/crear")
    public ResponseEntity<?> crearAdministrador(@RequestBody Administrador administrador) {
        try {
            // Intentamos crear un nuevo administrador
            Administrador nuevoAdministrador = administradorServicio.crearAdministrador(administrador);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAdministrador);
        } catch (Exception e) {
            // Si ocurre un error al crear el administrador, retornamos un error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear administrador: " + e.getMessage());
        }
    }
}
