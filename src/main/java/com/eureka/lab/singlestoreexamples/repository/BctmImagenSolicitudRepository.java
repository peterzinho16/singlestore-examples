package com.eureka.lab.singlestoreexamples.repository;

import com.eureka.lab.singlestoreexamples.domain.BctmImagenSolicitud;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BctmImagenSolicitudRepository extends ReactiveCrudRepository<BctmImagenSolicitud, Integer> {
}