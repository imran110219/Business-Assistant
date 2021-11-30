package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.WorkingHour;

import java.util.List;

public interface WorkingHourService {
    List<WorkingHour> getAllWorkingHours();

    WorkingHour getWorkingHourById(Long id) throws RecordNotFoundException;

    WorkingHour createWorkingHour(WorkingHour unit);

    WorkingHour updateWorkingHour(WorkingHour newWorkingHour, Long id);

    void deleteWorkingHourById(Long id);

    List<Double> getWorkHourList();

    List<String> getWorkerList();
}
