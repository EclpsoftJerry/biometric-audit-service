package com.eclipsoft.audit.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bio_tb_detalle_solicitud")
@Data
public class BioDetalleSolicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "solicitud_id")
    private Long solicitudId;

    private String step;

    @Column(name = "tipo_registro")
    private String tipoRegistro;

    @Column(name = "tipo_validacion")
    private String tipoValidacion;

    @Column(name = "orden")
    private Integer orden;

    private Boolean resultado;

    private Double score;

    @Column(name = "s3_path")
    private String s3Path;

    private String descripcion;

    @Column(name = "etiquetas_match", columnDefinition = "TEXT")
    private String etiquetasMatch;

    @Column(name = "intento")
    private Integer intento;

    @Column(name = "aws_liveness_session")
    private String awsLivenessSession;
}