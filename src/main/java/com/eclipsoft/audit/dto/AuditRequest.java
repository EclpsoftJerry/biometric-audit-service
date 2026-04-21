package com.eclipsoft.audit.dto;

import lombok.Data;
import java.util.List;

@Data
public class AuditRequest {

    private String sessionId;
    private String identification;
    private String estado;
    private String pasoFallido;
    private String onbId;
    private String clientId;
    private Integer intento;

    private List<StepDTO> steps;
}