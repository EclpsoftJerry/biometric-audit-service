package com.eclipsoft.audit.dto;

import lombok.Data;

@Data
public class StepDTO {

    private String step;
    private String tipoRegistro;
    private String tipoValidacion;
    private Integer orden;

    private Boolean resultado;
    private Double score;

    private String s3Path;
    private String descripcion;

    private String etiquetasMatch;
    private Integer intento;
    private String awsLivenessSession;
}