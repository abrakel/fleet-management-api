package com.api.controller;

import com.api.model.Taxis;
import com.api.service.TaxisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TaxisController {

    @Autowired //Hace que la clase cree un objeto automáticamente y lo guarde en esa variable
    private TaxisService taxisService;

    @GetMapping("/id/{id}")
    public ResponseEntity<Taxis> getById(@PathVariable Long id){
            Optional<Taxis> list = taxisService.findById(id);
            if (list.isPresent()) {
                Taxis taxi = list.get();
                return new ResponseEntity<>(taxi, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    @GetMapping("/plate/{plate}")
    public ResponseEntity<Taxis> getByPlate(@PathVariable String plate){
        Optional<Taxis> list = taxisService.findByPlate(plate);
        if (list != null) {
            Taxis taxi = list.get();
            return new ResponseEntity<>(taxi, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/taxis")
    public ResponseEntity<Page<Taxis>> getAll(@PageableDefault(page = 0, size = 10) Pageable pageable){
        Page<Taxis> listAll = taxisService.findAll(pageable);
        return new ResponseEntity<>(listAll, HttpStatus.OK);
    }
}
