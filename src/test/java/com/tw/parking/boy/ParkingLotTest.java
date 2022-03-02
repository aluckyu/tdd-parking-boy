package com.tw.parking.boy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_parking_given_parking_lot_has_available_capacity() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(10);

        Ticket ticket = parkingLot.parking(car);

        assertNotNull(ticket);
    }

    @Test
    void should_return_no_capacity_when_parking_boy_parking_given_parking_lot_has_no_available_capacity() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(0);

        assertThrows(NoCapacityException.class, () -> parkingLot.parking(car));
    }

    @Test
    void should_success_when_take_car_given_valid_ticket(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = parkingLot.parking(car);

        Car takingCar = parkingLot.takeCar(ticket);

        assertNotNull(takingCar);
        assertEquals(car, takingCar);
    }
}
