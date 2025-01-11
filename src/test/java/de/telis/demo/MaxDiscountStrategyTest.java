package de.telis.demo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class MaxDiscountStrategyTest {
    @Test
    void testNoDiscountWhenSingleBook() {
        DiscountStrategy mockStrategy = mock(MaxDiscountStrategy.class);
        when(mockStrategy.calculateDiscountedPrice(BigDecimal.ZERO, List.of(1, 0, 0, 0, 0))).thenReturn(BigDecimal.valueOf(8.0));

        DiscountService discountService = new DiscountService(mockStrategy);
        assertEquals(0, BigDecimal.valueOf(8.0).compareTo(discountService.calculatePrice(List.of(1, 0, 0, 0, 0))));

        verify(mockStrategy, times(1)).calculateDiscountedPrice(BigDecimal.ZERO, List.of(1, 0, 0, 0, 0));
    }

    @Test
    void testDiscountWhenTwoDifferentBooksShouldSucceed() {
        DiscountStrategy mockStrategy = mock(MaxDiscountStrategy.class);
        when(mockStrategy.calculateDiscountedPrice(BigDecimal.ZERO, List.of(1, 1, 0, 0, 0))).thenReturn(BigDecimal.valueOf(15.2));

        DiscountService discountService = new DiscountService(mockStrategy);
        assertEquals(0, BigDecimal.valueOf(15.2).compareTo(discountService.calculatePrice(List.of(1, 1, 0, 0, 0))));

        verify(mockStrategy, times(1)).calculateDiscountedPrice(BigDecimal.ZERO, List.of(1, 1, 0, 0, 0));
    }

    @Test
    void testDiscountWhenSixDifferentBooks() {
        DiscountStrategy mockStrategy = mock(MaxDiscountStrategy.class);
        when(mockStrategy.calculateDiscountedPrice(BigDecimal.ZERO, List.of(1, 1, 1, 1, 1, 1))).thenReturn(BigDecimal.valueOf(15.2));

        DiscountService discountService = new DiscountService(mockStrategy);
        assertEquals(0, BigDecimal.valueOf(15.2).compareTo(discountService.calculatePrice(List.of(1, 1, 1, 1, 1, 1))));

        verify(mockStrategy, times(1)).calculateDiscountedPrice(BigDecimal.ZERO, List.of(1, 1, 1, 1, 1, 1));
    }

    @Test
    void testMaxPossibleDiscountWhenDifferentBooksOfAllSets() {
        DiscountStrategy mockStrategy = mock(MaxDiscountStrategy.class);
        when(mockStrategy.calculateDiscountedPrice(BigDecimal.ZERO, List.of(2, 2, 2, 1, 1))).thenReturn(BigDecimal.valueOf(51.6));

        DiscountService discountService = new DiscountService(mockStrategy);
        assertEquals(0, BigDecimal.valueOf(51.6).compareTo(discountService.calculatePrice(List.of(2, 2, 2, 1, 1))));

        verify(mockStrategy, times(1)).calculateDiscountedPrice(BigDecimal.ZERO, List.of(2, 2, 2, 1, 1));
    }

    @Test
    void testExactTwoCopiesFirstThreeBooks() {
        DiscountStrategy mockStrategy = mock(MaxDiscountStrategy.class);
        when(mockStrategy.calculateDiscountedPrice(BigDecimal.ZERO, List.of(2, 2, 2, 0, 0))).thenReturn(BigDecimal.valueOf(51.6));

        DiscountService discountService = new DiscountService(mockStrategy);
        assertEquals(0, BigDecimal.valueOf(51.6).compareTo(discountService.calculatePrice(List.of(2, 2, 2, 0, 0))));

        verify(mockStrategy, times(1)).calculateDiscountedPrice(BigDecimal.ZERO, List.of(2, 2, 2, 0, 0));
    }

    @Test
    void testShouldFailWhenIncorrectValue() {
        DiscountStrategy mockStrategy = mock(MaxDiscountStrategy.class);

        // incorrect value
        when(mockStrategy.calculateDiscountedPrice(BigDecimal.ZERO, List.of(1, 0, 0, 0, 0))).thenReturn(BigDecimal.valueOf(10.0));

        DiscountService discountService = new DiscountService(mockStrategy);
        assertNotEquals(0, BigDecimal.valueOf(8.0).compareTo(discountService.calculatePrice(List.of(1, 0, 0, 0, 0))));

        verify(mockStrategy, times(1)).calculateDiscountedPrice(BigDecimal.ZERO, List.of(1, 0, 0, 0, 0));
    }

    @Test
    void testShouldFailOnZeroBooks() {
        DiscountStrategy mockStrategy = mock(MaxDiscountStrategy.class);

        when(mockStrategy.calculateDiscountedPrice(BigDecimal.ZERO, List.of(0, 0, 0, 0, 0))).thenReturn(BigDecimal.valueOf(10.0));

        DiscountService discountService = new DiscountService(mockStrategy);
        assertNotEquals(0, BigDecimal.valueOf(8.0).compareTo(discountService.calculatePrice(List.of(0, 0, 0, 0, 0))));

        verify(mockStrategy, times(1)).calculateDiscountedPrice(BigDecimal.ZERO, List.of(0, 0, 0, 0, 0));
    }

    @Test
    void testEmptyCartShouldFail() {
        DiscountStrategy mockStrategy = mock(MaxDiscountStrategy.class);
        when(mockStrategy.calculateDiscountedPrice(BigDecimal.ZERO, List.of())).thenReturn(BigDecimal.ZERO);

        DiscountService discountService = new DiscountService(mockStrategy);
        assertEquals(0, BigDecimal.ZERO.compareTo(discountService.calculatePrice(List.of())));

        verify(mockStrategy, times(1)).calculateDiscountedPrice(BigDecimal.ZERO, List.of());
    }

    @Test
    void testLargeCartShouldSucceed() {
        DiscountStrategy mockStrategy = mock(MaxDiscountStrategy.class);
        List<Integer> largeCart = Arrays.asList(10, 10, 10, 10, 10, 10, 10);
        when(mockStrategy.calculateDiscountedPrice(BigDecimal.ZERO, largeCart)).thenReturn(BigDecimal.valueOf(320.0));

        DiscountService discountService = new DiscountService(mockStrategy);
        assertEquals(0, BigDecimal.valueOf(320.0).compareTo(discountService.calculatePrice(largeCart)));

        verify(mockStrategy, times(1)).calculateDiscountedPrice(BigDecimal.ZERO, largeCart);
    }
}
