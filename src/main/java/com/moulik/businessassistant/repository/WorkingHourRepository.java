package com.moulik.businessassistant.repository;

import com.moulik.businessassistant.model.WorkingHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sadman
 */
@Repository
public interface WorkingHourRepository extends JpaRepository<WorkingHour, Long> {
    @Query("SELECT sum(hour) FROM WorkingHour group by worker order by worker.userName")
    List<Double> getWorkHourList();

    @Query("SELECT distinct worker.userName FROM WorkingHour order by worker.userName")
    List<String> getWorkerList();
}
