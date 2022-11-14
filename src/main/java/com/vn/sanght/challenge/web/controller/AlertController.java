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
     * GET /api/alerts?machine=:machine : Get alerts by machine
     *
     * @param machine  The name of machine
     * @return the list of found alerts
     */
    @GetMapping(path = "/alerts", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Alert>> getAlertsByMachine(@RequestParam String machine) {
        List<Alert> alerts = alertService.findByMachine(machine);

        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }

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
