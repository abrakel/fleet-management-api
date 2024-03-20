package com.api.service;

import com.api.model.Trajectories;
import com.api.repository.TrajectoriesR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TrajectoriesImplement implements TrajectoriesService{
     @Autowired
    private TrajectoriesR trajectoriesR;

     public Page<Trajectories> findTrajectoriesByIdAndDate(Long taxiId, String date, Pageable pageable){
         return trajectoriesR.findTrajectoriesByIdAndDate(taxiId, date, pageable);
     }

     public Page<Trajectories> findLastLocation(Pageable pageable){
         return trajectoriesR.findLastLocation(pageable);
     }

}
