package de.telis.demo;

import java.math.BigDecimal;
import java.util.List;

public class DiscountService {
    private final DiscountStrategy strategy;

    public DiscountService(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal calculatePrice(List<Integer> books) {
        return strategy.calculateDiscountedPrice(BigDecimal.ZERO, books);
    }
}
