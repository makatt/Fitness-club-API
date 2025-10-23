package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "typeequipment", schema = "fitnessclub")
public class TypeEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <-- автоинкремент из базы
    @Column(name = "idtypeequipment")
    private Long idtypeequipment;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "typeEquipment", fetch = FetchType.LAZY)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<Equipment> equipments;

    // ===== Геттеры и сеттеры =====

    public Long getIdtypeequipment() {
        return idtypeequipment;
    }

    public void setIdtypeequipment(Long idtypeequipment) {
        this.idtypeequipment = idtypeequipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}
