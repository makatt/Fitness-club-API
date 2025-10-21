package com.example.demo.service;

import com.example.demo.model.TypeEquipment;
import com.example.demo.repository.TypeEquipmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TypeEquipmentService {

    private final TypeEquipmentRepository typeEquipmentRepository;

    public TypeEquipmentService(TypeEquipmentRepository typeEquipmentRepository) {
        this.typeEquipmentRepository = typeEquipmentRepository;
    }

    public List<TypeEquipment> getAllTypes() {
        return typeEquipmentRepository.findAll();
    }

    public Optional<TypeEquipment> getTypeById(Long id) {
        return typeEquipmentRepository.findById(id);
    }

    public TypeEquipment saveType(TypeEquipment typeEquipment) {
        return typeEquipmentRepository.save(typeEquipment);
    }

    public void deleteType(Long id) {
        typeEquipmentRepository.deleteById(id);
    }
}
