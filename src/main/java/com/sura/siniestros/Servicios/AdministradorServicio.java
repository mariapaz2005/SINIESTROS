package com.sura.siniestros.Servicios;

import com.sura.siniestros.Modelos.Administrador;
import com.sura.siniestros.Repositorios.IRepositorioAdministrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorServicio {

    @Autowired
    private IRepositorioAdministrador iRepositorioAdministrador;


    //metodo para autenticar el administrador
    public boolean autenticarAdministrador(String usuario, String contrasena) throws Exception {
        Administrador administrador = iRepositorioAdministrador.findByUsuario(usuario);

        // Verificamos si el administrador existe
        if (administrador == null) {
            throw new Exception("Administrador no encontrado");
        }

        // Verificamos si la contraseña es correcta
        if (!administrador.getContrasena().equals(contrasena)) {
            throw new Exception("Contraseña incorrecta");
        }

        return true;  // Autenticación exitosa
    }

    public Administrador crearAdministrador(Administrador administrador) throws Exception {
        return iRepositorioAdministrador.save(administrador);
    }

}
