package com.eureka.lab.singlestoreexamples.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Setter
@Getter
@Table("BCTM_IMAGEN_SOLICITUD")
public class BctmImagenSolicitud {

    @Id
    private Integer nuSolicitud;
    private Integer coTipoFormatoImage;
    private Integer idIdentificadorBio;
    private DataBuffer blFormato;
    private Date feCrea;
    private String coUsuCrea;
    private Date feActualiza;
    private String coUsuActualiza;
    private Integer nuCalidadHuella;
    private String inMejorHuellaReniec;
    private Integer esImagenSolicitud;
    private String clFormato;
    private String deTagAuth;
    private String inEncriptado;

    // getters and setters
}