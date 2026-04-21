package com.eclipsoft.audit.service;

import com.eclipsoft.audit.domain.*;
import com.eclipsoft.audit.dto.*;
import com.eclipsoft.audit.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuditService {

    private final BioSolicitudRepository solicitudRepo;
    private final BioDetalleSolicitudRepository detalleRepo;

    public void saveAudit(AuditRequest request) {

        BioSolicitud solicitud = new BioSolicitud();
        solicitud.setSessionId(request.getSessionId());
        solicitud.setIdentification(request.getIdentification());
        solicitud.setEstado(request.getEstado());
        solicitud.setPasoFallido(request.getPasoFallido());
        solicitud.setOnbId(request.getOnbId());
        solicitud.setClientId(request.getClientId());
        solicitud.setFechaInicio(LocalDateTime.now());

        solicitud = solicitudRepo.save(solicitud);

        for (StepDTO step : request.getSteps()) {

            BioDetalleSolicitud detalle = new BioDetalleSolicitud();
            detalle.setSolicitudId(solicitud.getId());
            detalle.setStep(step.getStep());
            detalle.setTipoRegistro(step.getTipoRegistro());
            detalle.setTipoValidacion(step.getTipoValidacion());
            detalle.setOrden(step.getOrden());
            detalle.setResultado(step.getResultado());
            detalle.setScore(step.getScore());
            detalle.setS3Path(step.getS3Path());
            detalle.setDescripcion(step.getDescripcion());
            detalle.setEtiquetasMatch(step.getEtiquetasMatch());
            detalle.setIntento(step.getIntento());
            detalle.setAwsLivenessSession(step.getAwsLivenessSession());

            detalleRepo.save(detalle);
        }
    }
}