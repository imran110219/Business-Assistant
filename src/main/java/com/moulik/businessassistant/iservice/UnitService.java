package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.Unit;

import java.util.List;

public interface UnitService {
    List<Unit> getAllUnits();

    Unit getUnitById(Long id) throws RecordNotFoundException;

    Unit createUnit(Unit unit);

    Unit updateUnit(Unit newUnit, Long id);

    void deleteUnitById(Long id);
}
