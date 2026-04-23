package com.eclipsoft.audit.service;

import com.eclipsoft.audit.domain.*;
import com.eclipsoft.audit.dto.*;
import com.eclipsoft.audit.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuditService {

    private final BioSolicitudRepository solicitudRepo;
    private final BioDetalleSolicitudRepository detalleRepo;

    public void saveAudit(AuditRequest request) {
        log.info("Iniciando guardado de audit - sessionId: {}", request.getSessionId());
        BioSolicitud solicitud = new BioSolicitud();
        solicitud.setSessionId(request.getSessionId());
        solicitud.setIdentification(request.getIdentification());
        solicitud.setEstado(request.getEstado());
        solicitud.setPasoFallido(request.getPasoFallido());
        solicitud.setOnbId(request.getOnbId());
        solicitud.setClientId(request.getClientId());
        solicitud.setFechaInicio(LocalDateTime.now());

        solicitud = solicitudRepo.save(solicitud);
        if (request.getSteps() != null && !request.getSteps().isEmpty()) {
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
        solicitud.setFechaFin(LocalDateTime.now());
        solicitudRepo.save(solicitud);
        log.info("Audit guardado correctamente - sessionId: {}", request.getSessionId());
    }
}