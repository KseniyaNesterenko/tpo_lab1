package com.example.tpo_text.task1;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Secant {
    public static BigDecimal sec(BigDecimal x, int terms) {
        if (x.remainder(BigDecimal.valueOf(Math.PI / 2)).compareTo(BigDecimal.ZERO) == 0 && x.divide(BigDecimal.valueOf(Math.PI / 2)).remainder(BigDecimal.valueOf(2)).abs().compareTo(BigDecimal.ONE) == 0) {
            throw new ArithmeticException("sec(x) не определен для x = (2k+1) * π/2");
        }

        BigDecimal cos = BigDecimal.ZERO;
        for (int n = 0; n < terms; n++) {
            BigDecimal term = BigDecimal.valueOf(Math.pow(-1, n))
                    .multiply(x.pow(2 * n))
                    .divide(factorial(2 * n), 20, RoundingMode.HALF_UP);
            cos = cos.add(term);
        }
        return BigDecimal.ONE.divide(cos, 20, RoundingMode.HALF_UP);
    }

    private static BigDecimal factorial(int n) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }
}
