package com.eclipsoft.audit.controller;

import com.eclipsoft.audit.dto.AuditRequest;
import com.eclipsoft.audit.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/audit")
@RequiredArgsConstructor
public class AuditController {

    private final AuditService auditService;

    @PostMapping
    public ResponseEntity<?> saveAudit(@RequestBody AuditRequest request) {
        try {
            if (request.getIdentification() == null || request.getIdentification().isEmpty()) {
                return ResponseEntity.badRequest().body("identification es obligatorio");
            }
            auditService.saveAudit(request);
            return ResponseEntity.ok("Audit guardado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar audit");
        }
    }
}