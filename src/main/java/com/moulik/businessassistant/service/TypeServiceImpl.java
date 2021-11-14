package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.TypeService;
import com.moulik.businessassistant.model.Type;
import com.moulik.businessassistant.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sadman
 */
@RequiredArgsConstructor
@Service
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public Type getTypeById(Long id) throws RecordNotFoundException {
        return typeRepository.getById(id);
    }

    @Override
    public Type createType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type updateType(Type newType, Long id) {
        return typeRepository.findById(id)
                .map(type -> {
                    type.setName(newType.getName());
                    type.setDescription(newType.getDescription());
                    return typeRepository.save(type);
                })
                .orElseGet(() -> {
                    newType.setId(id);
                    return typeRepository.save(newType);
                });
    }

    @Override
    public void deleteTypeById(Long id) {
        typeRepository.deleteById(id);
    }
}
