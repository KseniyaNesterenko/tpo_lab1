package com.example.tpo_text.task3;

class Crew {
    Captain captain;
    Human[] members;

    public Crew(Captain captain, Human[] members) {
        this.captain = captain;
        this.members = members;
    }

    public void introduceCrew() {
        System.out.println("Капитан: " + captain.name);
        for (Human member : members) {
            System.out.println("Член экипажа: " + member.name);
        }
    }
}