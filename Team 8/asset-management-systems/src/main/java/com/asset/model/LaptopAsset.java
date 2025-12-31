package com.asset.model;

public class LaptopAsset extends Asset {

    public LaptopAsset(String id, String name, double cost) {
        super(id, name, cost);
    }

    @Override
    public double calculateDepreciation() {
        return getCost() * 0.20;   // 20% yearly
    }
}
