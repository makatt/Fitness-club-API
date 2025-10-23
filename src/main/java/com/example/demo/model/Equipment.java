package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "equipment")
@JsonInclude(JsonInclude.Include.NON_NULL) // не показывать null-поля в JSON
@Schema(description = "Сущность оборудования фитнес-клуба")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID оборудования (генерируется автоматически)", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long equipment_id;

    @Schema(description = "Название оборудования", example = "Гантель 10 кг")
    private String equipment_name;

    @Schema(description = "Состояние оборудования", example = "в использовании")
    private String state;

    @Transient
    @Schema(description = "ID типа оборудования", example = "1")
    private Long typeId;

    @ManyToOne
    @JoinColumn(name = "type_equipment_id")
    @JsonIgnore // ❗ скрываем этот объект из JSON и Swagger
    private TypeEquipment typeEquipment;

    // --- Геттеры и сеттеры ---
    public Long getId() {
        return equipment_id;
    }

    public void setId(Long id) {
        this.equipment_id = id;
    }

    public String getName() {
        return equipment_name;
    }

    public void setName(String name) {
        this.equipment_name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getTypeId() {
        // Если typeId не задан, но объект typeEquipment есть — возвращаем его ID
        return typeId != null ? typeId :
                (typeEquipment != null ? typeEquipment.getIdtypeequipment() : null);
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public TypeEquipment getType() {
        return typeEquipment;
    }

    public void setType(TypeEquipment type) {
        this.typeEquipment = type;
    }
}
