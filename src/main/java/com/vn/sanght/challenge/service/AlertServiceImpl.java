package com.vn.sanght.challenge.service;

import com.vn.sanght.challenge.domain.Alert;
import com.vn.sanght.challenge.repository.AlertDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    private final AlertDAO alertDAO;

    public AlertServiceImpl(AlertDAO alertDAO) {
        this.alertDAO = alertDAO;
    }

    @Override
    public Alert save(Alert alert) {
        return alertDAO.save(alert);
    }

    @Override
    public Alert getById(Integer id) {
        return alertDAO.getById(id);
    }

    @Override
    public List<Alert> findAll() {
        return alertDAO.findByOrderByIdAsc();
    }
}
