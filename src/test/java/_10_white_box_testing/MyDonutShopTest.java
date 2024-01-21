package _10_white_box_testing;

import _09_intro_to_white_box_testing.models.DeliveryService;
import _09_intro_to_white_box_testing.models.Order;
import _10_white_box_testing.models.BakeryService;
import _10_white_box_testing.models.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MyDonutShopTest {

    MyDonutShop myDonutShop;
    BakeryService bakeryService;

    @BeforeEach
    void setUp() {
    	MockitoAnnotations.openMocks(this);
    }

    @Test
    void itShouldTakeDeliveryOrder() throws Exception {
        //given
    	Order order = new Order("CUSTOMER_NAME", "CUSTOMER_PHONE_NUMBER", 1, 5.00, "CREDIT_CARD_NUMBER", true);
        //when
        //then
    	assertDoesNotThrow(()->myDonutShop.takeOrder(order));
    }

    @Test
    void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() {
        //given
    	Order order = new Order("CUSTOMER_NAME", "CUSTOMER_PHONE_NUMBER", 1, 5.00, "CREDIT_CARD_NUMBER", true);
        //when
    	bakeryService.setDonutsRemaining(0);
        //then
        Throwable exceptionThrown = assertThrows(Exception.class, () -> myDonutShop.takeOrder(order));
        assertEquals(exceptionThrown.getMessage(), "Sorry we don't have enough donuts to fulfill the order");
    }

    @Test
    void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException(){
        //given
    	Order order = new Order("CUSTOMER_NAME", "CUSTOMER_PHONE_NUMBER", 1, 5.00, "CREDIT_CARD_NUMBER", true);
        //when
    	myDonutShop.openForBusiness = false;
        //then
        Throwable exceptionThrown = assertThrows(Exception.class, () -> myDonutShop.takeOrder(order));
        assertEquals(exceptionThrown.getMessage(), "Sorry we are not open for business right now");
    }

}