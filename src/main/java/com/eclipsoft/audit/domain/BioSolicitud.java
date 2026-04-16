package com.eclipsoft.audit.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "bio_tb_solicitud")
@Data
public class BioSolicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_id")
    private String sessionId;

    private String identification;

    private String estado;

    @Column(name = "paso_fallido")
    private String pasoFallido;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Column(name = "onb_id")
    private String onbId;

    @Column(name = "client_id")
    private String clientId;
}