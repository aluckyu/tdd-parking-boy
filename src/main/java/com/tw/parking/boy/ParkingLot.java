package com.tw.parking.boy;

public class ParkingLot {
    private final int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket parking(Car car) {
        return new Ticket();
    }
}
