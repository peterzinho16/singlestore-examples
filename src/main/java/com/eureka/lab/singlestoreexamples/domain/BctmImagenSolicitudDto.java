package com.eureka.lab.singlestoreexamples.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
public class BctmImagenSolicitudDto {

    private Integer nuSolicitud;
    private Integer coTipoFormatoImage;
    private Integer idIdentificadorBio;
    private String blFormato;
    private String coUsuCrea;
    private LocalDate feActualiza;
    private String coUsuActualiza;
    private Integer nuCalidadHuella;
    private String inMejorHuellaReniec;
    private Integer esImagenSolicitud;
    private String clFormato;
    private String deTagAuth;
    private String inEncriptado;

    // getters and setters
}