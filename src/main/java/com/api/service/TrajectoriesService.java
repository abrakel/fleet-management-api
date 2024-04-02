package com.api.service;

import com.api.model.Trajectories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.List;


public interface TrajectoriesService {
    Page<Trajectories> findTrajectoriesByIdAndDate(Long taxiId, String date, Pageable pageable);

    Page<Trajectories>findLastLocation(Integer page, Integer Size);
}
