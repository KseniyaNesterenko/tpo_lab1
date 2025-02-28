package com.example.tpo_text.task3;

import java.util.Random;

public abstract class Human {
    protected String name;
    protected int age;
    protected int health;
    protected int heroicDeedsCount = 0;
    protected Random random = new Random();

    public Human(String name, int age, int health) {
        this.name = name;
        this.age = age;
        this.health = health;
    }

    public String introduce() {
        return "Моё имя: " + name + ", возраст: " + age + ", здоровье: " + health;
    }

    public String challengeUnknown() {
        if (health <= 0) {
            return name + " не может бросить вызов неизвестности, слишком слаб.";
        }
        return name + " не боится бросить вызов неизвестности";
    }

    public String performHeroicDeed() {
        if (health <= 0) {
            return name + " не может совершить героическое деяние, так как слишком слаб.";
        }

        heroicDeedsCount++;
        if (random.nextInt(100) < 70) {
            return name + " совершает героическое деяние! Всего героических деяний: " + heroicDeedsCount;
        } else {
            return name + " не смог совершить героическое деяние. Неудача!";
        }
    }

    public String declineImmutableNouns() {
        if (health <= 0) {
            return name + " не может склонять, так как слишком слаб.";
        }
        health -= 5;
        return name + " пытается склонять, здоровье уменьшилось до: " + health;
    }

    public String checkHealth() {
        if (health <= 0) {
            return name + " на грани смерти!";
        }
        return name + " в хорошем состоянии, здоровье: " + health;
    }

    public int getHeroicDeedsCount() {
        return heroicDeedsCount;
    }

    public String getName() {
        return name;
    }
}
