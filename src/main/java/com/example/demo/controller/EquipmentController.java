package com.example.demo.controller;

import com.example.demo.model.Equipment;
import com.example.demo.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
@CrossOrigin(origins = "*") // можно убрать, если не нужно
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public List<Equipment> getAll() {
        return equipmentService.getAllEquipment();
    }

    @GetMapping("/{id}")
    public Equipment getById(@PathVariable Long id) {
        return equipmentService.getEquipmentById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found with id: " + id));
    }

    @PostMapping
    public Equipment create(@RequestBody Equipment equipment) {
        return equipmentService.saveEquipment(equipment);
    }

    @PutMapping("/{id}")
    public Equipment update(@PathVariable Long id, @RequestBody Equipment updated) {
        Equipment existing = equipmentService.getEquipmentById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found with id: " + id));
        existing.setName(updated.getName());
        existing.setType(updated.getType());
        return equipmentService.saveEquipment(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
    }
}
