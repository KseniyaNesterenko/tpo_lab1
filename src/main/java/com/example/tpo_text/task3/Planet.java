package com.example.tpo_text.task3;

class Planet {
    private String name;
    private boolean inhabited;
    private Species dominantSpecies;

    public Planet(String name, boolean inhabited, Species dominantSpecies) {
        this.name = name;
        this.inhabited = inhabited;
        this.dominantSpecies = dominantSpecies;
    }
}