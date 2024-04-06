package com.eureka.lab.singlestoreexamples.controller;

import com.eureka.lab.singlestoreexamples.domain.BctmImagenSolicitud;
import com.eureka.lab.singlestoreexamples.domain.BctmImagenSolicitudDto;
import com.eureka.lab.singlestoreexamples.repository.BctmImagenSolicitudRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/bctmImagenSolicitud")
public class BctmImagenSolicitudController {

    private final BctmImagenSolicitudRepository repository;

    public BctmImagenSolicitudController(BctmImagenSolicitudRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Flux<BctmImagenSolicitud> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<BctmImagenSolicitud> getOne(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping
    public Mono<BctmImagenSolicitud> create(@RequestBody BctmImagenSolicitudDto bctmImagenSolicitudDto) {
        var bctmImagenSolicitudEntity = new BctmImagenSolicitud();
        BeanUtils.copyProperties(bctmImagenSolicitudDto, bctmImagenSolicitudEntity);
        bctmImagenSolicitudEntity.setBlFormato(convertStringToDataBuffer(bctmImagenSolicitudDto.getBlFormato()));
        bctmImagenSolicitudEntity.setNew(true);
        return repository.save(bctmImagenSolicitudEntity);
    }

    @PutMapping("/{id}")
    public Mono<BctmImagenSolicitud> update(@PathVariable Integer id,
                                            @RequestBody BctmImagenSolicitud bctmImagenSolicitud) {
        return repository.findById(id)
                .map(existingBctmImagenSolicitud -> {
                    // copy properties from `bctmImagenSolicitud` to `existingBctmImagenSolicitud`
                    existingBctmImagenSolicitud.setCoUsuActualiza(bctmImagenSolicitud.getCoUsuActualiza());
                    existingBctmImagenSolicitud.setInEncriptado(bctmImagenSolicitud.getInEncriptado());
                    return existingBctmImagenSolicitud;
                })
                .flatMap(repository::save);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) {
        return repository.deleteById(id);
    }

    public ByteBuffer convertStringToDataBuffer(String data) {
        return ByteBuffer.wrap(data.getBytes(StandardCharsets.UTF_8));

    }
}