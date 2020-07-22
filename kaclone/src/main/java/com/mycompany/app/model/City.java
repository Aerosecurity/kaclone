package com.mycompany.app.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID uuid;

    private UUID ownerUuid;

    private String name;

    private int food;

    private int wood;

    private int metal;

    private int foodStored;

    private int woodStored;

    private int metalStored;

    private Date foodLastSaved;

    private Date woodLastSaved;

    private Date metalLastSaved;

    public City(String name, UUID owner) {
        this.name = name;
        this.ownerUuid = owner;
        Date date = new Date();
        foodLastSaved = date;
        woodLastSaved = date;
        metalLastSaved = date;
    }

    protected City() {}

    public UUID getUuid() {
        return uuid;
    }

    public Date getMetalLastSaved() {
        return metalLastSaved;
    }

    public Date getWoodLastSaved() {
        return woodLastSaved;
    }

    public Date getFoodLastSaved() {
        return foodLastSaved;
    }

    public int getMetalStored() {
        return metalStored;
    }

    public int getWoodStored() {
        return woodStored;
    }

    public int getFoodStored() {
        return foodStored;
    }

    public int getMetal() {
        return metal;
    }

    public int getWood() {
        return wood;
    }

    public int getFood() {
        return food;
    }

    public String getName() {
        return name;
    }

    public UUID getOwnerUuid() {
        return ownerUuid;
    }

    public void setMetalLastSaved(Date metalLastSaved) {
        this.metalLastSaved = metalLastSaved;
    }

    public void setWoodLastSaved(Date woodLastSaved) {
        this.woodLastSaved = woodLastSaved;
    }

    public void setFoodLastSaved(Date foodLastSaved) {
        this.foodLastSaved = foodLastSaved;
    }

    public void setMetalStored(int metalStored) {
        this.metalStored = metalStored;
    }

    public void setWoodStored(int woodStored) {
        this.woodStored = woodStored;
    }

    public void setFoodStored(int foodStored) {
        this.foodStored = foodStored;
    }

    public void setMetal(int metal) {
        this.metal = metal;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerUuid(UUID ownerUuid) {
        this.ownerUuid = ownerUuid;
    }
}