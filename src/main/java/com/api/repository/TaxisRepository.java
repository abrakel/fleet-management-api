package com.api.repository;

import com.api.model.Taxis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaxisRepository extends JpaRepository<Taxis, Long> {
    Optional<Taxis> findById(Long id);
    Optional <Taxis> findByPlate (String plate);
    Page<Taxis> findAll (Pageable pageable);
}
