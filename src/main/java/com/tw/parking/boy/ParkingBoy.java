package com.tw.parking.boy;

import java.util.List;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;


    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parking(Car car) {
        return parkingLots.stream().filter(ParkingLot::hasCapacity).findFirst()
                .map(parkingLot -> parkingLot.parking(car))
                .orElseThrow(NoCapacityException::new);
    }
}
