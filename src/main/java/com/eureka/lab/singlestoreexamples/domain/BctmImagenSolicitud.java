package com.eureka.lab.singlestoreexamples.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Table("BCTM_IMAGEN_SOLICITUD")
public class BctmImagenSolicitud implements Persistable<Integer> {

    @Id
    private Integer nuSolicitud;
    private Integer coTipoFormatoImage;
    private Integer idIdentificadorBio;
    private ByteBuffer blFormato;
    @CreatedDate
    private LocalDateTime feCrea;
    private String coUsuCrea;
    private LocalDate feActualiza;
    private String coUsuActualiza;
    private Integer nuCalidadHuella;
    private String inMejorHuellaReniec;
    private Integer esImagenSolicitud;
    private String clFormato;
    private String deTagAuth;
    private String inEncriptado;
    @JsonIgnore
    @Transient
    private boolean isNew;

    @Override
    public Integer getId() {
        return this.nuSolicitud;
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }
}