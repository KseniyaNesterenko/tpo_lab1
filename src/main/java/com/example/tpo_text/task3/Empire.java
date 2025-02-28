package com.example.tpo_text.task3;

import java.util.List;

class Empire {
    private String name;
    private List<SpaceFleet> fleets;

    public Empire(String name, List<SpaceFleet> fleets) {
        this.name = name;
        this.fleets = fleets;
    }

    public String hardenUp() {
        if (fleets == null || fleets.isEmpty()) {
            return "Империя " + name + " не может закаляться. У неё нет флота.";
        }
        return "Империя " + name + " закаляется";
    }

    public int getFleetSize() {
        return fleets != null ? fleets.size() : 0;
    }

    public String compareStrength(Empire other) {
        if (other == null) return "Сравнение невозможно, другой империи нет.";

        int thisSize = getFleetSize();
        int otherSize = other.getFleetSize();

        if (thisSize > otherSize) {
            return "Империя " + name + " сильнее, у неё больше флотов.";
        } else if (thisSize < otherSize) {
            return "Империя " + other.name + " сильнее.";
        } else {
            return "Империи " + name + " и " + other.name + " равны по мощи.";
        }
    }
}
