package com.asset.service;

import java.util.*;
import com.asset.model.*;

public class AssetService {

	List<Asset> assets = new ArrayList<Asset>();


    public void registerAsset(Asset asset) {
        assets.add(asset);
        System.out.println("Registered Asset: " + asset);
    }

    public Asset findAsset(String id) {
        for (Asset a : assets) {
            if (a.getAssetId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public void showAssets() {
        System.out.println("\nAvailable Assets:");
        for (Asset a : assets) {
            System.out.println(a);
        }

    }

	private void println(Asset asset1) {
	}
}
