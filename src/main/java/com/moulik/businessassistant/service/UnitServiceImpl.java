package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.UnitService;
import com.moulik.businessassistant.model.Unit;
import com.moulik.businessassistant.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sadman
 */
@RequiredArgsConstructor
@Service
public class UnitServiceImpl implements UnitService {
    private final UnitRepository unitRepository;

    @Override
    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    @Override
    public Unit getUnitById(Long id) throws RecordNotFoundException {
        return unitRepository.getById(id);
    }

    @Override
    public Unit createUnit(Unit unit) {
        return unitRepository.save(unit);
    }

    @Override
    public Unit updateUnit(Unit newUnit, Long id) {
        return unitRepository.findById(id)
                .map(unit -> {
                    unit.setName(newUnit.getName());
                    return unitRepository.save(unit);
                })
                .orElseGet(() -> {
                    newUnit.setId(id);
                    return unitRepository.save(newUnit);
                });
    }

    @Override
    public void deleteUnitById(Long id) {
        unitRepository.deleteById(id);
    }
}
