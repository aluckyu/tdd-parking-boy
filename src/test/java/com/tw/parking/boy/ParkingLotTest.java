package com.tw.parking.boy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_parking_given_parking_lot_has_available_capacity() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(10);

        Ticket ticket = parkingLot.parking(car);

        assertNotNull(ticket);
    }
}
