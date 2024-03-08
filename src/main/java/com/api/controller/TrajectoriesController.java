package com.api.controller;

import com.api.model.Trajectories;
import com.api.service.TrajectoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trajectories")
public class TrajectoriesController {
    @Autowired
    private TrajectoriesService trajectoriesService;

    @GetMapping("/taxi")
    public ResponseEntity<Page<Trajectories>> getTrajectories (@RequestParam Long taxiId,@RequestParam String date, @PageableDefault (page=0, size = 10) Pageable pageable){
        Page<Trajectories> trajectories = trajectoriesService.findTrajectoriesByIdAndDate(taxiId, date, pageable);
        if (taxiId != null && !date.isEmpty()) {
            return new ResponseEntity<>(trajectories, HttpStatus.OK);
        } else if(trajectories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
