package com.tw.parking.boy;

import java.util.List;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;


    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parking(Car car) {
        if (parkingLots.get(0).hasCapacity()) {
            return parkingLots.get(0).parking(car);
        }

        if (parkingLots.get(1).hasCapacity()) {
            return parkingLots.get(1).parking(car);
        }
        return null;
    }
}
