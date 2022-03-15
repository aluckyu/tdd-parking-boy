package com.tw.parking.boy;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {
    @Test
    void should_parking_1st_parking_lot_when_parking_given_1st_has_3_empties_and_2nd_got_2_empties() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(2);
        List<ParkingLot> parkingLots = Lists.newArrayList(firstParkingLot, secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        Ticket ticket = smartParkingBoy.parking(car);

        assertNotNull(ticket);
        assertEquals(car, firstParkingLot.takeCar(ticket));
    }

    @Test
    void should_parking_2st_parking_lot_when_parking_given_1st_has_2_empties_and_2nd_got_3_empties() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(3);
        List<ParkingLot> parkingLots = Lists.newArrayList(firstParkingLot, secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        Ticket ticket = smartParkingBoy.parking(car);

        assertNotNull(ticket);
        assertEquals(car, secondParkingLot.takeCar(ticket));
    }

    @Test
    void should_parking_1st_parking_lot_when_parking_given_both_2_parking_lots_get_2_empties() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        List<ParkingLot> parkingLots = Lists.newArrayList(firstParkingLot, secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        Ticket ticket = smartParkingBoy.parking(car);

        assertNotNull(ticket);
        assertEquals(car, firstParkingLot.takeCar(ticket));
    }

    @Test
    void should_take_car_successfully_when_take_car_given_valid_ticket() {
        Car parkingCar = new Car();
        List<ParkingLot> parkingLots = Lists.newArrayList(new ParkingLot(10), new ParkingLot(10));
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        Ticket ticket = parkingBoy.parking(parkingCar);

        Car takingCar = parkingBoy.takeCar(ticket);

        assertNotNull(takingCar);
        assertEquals(takingCar, parkingCar);
    }

    @Test
    void should_take_car_failed_when_take_car_given_an_invalid_ticket() {
        Car parkingCar = new Car();
        List<ParkingLot> parkingLots = Lists.newArrayList(new ParkingLot(10), new ParkingLot(10));
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        parkingBoy.parking(parkingCar);

        Ticket invalidTicket = new Ticket();

        assertThrows(InvalidTicketException.class, () -> parkingBoy.takeCar(invalidTicket));
    }
}
