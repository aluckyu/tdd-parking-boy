package com.tw.parking.boy;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_parking_1st_parking_lot_when_parking_given_manage_two_parking_lot_both_has_capacity() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(10);
        ParkingLot secondParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Lists.newArrayList(firstParkingLot, secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        Ticket ticket = parkingBoy.parking(car);

        assertNotNull(ticket);
        assertEquals(car, firstParkingLot.takeCar(ticket));
    }

    @Test
    void should_parking_2nd_parking_lot_when_parking_given_manage_two_parking_lot_1st_his_full_2nd_has_capacity() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(0);
        ParkingLot secondParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Lists.newArrayList(firstParkingLot, secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        Ticket ticket = parkingBoy.parking(car);

        assertNotNull(ticket);
        assertEquals(car, secondParkingLot.takeCar(ticket));
    }

    @Test
    void should_return_no_capacity_when_parking_given_manage_two_parking_lot_both_has_no_capacity() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(0);
        ParkingLot secondParkingLot = new ParkingLot(0);
        List<ParkingLot> parkingLots = Lists.newArrayList(firstParkingLot, secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        assertThrows(NoCapacityException.class, () -> parkingBoy.parking(car));
    }

    @Test
    void should_take_car_successfully_when_take_car_given_valid_ticket() {
        Car parkingCar = new Car();
        List<ParkingLot> parkingLots = Lists.newArrayList(new ParkingLot(10), new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket = parkingBoy.parking(parkingCar);

        Car takingCar = parkingBoy.takeCar(ticket);

        assertNotNull(takingCar);
        assertEquals(takingCar, parkingCar);
    }

    @Test
    void should_return_invalid_ticket_when_take_car_with_invalid_ticket() {
        List<ParkingLot> parkingLots = Lists.newArrayList(new ParkingLot(10), new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket = new Ticket();

        assertThrows(InvalidTicketException.class, () -> parkingBoy.takeCar(ticket));
    }
}
