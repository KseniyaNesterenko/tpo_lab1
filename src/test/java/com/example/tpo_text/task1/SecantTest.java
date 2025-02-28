package com.example.tpo_text.task1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SecantTest {

    @Test
    @DisplayName("Тест sec(0) = 1")
    void testSecantZero() {
        assertEquals(BigDecimal.ONE.setScale(10, RoundingMode.HALF_UP), Secant.sec(BigDecimal.ZERO, 10).setScale(10, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Тест sec(π/4) ≈ sqrt(2)")
    void testSecantPiOver4() {
        BigDecimal expected = BigDecimal.valueOf(Math.sqrt(2));
        assertEquals(expected.setScale(10, RoundingMode.HALF_UP), Secant.sec(BigDecimal.valueOf(Math.PI / 4), 15).setScale(10, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Тест sec(0.1)")
    void testSecantSmallValue() {
        BigDecimal expected = BigDecimal.ONE.divide(BigDecimal.valueOf(Math.cos(0.1)), 10, RoundingMode.HALF_UP);
        assertEquals(expected, Secant.sec(BigDecimal.valueOf(0.1), 15).setScale(10, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Тест sec(1.5)")
    void testSecantLargeValue() {
        BigDecimal expected = BigDecimal.ONE.divide(BigDecimal.valueOf(Math.cos(1.5)), 10, RoundingMode.HALF_UP);
        assertEquals(expected, Secant.sec(BigDecimal.valueOf(1.5), 15).setScale(10, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Тест sec(π/2)")
    void testSecantUndefined() {
        assertThrows(ArithmeticException.class, () -> Secant.sec(BigDecimal.valueOf(Math.PI / 2), 10));
    }

    @Test
    @DisplayName("Тест sec(-0.5)")
    void testSecantNegativeValue() {
        BigDecimal expected = BigDecimal.ONE.divide(BigDecimal.valueOf(Math.cos(-0.5)), 10, RoundingMode.HALF_UP);
        assertEquals(expected, Secant.sec(BigDecimal.valueOf(-0.5), 15).setScale(10, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Тест sec(π/3)")
    void testSecantPiOver3() {
        BigDecimal expected = BigDecimal.ONE.divide(BigDecimal.valueOf(Math.cos(Math.PI / 3)), 10, RoundingMode.HALF_UP);
        assertEquals(expected, Secant.sec(BigDecimal.valueOf(Math.PI / 3), 15).setScale(10, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Тест sec(π/6)")
    void testSecantPiOver6() {
        BigDecimal expected = BigDecimal.ONE.divide(BigDecimal.valueOf(Math.cos(Math.PI / 6)), 10, RoundingMode.HALF_UP);
        assertEquals(expected, Secant.sec(BigDecimal.valueOf(Math.PI / 6), 15).setScale(10, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Тест sec(π) = -1")
    void testSecantPi() {
        assertEquals(BigDecimal.valueOf(-1).setScale(10, RoundingMode.HALF_UP),
                Secant.sec(BigDecimal.valueOf(Math.PI), 15).setScale(10, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Тест sec(2π) = 1")
    void testSecantTwoPi() {
        BigDecimal expected = BigDecimal.ONE.setScale(10, RoundingMode.HALF_UP);
        BigDecimal result = Secant.sec(BigDecimal.valueOf(2 * Math.PI), 20).setScale(10, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Тест sec(-π/2)")
    void testSecantUndefinedNegativePiOver2() {
        assertThrows(ArithmeticException.class, () -> Secant.sec(BigDecimal.valueOf(-Math.PI / 2), 10));
    }

}
