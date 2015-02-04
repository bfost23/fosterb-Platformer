package com.fosterb.platformer.model;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public TiledMap map;

    public Level(String mapPath){
        //set the map variable to our level we made
        map = new TmxMapLoader().load(mapPath);
    }

    public MapLayer getMapLayer(String layerName){
        return map.getLayers().get(layerName);
    }

    public MapObjects getLayerObjects(MapLayer mapLayer){
        return mapLayer.getObjects();
    }
}
