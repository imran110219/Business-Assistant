package com.moulik.businessassistant.repository;

import com.moulik.businessassistant.model.WorkingHour;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sadman
 */
public interface WorkingHourRepository extends JpaRepository<WorkingHour, Long> {
}
