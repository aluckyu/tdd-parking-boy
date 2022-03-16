package com.tw.parking.boy;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parking(Car car) {
        return parkingLots.stream().max(Comparator.comparingInt(ParkingLot::getCapacity))
                .map(parkingLot -> parkingLot.parking(car))
                .orElseThrow(NoCapacityException::new);
    }
}
