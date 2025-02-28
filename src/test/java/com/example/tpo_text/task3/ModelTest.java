package com.example.tpo_text.task3;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

class ModelTest {

    @Test
    @DisplayName("Тест закалки империи без флота")
    void testHardenUpWithoutFleet() {
        Empire empire = new Empire("ОПД", List.of());
        assertEquals("Империя ОПД не может закаляться. У неё нет флота.", empire.hardenUp());
    }

    @Test
    @DisplayName("Тест закалки империи с флотом")
    void testHardenUpWithFleet() {
        SpaceFleet fleet = new SpaceFleet("1st Fleet", List.of());
        Empire empire = new Empire("ОПИ", List.of(fleet));
        assertEquals("Империя ОПИ закаляется", empire.hardenUp());
    }

    @Test
    @DisplayName("Тест сравнения силы империй")
    void testCompareStrength() {
        SpaceFleet fleet1 = new SpaceFleet("1st Fleet", List.of());
        SpaceFleet fleet2 = new SpaceFleet("2nd Fleet", List.of());

        Empire empire1 = new Empire("ОПД", List.of(fleet1));
        Empire empire2 = new Empire("ОПИ", List.of(fleet1, fleet2));

        assertEquals("Империя ОПИ сильнее, у неё больше флотов.", empire2.compareStrength(empire1));
    }

    @Test
    @DisplayName("Тест сравнения империй с равной силой")
    void testCompareEqualStrength() {
        SpaceFleet fleet1 = new SpaceFleet("Fleet", List.of());

        Empire empire1 = new Empire("ОПД", List.of(fleet1));
        Empire empire2 = new Empire("ОПИ", List.of(fleet1));

        assertEquals("Империи ОПД и ОПИ равны по мощи.", empire1.compareStrength(empire2));
    }

    @Test
    @DisplayName("Тест приказа капитана")
    void testGiveOrder() {
        Captain captain = new Captain("Дмитрий Борисович", 40, 88);
        assertEquals("Дмитрий Борисович отдаёт приказ: Атаковать!", captain.giveOrder("Атаковать!"));
    }

    @Test
    @DisplayName("Тест исследования корабля без экипажа")
    void testExploreWithoutCrew() {
        Spaceship spaceship = new Spaceship("ITMO", null);
        assertEquals("ITMO не может начать путешествие, экипаж не готов.", spaceship.explore());
    }

    @Test
    @DisplayName("Тест исследования корабля с экипажем")
    void testExploreWithCrew() {
        Captain captain = new Captain("Дмитрий Борисович", 40, 88);
        Human[] crewMembers = {new Male("Борис Дмитриевич", 30, 77), new Female("Бориса Дмитриевна", 28, 88)};
        Crew crew = new Crew(captain, crewMembers);

        Spaceship spaceship = new Spaceship("Буба", crew);
        assertEquals("Буба бороздит бескрайние просторы Галактики в поисках славы и приключений!", spaceship.explore());
    }


    @Test
    @DisplayName("Тест количества отданных приказов капитаном")
    void testOrdersGiven() {
        Captain captain = new Captain("Дмитрий Дмитриевоборисович", 40, 88);
        assertEquals(0, captain.getOrdersGiven());

        captain.giveOrder("Исследовать планету!");
        assertEquals(1, captain.getOrdersGiven());

        captain.giveOrder("Атаковать!");
        captain.giveOrder("Отступать!");
        assertEquals(3, captain.getOrdersGiven());
    }

    @Test
    @DisplayName("Тест представления экипажа")
    void testCrewIntroduction() {
        Captain captain = new Captain("Борисоводмитрий", 40, 66);
        Human[] crewMembers = {new Male("Дмитрий", 30, 4), new Female("Бориса", 28, 66)};
        Crew crew = new Crew(captain, crewMembers);

        assertEquals("Борисоводмитрий", crew.captain.getName());
        assertEquals(2, crew.members.length);
        assertEquals("Дмитрий", crew.members[0].getName());
        assertEquals("Бориса", crew.members[1].getName());
    }

    @Test
    @DisplayName("Тест сравнения империй при разной силе")
    void testCompareStrengthWhenOtherEmpireIsStronger() {
        SpaceFleet fleet1 = new SpaceFleet("1st Fleet", List.of());
        SpaceFleet fleet2 = new SpaceFleet("2nd Fleet", List.of());

        Empire weakerEmpire = new Empire("ОПД", List.of(fleet1));
        Empire strongerEmpire = new Empire("ОПИ", List.of(fleet1, fleet2));

        assertEquals("Империя ОПИ сильнее.", weakerEmpire.compareStrength(strongerEmpire));
    }

    @Test
    @DisplayName("Тест готовности корабля к миссии")
    void testSpaceshipIsReadyForMission() {
        Captain captain = new Captain("БОРИС", 45, 2333);
        Human crewMember = new Male("АФАНАСИЙ", 30, 13);
        Crew crew = new Crew(captain, new Human[]{crewMember});
        Spaceship spaceship = new Spaceship("БОРИСОФАНАСАИЙ", crew);

        assertTrue(spaceship.isReadyForMission(), "Корабль должен быть готов к миссии.");
    }

    @Test
    @DisplayName("Тест неподготовленного корабля")
    void testSpaceshipIsNotReadyForMission() {
        Spaceship spaceshipWithoutCrew = new Spaceship("АФАНАС", null);
        assertFalse(spaceshipWithoutCrew.isReadyForMission(), "Корабль без экипажа не должен быть готов к миссии.");

        Crew emptyCrew = new Crew(new Captain("БОборис", 40, 33), new Human[]{});
        Spaceship spaceshipWithEmptyCrew = new Spaceship("Пусто", emptyCrew);
        assertFalse(spaceshipWithEmptyCrew.isReadyForMission(), "Корабль с пустым экипажем не должен быть готов к миссии.");
    }

    @Test
    @DisplayName("Тест представления экипажа")
    void testIntroduceCrew() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Crew crew = new Crew(new Captain("Дмитрий Борисович", 45, 55), new Human[]{
                new Male("Д", 30, 10), new Female("Б", 28, 999)
        });

        crew.introduceCrew();
        System.setOut(System.out);

        String output = outputStream.toString();
        assertTrue(output.contains("Капитан: Дмитрий Борисович"));
        assertTrue(output.contains("Член экипажа: Д"));
        assertTrue(output.contains("Член экипажа: Б"));
    }

    @Test
    @DisplayName("Тест представления персонажа")
    void testIntroduce() {
        Human human = new Male("Афа", 30, 100);
        String introduction = human.introduce();
        assertEquals("Моё имя: Афа, возраст: 30, здоровье: 100", introduction);
    }

    @Test
    @DisplayName("Проверка вызова неизвестности для человека")
    void testChallengeUnknown() {
        Human human = new Female("Дмитро", 28, 50);
        String challenge = human.challengeUnknown();
        assertEquals("Дмитро не боится бросить вызов неизвестности", challenge);

        human = new Female("Дмитро", 28, 0);
        challenge = human.challengeUnknown();
        assertEquals("Дмитро не может бросить вызов неизвестности, слишком слаб.", challenge);
    }

    @Test
    @DisplayName("Проверка совершения героического деяния")
    void testPerformHeroicDeed() {
        Human hero = new Male("ОПД", 35, 100);

        for (int i = 0; i < 10; i++) {
            String result = hero.performHeroicDeed();
            assertTrue(
                    result.contains("совершает героическое деяние") || result.contains("Неудача"),
                    "Неожиданный результат: " + result
            );
        }

        // когда здоровье = 0
        Human weakHero = new Male("Борис", 28, 0);
        assertEquals("Борис не может совершить героическое деяние, так как слишком слаб.", weakHero.performHeroicDeed());
    }

    @Test
    @DisplayName("Проверка склонения неизменяемых существительных")
    void testDeclineImmutableNouns() {
        Human human = new Male("АДБ", 50, 10);

        assertEquals("АДБ пытается склонять, здоровье уменьшилось до: 5", human.declineImmutableNouns());
        assertEquals("АДБ пытается склонять, здоровье уменьшилось до: 0", human.declineImmutableNouns());
        assertEquals("АДБ не может склонять, так как слишком слаб.", human.declineImmutableNouns());
    }

    @Test
    @DisplayName("Проверка состояния здоровья человека")
    void testCheckHealth() {
        Human healthyHuman = new Male("Борисо", 20, 100);
        assertEquals("Борисо в хорошем состоянии, здоровье: 100", healthyHuman.checkHealth());

        Human weakHuman = new Male("Афанасио", 70, 0);
        assertEquals("Афанасио на грани смерти!", weakHuman.checkHealth());
    }

    @Test
    @DisplayName("Проверка конструктора Mission")
    void testMissionConstructor() {
        Species species = new Species("Марсиане", false);
        Planet planet = new Planet("Марс", true, species);
        Mission mission = new Mission("Исследование", planet);

        assertNotNull(mission);
    }

    @Test
    @DisplayName("Проверка конструктора Planet")
    void testPlanetConstructor() {
        Species species = new Species("Марсиане", false);
        Planet planet = new Planet("Марс", true, species);

        assertNotNull(planet);
    }

    @Test
    @DisplayName("Проверка конструктора Species")
    void testSpeciesConstructor() {
        Species species = new Species("Марсиане", false);

        assertNotNull(species);
    }

    @Test
    @DisplayName("Проверка свойств существа с Альфы Центавры")
    void testAlphaCentauriFurryCreatureProperties() {
        AlphaCentauriFurryCreature creature = new AlphaCentauriFurryCreature();

        assertNotNull(creature);
        assertEquals("Маленькое мохнатое существо с Альфы Центавры", creature.getName());
        assertTrue(creature.isFurry());
    }

    @Test
    @DisplayName("Проверка счётчика героических деяний")
    void testHeroicDeedsCount() {
        Human hero = new Male("Мохнат", 1000, 100);
        assertEquals(0, hero.getHeroicDeedsCount());

        hero.performHeroicDeed();
        hero.performHeroicDeed();
        hero.performHeroicDeed();

        assertTrue(hero.getHeroicDeedsCount() > 0, "Счётчик героических деяний должен увеличиваться");
    }
}