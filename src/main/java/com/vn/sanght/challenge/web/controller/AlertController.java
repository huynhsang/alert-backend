package com.vn.sanght.challenge.web.controller;

import com.vn.sanght.challenge.domain.Alert;
import com.vn.sanght.challenge.service.AlertService;
import com.vn.sanght.challenge.web.vmodel.UpdateAlertVM;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlertController {
    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }


    /**
     * GET /api/alerts : Get all alerts
     *
     * @return the list of alerts
     */
    @GetMapping(path = "/alerts", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Alert>> getAlertsByMachine() {
        List<Alert> alerts = alertService.findAll();

        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }

    /**
     * PATCH /api/alert/{id} : Update alert attributes by ID
     *
     * @param id The ID of alert
     * @param payload The data to update
     * @return updated alert
     */
    @PatchMapping(path = "/alerts/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Alert> updateById(
            @PathVariable Integer id,
            @RequestBody UpdateAlertVM payload
    ) {
        Alert alert = alertService.getById(id);
        alert.setComment(payload.getComment());
        alert.setReason(payload.getReason());
        alert.setAction(payload.getAction());

        return ResponseEntity.ok().body(alertService.save(alert));
    }
}
