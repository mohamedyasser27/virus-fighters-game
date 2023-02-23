package com.mohamed.vf;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import static com.mohamed.vf.VirusFighters.PPM;
import com.mohamed.vf.screens.PlayScreen;
import java.util.Random;

public class enem extends Sprite implements avatar{
    public World world;

    public Body mbody;
    
     float n,m;
        public static Random rand= new Random();
   public float speed;
   Vector2 direction;
  public float timeSinceLastDirection =0;
   public float directionChangeFrequency= 0.75f;
   private TextureRegion stand;

public enem(World world, PlayScreen screen, int m, int n) {
    super(screen.getAtlas2().findRegion("enemy"));
            this.world=world;
            this.stand=new TextureRegion(getTexture(),0,50*0/VirusFighters.PPM,50/VirusFighters.PPM,50/VirusFighters.PPM);
            this.setBounds(0,0,50/VirusFighters.PPM/2,50/VirusFighters.PPM/2);
            this.setRegion(stand);
    this.n=n;
            this.m=m;
            speed=5f;
            this.world=world;
            
            definePlayer(m,n);
            direction = new Vector2(0,-1);
                   
}   
   
 

public void randomizeDirectionVec(){
    double bearing = rand.nextDouble()*2*Math.PI;
    direction.x=(float)Math.sin(bearing);
       direction.y=(float)Math.sin(bearing);
}
    @Override
    public void definePlayer(int n,int m) {
        BodyDef bdef=new BodyDef();
        bdef.position.set(n/PPM,m/PPM);
        bdef.type=BodyDef.BodyType.DynamicBody;
        mbody=world.createBody(bdef);
        
        FixtureDef mfdef=new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(5/PPM);
        mfdef.shape=shape;
        
        mbody.createFixture(mfdef);
    }

    public Vector2 getDirection() {
        return direction;
    }
        public void update(float dt){
    this.setPosition(this.mbody.getPosition().x-getWidth()/2,this.mbody.getPosition().y-getHeight()/2);
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Body getMbody() {
        return mbody;
    }

    public void setMbody(Body mbody) {
        this.mbody = mbody;
    }

    public float getN() {
        return n;
    }

    public void setN(float n) {
        this.n = n;
    }

    public float getM() {
        return m;
    }

    public void setM(float m) {
        this.m = m;
    }

    public static Random getRand() {
        return rand;
    }

    public static void setRand(Random rand) {
        enem.rand = rand;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getTimeSinceLastDirection() {
        return timeSinceLastDirection;
    }

    public void setTimeSinceLastDirection(float timeSinceLastDirection) {
        this.timeSinceLastDirection = timeSinceLastDirection;
    }

    public float getDirectionChangeFrequency() {
        return directionChangeFrequency;
    }

    public void setDirectionChangeFrequency(float directionChangeFrequency) {
        this.directionChangeFrequency = directionChangeFrequency;
    }

    public TextureRegion getStand() {
        return stand;
    }

    public void setStand(TextureRegion stand) {
        this.stand = stand;
    }
    
    
   

}
