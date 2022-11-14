package com.vn.sanght.challenge.service;

import com.vn.sanght.challenge.domain.Alert;

import java.util.List;

/**
 * Service Interface for managing Alert.
 */
public interface AlertService {
    /**
     * Save an alert.
     *
     * @param alert the entity to save
     * @return the persisted entity
     */
    Alert save(Alert alert);

    /**
     * Get alert by the given ID
     *
     * @param id The ID of alert
     * @return the instance of Alert. Otherwise, Throws NotFoundException
     */
    Alert getById(Integer id);

    /**
     * Find alerts by the given machine.
     *
     * @param machine The machine name
     * @return the list of entities
     */
    List<Alert> findByMachine(String machine);
}
