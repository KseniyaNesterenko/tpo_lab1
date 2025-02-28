package com.example.tpo_text.task3;

import java.util.List;

class SpaceFleet {
    private String name;
    private List<Spaceship> ships;

    public SpaceFleet(String name, List<Spaceship> ships) {
        this.name = name;
        this.ships = ships;
    }
}