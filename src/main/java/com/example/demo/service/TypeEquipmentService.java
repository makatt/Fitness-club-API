package com.example.demo.service;

import com.example.demo.model.TypeEquipment;
import com.example.demo.repository.TypeEquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeEquipmentService {

    private final TypeEquipmentRepository typeEquipmentRepository;

    public TypeEquipmentService(TypeEquipmentRepository typeEquipmentRepository) {
        this.typeEquipmentRepository = typeEquipmentRepository;
    }

    public List<TypeEquipment> getAllTypes() {
        return typeEquipmentRepository.findAll();
    }

    public TypeEquipment getTypeById(Long id) {
        return typeEquipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Тип оборудования с id=" + id + " не найден"));
    }

    public TypeEquipment createType(TypeEquipment typeEquipment) {
        return typeEquipmentRepository.save(typeEquipment);
    }

    public TypeEquipment updateType(Long id, TypeEquipment updatedType) {
        TypeEquipment existing = typeEquipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Тип оборудования с id=" + id + " не найден"));

        existing.setName(updatedType.getName());
        existing.setDescription(updatedType.getDescription());

        return typeEquipmentRepository.save(existing);
    }

    public void deleteType(Long id) {
        typeEquipmentRepository.deleteById(id);
    }
}
