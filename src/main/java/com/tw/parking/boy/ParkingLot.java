package com.tw.parking.boy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int capacity;
    private final List<Car> cars = new ArrayList<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket parking(Car car) {
        if (cars.size() >= capacity) {
            throw new NoCapacityException();
        }

        cars.add(car);
        return new Ticket();
    }

    public Car takeCar(Ticket ticket) {
        return cars.get(0);
    }
}
