package com.example.demo.controller;

import com.example.demo.model.TypeEquipment;
import com.example.demo.service.TypeEquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeEquipment")
@CrossOrigin(origins = "*")
public class TypeEquipmentController {

    private final TypeEquipmentService typeEquipmentService;

    public TypeEquipmentController(TypeEquipmentService typeEquipmentService) {
        this.typeEquipmentService = typeEquipmentService;
    }

    @GetMapping
    public List<TypeEquipment> getAll() {
        return typeEquipmentService.getAllTypes();
    }

    @GetMapping("/{id}")
    public TypeEquipment getById(@PathVariable Long id) {
        return typeEquipmentService.getTypeById(id)
                .orElseThrow(() -> new RuntimeException("Type not found with id: " + id));
    }

    @PostMapping
    public TypeEquipment create(@RequestBody TypeEquipment typeEquipment) {
        return typeEquipmentService.saveType(typeEquipment);
    }

    @PutMapping("/{id}")
    public TypeEquipment update(@PathVariable Long id, @RequestBody TypeEquipment updated) {
        TypeEquipment existing = typeEquipmentService.getTypeById(id)
                .orElseThrow(() -> new RuntimeException("Type not found with id: " + id));
        existing.setTypeName(updated.getTypeName());
        return typeEquipmentService.saveType(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        typeEquipmentService.deleteType(id);
    }
}
