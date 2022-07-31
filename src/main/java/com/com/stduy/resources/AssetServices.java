package com.com.stduy.resources;

import java.util.ArrayList;
import java.util.List;

public class AssetServices {
    private static AssetServices _instance = new AssetServices();

    public static AssetServices getInstance(){
        return _instance;
    }

    public String retrieveAsset()
    {
        return "";
    }

    public List<String> retrieveAssetList()
    {
        List<String> assetList = new ArrayList<>();
        return assetList;
    }

}

