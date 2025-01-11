package de.telis.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaxDiscountStrategy implements DiscountStrategy {
    private BigDecimal BOOK_PRICE;
    private static final Map<Integer, Double> DISCOUNTS = Map.of(
            1, 0.0,
            2, 0.05,
            3, 0.10,
            4, 0.20,
            5, 0.25
    );

    public MaxDiscountStrategy(BigDecimal bookPrice) {
        this.BOOK_PRICE = bookPrice;
    }

    @Override
    public BigDecimal calculateDiscountedPrice(BigDecimal totalPrice, List<Integer> books) {
        // same fixed price for all sets -> no need to calc percentage individually
        // totalPrice += uniqueBooks * BOOK_PRICE * (1 - discount);
        List<Integer> counts = new ArrayList<>(books);
        counts.removeIf(count -> count == 0);

        while (!counts.isEmpty()) {
            int uniqueBooks = counts.size();
            BigDecimal discount = BigDecimal.valueOf(DISCOUNTS.get(uniqueBooks));
            totalPrice = totalPrice.add(
                    BOOK_PRICE.multiply(BigDecimal.valueOf(uniqueBooks)).multiply(BigDecimal.ONE.subtract(discount))
            );

            // decrease for each unique book used in the set
            for (int i = 0; i < counts.size(); i++) {
                counts.set(i, counts.get(i) - 1);
            }
            counts.removeIf(count -> count == 0);
        }
        return totalPrice;
    }
}
