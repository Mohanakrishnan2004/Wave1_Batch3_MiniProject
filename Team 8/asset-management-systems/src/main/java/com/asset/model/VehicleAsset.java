package com.asset.model;

public class VehicleAsset extends Asset {

    public VehicleAsset(String id, String name, double cost) {
        super(id, name, cost);
    }

    @Override
    public double calculateDepreciation() {
        return getCost() * 0.15;   // 15% yearly
    }
}
