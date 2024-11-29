package com.sura.siniestros.Repositorios;

import com.sura.siniestros.Modelos.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioAdministrador extends JpaRepository <Administrador, Long> {

    //buscar el administrador por su nombre de usuario
    Administrador findByUsuario(String usuario);
}
