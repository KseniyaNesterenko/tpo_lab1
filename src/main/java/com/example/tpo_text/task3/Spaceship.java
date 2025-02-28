package com.example.tpo_text.task3;

class Spaceship {
    private String name;
    private Crew crew;

    public Spaceship(String name, Crew crew) {
        this.name = name;
        this.crew = crew;
    }

    public String explore() {
        if (crew == null || crew.members.length == 0) {
            return name + " не может начать путешествие, экипаж не готов.";
        }
        return name + " бороздит бескрайние просторы Галактики в поисках славы и приключений!";
    }

    public boolean isReadyForMission() {
        return crew != null && crew.members.length > 0;
    }
}
