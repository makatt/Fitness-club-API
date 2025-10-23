package com.example.demo.controller;

import com.example.demo.model.Equipment;
import com.example.demo.service.EquipmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Equipment Controller", description = "Управление оборудованием фитнес-клуба")
@RestController
@RequestMapping("/equipment")
@CrossOrigin(origins = "*")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @Operation(summary = "Получить список оборудования",
            description = "Возвращает полный список оборудования с типами и состоянием")
    @GetMapping("")
    public List<Equipment> getAllEquipment() {
        return equipmentService.getAllEquipment();
    }

    @Operation(summary = "Получить оборудование по ID",
            description = "Возвращает данные оборудования по указанному идентификатору")
    @GetMapping("/{id}")
    public Equipment getEquipmentById(
            @Parameter(description = "ID оборудования", example = "1")
            @PathVariable Long id) {
        return equipmentService.getEquipmentById(id);
    }

    @Operation(
            summary = "Создание оборудования",
            description = "Создаёт новое оборудование и привязывает к нему тип через ID",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Пример JSON для создания оборудования",
                    required = true,
                    content = @io.swagger.v3.oas.annotations.media.Content(
                            mediaType = "application/json",
                            examples = {
                                    @io.swagger.v3.oas.annotations.media.ExampleObject(
                                            name = "Пример запроса",
                                            value = "{\n  \"name\": \"Гантель 10 кг\",\n  \"state\": \"в использовании\",\n  \"typeId\": 1\n}"
                                    )
                            }
                    )
            )
    )
    @PostMapping("")
    public Equipment createEquipment(@RequestBody Equipment equipment) {
        return equipmentService.createEquipment(equipment, equipment.getTypeId());
    }

    @Operation(
            summary = "Создание оборудования",
            description = "Создаёт новое оборудование и привязывает к нему тип через ID",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Пример JSON для создания оборудования",
                    required = true,
                    content = @io.swagger.v3.oas.annotations.media.Content(
                            mediaType = "application/json",
                            examples = {
                                    @io.swagger.v3.oas.annotations.media.ExampleObject(
                                            name = "Пример создания оборудования",
                                            value = "{\n  \"name\": \"Гантель 10 кг\",\n  \"state\": \"в использовании\",\n  \"typeId\": 1\n}"
                                    )
                            }
                    )
            )
    )
    @PutMapping("/{id}")
    public Equipment updateEquipment(
            @Parameter(description = "ID оборудования для обновления", example = "1")
            @PathVariable Long id,
            @RequestBody Equipment equipment) {
        return equipmentService.updateEquipment(id, equipment, equipment.getTypeId());
    }

    @Operation(summary = "Удаление оборудования",
            description = "Удаляет оборудование по ID")
    @DeleteMapping("/{id}")
    public void deleteEquipment(
            @Parameter(description = "ID оборудования для удаления", example = "1")
            @PathVariable Long id) {
        equipmentService.deleteEquipment(id);
    }
}
