package com.mohamed.vf.tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import static com.mohamed.vf.VirusFighters.PPM;

public class B2WorldCreator {
    private int llayer;//last layer of objects in the map
    private final int flayer=3;//first layer of objects in the map
    public int getLlayer() {
        return llayer;
    }
    public void setLlayer(int llayer) {
        this.llayer = llayer;
    }
    
    public B2WorldCreator(World world,TiledMap map,int llayer) {
        this.llayer=llayer;
        BodyDef bdef=new BodyDef();
        PolygonShape shape=new PolygonShape();
        FixtureDef fdef= new FixtureDef();
        Body body;
        for(int i=this.flayer;i<this.llayer;i++){
        
        for(MapObject object:map.getLayers().get(i).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect=((RectangleMapObject)object).getRectangle();
            bdef.type=BodyDef.BodyType.StaticBody;  
            bdef.position.set((rect.getX()+rect.getWidth()/2)/PPM,(rect.getY()+rect.getHeight()/2)/PPM);
            body=world.createBody(bdef);
            shape.setAsBox(rect.getWidth()/2/PPM, rect.getHeight()/2/PPM);
            fdef.shape=shape;
            body.createFixture(fdef);
        }}}
    }


 