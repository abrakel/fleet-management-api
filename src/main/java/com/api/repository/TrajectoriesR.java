package com.api.repository;

import com.api.model.Trajectories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrajectoriesR extends JpaRepository<Trajectories, Long> {
    @Query(value = "SELECT * FROM trajectories WHERE taxi_id = :taxiId AND TO_CHAR (date, 'dd-MM-yyyy') = :date", nativeQuery = true)
    Page<Trajectories> findTrajectoriesByIdAndDate(Long taxiId, String date, Pageable pageable);

    @Query(value = "SELECT DISTINCT ON (taxi_id) t.id, t.taxi_id, t.latitude, t.longitude, t.date " +
            "FROM Trajectories t " +
            "JOIN Taxis r ON t.taxi_id = r.id " +
            "WHERE (t.taxi_id, t.date) IN (SELECT taxi_id, MAX(date) " +
            "FROM Trajectories GROUP BY taxi_id)", nativeQuery = true)
    List<Trajectories>findLastLocation(Pageable pageable);
}
