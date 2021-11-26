package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.WorkingHourService;
import com.moulik.businessassistant.model.WorkingHour;
import com.moulik.businessassistant.repository.WorkingHourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sadman
 */
@RequiredArgsConstructor
@Service
public class WorkingHourServiceImpl implements WorkingHourService {
    private final WorkingHourRepository workingHourRepository;

    @Override
    public List<WorkingHour> getAllWorkingHours() {
        return workingHourRepository.findAll();
    }

    @Override
    public WorkingHour getWorkingHourById(Long id) throws RecordNotFoundException {
        return workingHourRepository.getById(id);
    }

    @Override
    public WorkingHour createWorkingHour(WorkingHour workingHour) {
        return workingHourRepository.save(workingHour);
    }

    @Override
    public WorkingHour updateWorkingHour(WorkingHour newWorkingHour, Long id) {
        return workingHourRepository.findById(id)
                .map(workingHour -> {
                    workingHour.setWorker(newWorkingHour.getWorker());
                    workingHour.setHour(newWorkingHour.getHour());
                    workingHour.setPurpose(newWorkingHour.getPurpose());
                    workingHour.setDatetime(newWorkingHour.getDatetime());
                    return workingHourRepository.save(workingHour);
                })
                .orElseGet(() -> {
                    newWorkingHour.setId(id);
                    return workingHourRepository.save(newWorkingHour);
                });
    }

    @Override
    public void deleteWorkingHourById(Long id) {
        workingHourRepository.deleteById(id);
    }
}
