package com.utility;

public class SuperObject {
    public String name;
    public int damage;
    public String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SuperObject{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", description='" + description + '\'' +
                '}';
    }
}