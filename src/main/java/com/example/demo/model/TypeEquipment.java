package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "typeequipment", schema = "fitnessclub")
public class TypeEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtypeequipment;

    private String name;

    @OneToMany(mappedBy = "typeEquipment", fetch = FetchType.LAZY)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<Equipment> equipments;


    // геттеры/сеттеры
    public Long getId() { return idtypeequipment; }
    public void setId(Long id) { this.idtypeequipment = id; }

    public String getTypeName() { return name; }
    public void setTypeName(String typeName) { this.name = typeName; }

    public List<Equipment> getEquipments() { return equipments; }
    public void setEquipments(List<Equipment> equipments) { this.equipments = equipments; }
}