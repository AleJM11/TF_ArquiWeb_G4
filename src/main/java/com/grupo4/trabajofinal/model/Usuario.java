package com.grupo4.trabajofinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String emailUsuario;
    private String contrasena;
    private Date fechaRegistro = new Date();
    private String direccionUsuario;
    private String telefonoUsuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    List<TarjetaDebito> tarjetas;
    //Referencias
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "idCiudad")
    private Ciudad ciudad;

}
