package de.telis.demo;

import java.math.BigDecimal;
import java.util.List;

public interface DiscountStrategy {
    BigDecimal calculateDiscountedPrice(BigDecimal totalPrice, List<Integer> books);
}
