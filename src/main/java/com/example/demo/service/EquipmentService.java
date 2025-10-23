package com.example.demo.service;

import com.example.demo.model.Equipment;
import com.example.demo.model.TypeEquipment;
import com.example.demo.repository.EquipmentRepository;
import com.example.demo.repository.TypeEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private TypeEquipmentRepository typeEquipmentRepository;

    // Получить всё оборудование
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    // Получить оборудование по ID
    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id).orElse(null);
    }

    // Создать новое оборудование (с указанием типа)
    public Equipment createEquipment(Equipment equipment, Long typeId) {
        if (typeId != null) {
            TypeEquipment type = typeEquipmentRepository.findById(typeId)
                    .orElseThrow(() -> new RuntimeException("Тип оборудования с id=" + typeId + " не найден"));
            equipment.setType(type);
        }
        return equipmentRepository.save(equipment);
    }

    // Обновить существующее оборудование
    public Equipment updateEquipment(Long id, Equipment equipment, Long typeId) {
        Equipment existing = equipmentRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(equipment.getName());
            existing.setState(equipment.getState());

            if (typeId != null) {
                TypeEquipment type = typeEquipmentRepository.findById(typeId)
                        .orElseThrow(() -> new RuntimeException("Тип оборудования с id=" + typeId + " не найден"));
                existing.setType(type);
            }

            return equipmentRepository.save(existing);
        } else {
            return null;
        }
    }

    // Удалить оборудование
    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }
}
