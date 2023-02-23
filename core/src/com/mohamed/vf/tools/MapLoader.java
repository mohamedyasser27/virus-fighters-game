package com.mohamed.vf.tools;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import static com.mohamed.vf.VirusFighters.PPM;

public class MapLoader {
private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    public MapLoader( String mapname) {
        this.maploader = new TmxMapLoader();
        this.map =maploader.load(mapname);
         this.renderer=new OrthogonalTiledMapRenderer(map,1/PPM);
        
    }

    public TmxMapLoader getMaploader() {
        return maploader;
    }

    public void setMaploader(TmxMapLoader maploader) {
        this.maploader = maploader;
    }

    public TiledMap getMap() {
        return map;
    }

    public void setMap(TiledMap map) {
        this.map = map;
    }

    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }

    public void setRenderer(OrthogonalTiledMapRenderer renderer) {
        this.renderer = renderer;
    }
        

}
