package com.api.service;

import com.api.model.Taxis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TaxisService {
    Optional <Taxis> findById(Long id);
    Optional <Taxis> findByPlate(String plate);
    Page<Taxis> findAll(Pageable pageable);

}
