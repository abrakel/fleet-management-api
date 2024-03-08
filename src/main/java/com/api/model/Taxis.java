package com.api.model;

import jakarta.persistence.*;

@Entity //indica que es una entidad que hace referencia a la base de datos
@Table(name="taxis") //para hacer referencia a esta tabla de la base de datos
public class Taxis {

    @Id //Se indica que esta es la clave primaria
    @Column (name="id") //para indicar el nombre de la columna
    private Long id;
    @Column (name = "plate")
    private String plate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}