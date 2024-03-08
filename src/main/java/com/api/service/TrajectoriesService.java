package com.api.service;

import com.api.model.Trajectories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;


public interface TrajectoriesService {
    Page<Trajectories> findTrajectoriesByIdAndDate(Long taxiId, String date, Pageable pageable);
}
