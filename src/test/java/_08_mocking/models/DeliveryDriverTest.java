package _08_mocking.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import _07_intro_to_mocking.models.Car;

class DeliveryDriverTest {

    DeliveryDriver deliveryDriver;
    String name;
    @Mock
    Car car;
    @Mock
    CellPhone cellPhone;
    
    void setUp() {
    	MockitoAnnotations.openMocks(this);
    	deliveryDriver = new DeliveryDriver(name, car, cellPhone);
    }

    @Test
    void itShouldWasteTime() {
        //given
    	boolean expectedTimeWaste = true;
        when(deliveryDriver.wasteTime()).thenReturn(true);

        //when
    	boolean actualTimeWaste = deliveryDriver.wasteTime();
        //then
    	assertEquals(expectedTimeWaste, actualTimeWaste);
    }

    @Test
    void itShouldRefuel() {
        //given
    	boolean expectedRefuel = true;
    	int octaneGrade = 9;
        //when
    	when(deliveryDriver.refuel(octaneGrade)).thenReturn(true);
        boolean actualRefuel = deliveryDriver.refuel(octaneGrade);
    	//then
        assertEquals(expectedRefuel, actualRefuel);
    	
    }

    @Test
    void itShouldContactCustomer() {
        //given
    	boolean expectedContact = true;
    	String phoneNumber = "8587275939";
        //when
    	when(deliveryDriver.contactCustomer(phoneNumber)).thenReturn(true);
    	boolean actualContact = deliveryDriver.contactCustomer(phoneNumber);
        //then
    	assertEquals(expectedContact, actualContact);
    }

}