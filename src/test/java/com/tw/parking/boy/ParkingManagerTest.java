package com.tw.parking.boy;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingManagerTest {
    @Test
    void should_parking_1st_lot_given_2_parking_lots_when_both_parking_lot_have_empties() {
        ParkingLot firstParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Lists.list(firstParkingLot, new ParkingLot(10));
        ParkingManager parkingManager = new ParkingManager(Lists.emptyList(), parkingLots);

        Car car = new Car();

        Ticket ticket = parkingManager.parking(car);

        assertNotNull(ticket);
        assertEquals(car, firstParkingLot.takeCar(ticket));
    }

    @Test
    void should_parking_2nd_lot_given_2_parking_lots_when_2nd_parking_lot_has_empties() {
        ParkingLot secondParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Lists.list(new ParkingLot(0), secondParkingLot);
        ParkingManager parkingManager = new ParkingManager(Lists.emptyList(), parkingLots);

        Car car = new Car();

        Ticket ticket = parkingManager.parking(car);

        assertNotNull(ticket);
        assertEquals(car, secondParkingLot.takeCar(ticket));
    }

    @Test
    void should_parking_failed_given_2_parking_lots_when_both_are_full() {
        List<ParkingLot> parkingLots = Lists.list(new ParkingLot(0), new ParkingLot(0));
        ParkingManager parkingManager = new ParkingManager(Lists.emptyList(), parkingLots);
        Car car = new Car();

        assertThrows(NoCapacityException.class, () -> parkingManager.parking(car));
    }

    @Test
    void should_1st_parking_boy_park_success_given_2_parking_boys_when_both_parking_boys_have_empties() {
        SmartParkingBoy firstParkingBoy = new SmartParkingBoy(Lists.list(new ParkingLot(10), new ParkingLot(10)));
        ParkingBoy secondParkingBoy = new ParkingBoy(Lists.list(new ParkingLot(10), new ParkingLot(10)));
        ParkingManager parkingManager = new ParkingManager(Lists.list(firstParkingBoy, secondParkingBoy), Lists.emptyList());
        Car car = new Car();

        Ticket ticket = parkingManager.parking(car);

        assertNotNull(ticket);
        assertEquals(car, firstParkingBoy.takeCar(ticket));
    }

    @Test
    void should_2st_parking_boy_park_success_given_2_parking_boys_when_both_parking_boys_have_empties() {
        SmartParkingBoy firstParkingBoy = new SmartParkingBoy(Lists.list(new ParkingLot(0), new ParkingLot(0)));
        ParkingBoy secondParkingBoy = new ParkingBoy(Lists.list(new ParkingLot(10), new ParkingLot(10)));
        ParkingManager parkingManager = new ParkingManager(Lists.list(firstParkingBoy, secondParkingBoy), Lists.emptyList());
        Car car = new Car();

        Ticket ticket = parkingManager.parking(car);

        assertNotNull(ticket);
        assertEquals(car, secondParkingBoy.takeCar(ticket));
    }

    @Test
    void should_park_failed_given_2_parking_boys_when_both_parking_boys_have_no_empties() {
        SmartParkingBoy firstParkingBoy = new SmartParkingBoy(Lists.list(new ParkingLot(0), new ParkingLot(0)));
        ParkingBoy secondParkingBoy = new ParkingBoy(Lists.list(new ParkingLot(0), new ParkingLot(0)));
        ParkingManager parkingManager = new ParkingManager(Lists.list(firstParkingBoy, secondParkingBoy), Lists.emptyList());
        Car car = new Car();

        assertThrows(NoCapacityException.class, () -> parkingManager.parking(car));
    }

    @Test
    void should_park_in_own_managed_parking_lot_success_given_1_parking_boy_and_1_parking_lot_when_both_parking_boys_have_empties() {
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Lists.list(new ParkingLot(10), new ParkingLot(10)));
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingManager parkingManager = new ParkingManager(Lists.list(parkingBoy), Lists.list(parkingLot));
        Car car = new Car();

        Ticket ticket = parkingManager.parking(car);

        assertNotNull(ticket);
        assertEquals(car, parkingLot.takeCar(ticket));
    }

    @Test
    void should_parking_boy_park_success_given_1_parking_boy_and_1_parking_lot_when_own_managed_parking_lot_is_full_but_parking_boy_have_empties() {
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Lists.list(new ParkingLot(10), new ParkingLot(10)));
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingManager parkingManager = new ParkingManager(Lists.list(parkingBoy), Lists.list(parkingLot));
        Car car = new Car();

        Ticket ticket = parkingManager.parking(car);

        assertNotNull(ticket);
        assertEquals(car, parkingBoy.takeCar(ticket));
    }

    @Test
    void should_park_fail_given_1_parking_boy_and_1_parking_lot_when_both_have_no_empties() {
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Lists.list(new ParkingLot(0), new ParkingLot(0)));
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingManager parkingManager = new ParkingManager(Lists.list(parkingBoy), Lists.list(parkingLot));
        Car car = new Car();

        assertThrows(NoCapacityException.class, () -> parkingManager.parking(car));
    }

    @Test
    void should_take_car_success_when_take_car_given_valid_ticket() {
        List<ParkingLot> parkingLots = Lists.list(new ParkingLot(10), new ParkingLot(10));
        ParkingManager parkingManager = new ParkingManager(Lists.emptyList(), parkingLots);
        Car parkingCar = new Car();
        Ticket ticket = parkingManager.parking(parkingCar);

        Car takingCar = parkingManager.takeCar(ticket);

        assertNotNull(takingCar);
        assertEquals(takingCar, parkingCar);
    }

    @Test
    void should_take_car_failed_when_take_car_given_an_invalid_ticket() {
        ParkingLot firstParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Lists.list(firstParkingLot, new ParkingLot(10));
        ParkingManager parkingManager = new ParkingManager(Lists.emptyList(), parkingLots);
        Car car = new Car();
        parkingManager.parking(car);

        Ticket invalidTicket = new Ticket();

        assertThrows(InvalidTicketException.class, () -> parkingManager.takeCar(invalidTicket));
    }

}
