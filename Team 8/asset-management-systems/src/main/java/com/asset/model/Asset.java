package com.asset.model;

public abstract class Asset {

    private String assetId;
    private String name;
    private double cost;
    private boolean allocated;

    public Asset(String assetId, String name, double cost) {
        this.assetId = assetId;
        this.name = name;
        this.cost = cost;
        this.allocated = false;
    }

    public String getAssetId() { return assetId; }
    public String getName() { return name; }
    public double getCost() { return cost; }
    public boolean isAllocated() { return allocated; }

    public void allocate() { allocated = true; }
    public void release() { allocated = false; }

    // POLYMORPHISM
    public abstract double calculateDepreciation();

    @Override
    public String toString() {
        return assetId + " - " + name + " | Cost = Rs." + cost;
    }
}
