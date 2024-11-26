package com.sura.siniestros.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "siniestros")
public class SINIESTRO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;  // ID del accidente

    private Date fecha;  // Fecha del accidente

    private String ubicacion;  // Ubicación del accidente (dirección o coordenadas)

    private String tipoAccidente;  // Tipo de accidente (colisión, atropello, etc.)

    private int personasInvolucradas;  // Número de personas involucradas en el accidente

    private String danosMateriales;  // Descripción de los daños materiales


    public SINIESTRO() {}

    // Constructor con parámetros
    public SINIESTRO(long id, Date fecha, String hora, String ubicacion, String tipoAccidente,
                     int personasInvolucradas, String danosMateriales) {
        this.id = id;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.tipoAccidente = tipoAccidente;
        this.personasInvolucradas = personasInvolucradas;
        this.danosMateriales = danosMateriales;
    }

    // Getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoAccidente() {
        return tipoAccidente;
    }

    public void setTipoAccidente(String tipoAccidente) {
        this.tipoAccidente = tipoAccidente;
    }

    public int getPersonasInvolucradas() {
        return personasInvolucradas;
    }

    public void setPersonasInvolucradas(int personasInvolucradas) {
        this.personasInvolucradas = personasInvolucradas;
    }

    public String getDanosMateriales() {
        return danosMateriales;
    }

    public void setDanosMateriales(String danosMateriales) {
        this.danosMateriales = danosMateriales;
    }

    @Override
    public String toString() {
        return "Accidente [ID=" + id + ", Fecha=" + fecha + ",  Ubicación=" + ubicacion
                + ", Tipo de Accidente=" + tipoAccidente + ", Personas Involucradas=" + personasInvolucradas
                + ", Daños Materiales=" + danosMateriales + "]";
    }
}

