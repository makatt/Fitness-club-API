package com.example.demo.controller;

import com.example.demo.model.TypeEquipment;
import com.example.demo.service.TypeEquipmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Type Equipment Controller",
        description = "Управление типами оборудования фитнес-клуба. " +
                "Позволяет получать, создавать, обновлять и удалять типы оборудования."
)
@RestController
@RequestMapping("/typeequipment")
@CrossOrigin(origins = "*")
public class TypeEquipmentController {

    @Autowired
    private TypeEquipmentService typeEquipmentService;

    @Operation(
            summary = "Получить все типы оборудования",
            description = "Возвращает список всех типов оборудования из базы данных."
    )
    @GetMapping("")
    public List<TypeEquipment> getAllTypes() {
        return typeEquipmentService.getAllTypes();
    }

    @Operation(
            summary = "Получить тип оборудования по ID",
            description = "Возвращает тип оборудования по указанному идентификатору."
    )
    @GetMapping("/{id}")
    public TypeEquipment getTypeById(
            @Parameter(description = "ID типа оборудования", example = "1")
            @PathVariable Long id) {
        return typeEquipmentService.getTypeById(id);
    }

    @Operation(
            summary = "Создать тип оборудования",
            description = "Создаёт новый тип оборудования. Принимает JSON с полями name и description."
    )
    @PostMapping("")
    public TypeEquipment createType(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "JSON-объект с данными типа оборудования",
                    required = true
            )
            @RequestBody TypeEquipment typeEquipment) {
        return typeEquipmentService.createType(typeEquipment);
    }

    @Operation(
            summary = "Обновить тип оборудования",
            description = "Обновляет существующий тип оборудования по ID. Принимает JSON с новыми данными."
    )
    @PutMapping("/{id}")
    public TypeEquipment updateType(
            @Parameter(description = "ID типа оборудования для обновления", example = "1")
            @PathVariable Long id,
            @RequestBody TypeEquipment updatedType) {
        return typeEquipmentService.updateType(id, updatedType);
    }

    @Operation(
            summary = "Удалить тип оборудования",
            description = "Удаляет тип оборудования по указанному ID."
    )
    @DeleteMapping("/{id}")
    public void deleteType(
            @Parameter(description = "ID типа оборудования для удаления", example = "1")
            @PathVariable Long id) {
        typeEquipmentService.deleteType(id);
    }
}
