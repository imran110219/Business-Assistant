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
    private final UnitRepository typeRepository;

    @Override
    public List<Unit> getAllUnits() {
        return typeRepository.findAll();
    }

    @Override
    public Unit getUnitById(Long id) throws RecordNotFoundException {
        return typeRepository.getById(id);
    }

    @Override
    public Unit createUnit(Unit type) {
        return typeRepository.save(type);
    }

    @Override
    public Unit updateUnit(Unit newUnit, Long id) {
        return typeRepository.findById(id)
                .map(type -> {
                    type.setName(newUnit.getName());
                    return typeRepository.save(type);
                })
                .orElseGet(() -> {
                    newUnit.setId(id);
                    return typeRepository.save(newUnit);
                });
    }

    @Override
    public void deleteUnitById(Long id) {
        typeRepository.deleteById(id);
    }
}
