package com.tw.parking.boy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParkingLot {
    private final int capacity;
    private final Map<Ticket, Car> ticketCarMap = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket parking(Car car) {
        if (!hasCapacity()) {
            throw new NoCapacityException();
        }

        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }

    public Car takeCar(Ticket ticket) {
        if (Objects.isNull(ticketCarMap.get(ticket))) {
            throw new InvalidTicketException();
        }

        return ticketCarMap.remove(ticket);
    }

    public boolean hasCapacity() {
        return ticketCarMap.size() < capacity;
    }

    public boolean hasCar(Ticket ticket) {
        return ticketCarMap.containsKey(ticket);
    }
}
