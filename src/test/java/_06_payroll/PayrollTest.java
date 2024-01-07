package _06_payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayrollTest {

    Payroll payroll = new Payroll();

    @Test
    void itShouldCalculatePaycheck() {
        //given
    	double hourlyWage = 5.0;
    	int numHours = 8;
    	double expected = 40.0;
    	
        //when
    	double actual = payroll.calculatePaycheck(hourlyWage, numHours);
        //then
    	assertEquals(expected, actual);
    }

    @Test
    void itShouldCalculateMileageReimbursement() {
        //given
        double centsPerMile = .575;
        int milesTraveled = 12;
        double expected = 6.9;
        //when
        double actual = payroll.calculateMileageReimbursement(milesTraveled);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void itShouldCreateOfferLetter() {
        //given
    	String employeeName = "Nicholas";
    	double hourlyWage = 6.9;
    	String expected = "Hello Nicholas, We are pleased to offer you an hourly wage of 6.9";
        //when
    	String actual = payroll.createOfferLetter(employeeName, hourlyWage);
        //then
    	assertEquals(expected, actual);
    }

}