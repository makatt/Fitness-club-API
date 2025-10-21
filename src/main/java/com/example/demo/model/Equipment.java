package com.example.demo.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipment_id;

    private String equipment_name;

    private String state;

    @ManyToOne
    @JoinColumn(name = "type_equipment_id") // внешний ключ на таблицу type_equipment
    private TypeEquipment typeEquipment;

    // геттеры/сеттеры
    public Long getId() { return equipment_id; }
    public void setId(Long id) { this.equipment_id = id; }

    public String getName() { return equipment_name; }
    public void setName(String name) { this.equipment_name = name; }

    public TypeEquipment getType() { return typeEquipment; }
    public void setType(TypeEquipment type) { this.typeEquipment = type; }
}
