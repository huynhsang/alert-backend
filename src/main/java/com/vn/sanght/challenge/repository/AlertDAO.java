package com.vn.sanght.challenge.repository;

import com.vn.sanght.challenge.domain.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertDAO extends JpaRepository<Alert, Integer> {
    List<Alert> findByMachineOrderByIdAsc(String machine);
}
