package com.capgemini.junit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;


class OrderServiceTest
{
	OrderService orderService = new OrderService();

    @ParameterizedTest
    @EnumSource(OrderStatus.class)
    void canCancelTest(OrderStatus status)
    {
        boolean result = orderService.canCancel(status);

        if (status == OrderStatus.NEW)
        {
            assertTrue(result, "NEW status should be cancellable");
        }
        else
        {
            assertFalse(result, status + " should NOT be cancellable");
        }
    }
}