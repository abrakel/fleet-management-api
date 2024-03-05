package com.api.service;

import com.api.model.Taxis;
import com.api.repository.TaxisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaxisServiceImp implements TaxisService{
    @Autowired
    private TaxisRepository taxiRepository;

    public Optional <Taxis> findById(Long id){
        return taxiRepository.findById(id);
    }

    public Optional <Taxis> findByPlate(String plate){
        return taxiRepository.findByPlate(plate);
    }

    public Page<Taxis> findAll(Pageable pageable){
        return taxiRepository.findAll(pageable);
    }
}
