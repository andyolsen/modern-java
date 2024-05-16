package com.osl;

public abstract sealed class Vehicle permits Car, GoodsVehicle, CommercialVehicle {
    private String reg;
    private String owner;

    public Vehicle(String reg, String owner) {
        this.reg = reg;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("reg %s, owner %s", reg, owner);
    }
}

final class Car extends Vehicle {
    private int numSeats;

    public Car(String reg, String owner, int numSeats) {
        super(reg, owner);
        this.numSeats = numSeats;
    }

    @Override
    public String toString() {
        return String.format("Car with %d seats, %s",  numSeats, super.toString());
    }
}

sealed abstract class GoodsVehicle extends Vehicle permits LGV, HGV {
    private double maxWeight;

    public GoodsVehicle(String reg, String owner, int maxWeight) {
        super(reg, owner);
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return String.format("GoodsVehicle with max weight %f, %s", maxWeight, super.toString());
    }
}

final class LGV extends GoodsVehicle {
    public LGV(String reg, String owner, int maxWeight) {
        super(reg, owner, maxWeight);
    }
}

final class HGV extends GoodsVehicle {
    public HGV(String reg, String owner, int maxWeight) {
        super(reg, owner, maxWeight);
    }
}

non-sealed class CommercialVehicle extends Vehicle {
    public CommercialVehicle(String reg, String owner) {
        super(reg, owner);
    }
}



