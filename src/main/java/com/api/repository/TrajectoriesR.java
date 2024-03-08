package com.api.repository;

import com.api.model.Trajectories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface TrajectoriesR extends JpaRepository<Trajectories, Long> {
    @Query(value = "SELECT * FROM trajectories WHERE taxi_id = :taxiId AND TO_CHAR (date, 'dd-MM-yyyy') = :date", nativeQuery = true)
    Page<Trajectories> findTrajectoriesByIdAndDate(Long taxiId, String date, Pageable pageable);
}
