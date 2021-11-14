package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.Type;

import java.util.List;

public interface TypeService {
    List<Type> getAllTypes();

    Type getTypeById(Long id) throws RecordNotFoundException;

    Type createType(Type type);

    Type updateType(Type newType, Long id);

    void deleteTypeById(Long id);
}
