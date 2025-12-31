package com.asset.model;

import java.time.LocalDate;

public class Allocation {

    private String employeeName;
    private Asset asset;
    private LocalDate allocationDate;

    public Allocation(String employeeName, Asset asset) {
        this.employeeName = employeeName;
        this.asset = asset;
        this.allocationDate = LocalDate.now();
        asset.allocate();
    }

    public void returnAsset() {
        asset.release();
    }

    @Override
    public String toString() {
        return asset.getName() + " allocated to " + employeeName +
                " on " + allocationDate;
    }
}
