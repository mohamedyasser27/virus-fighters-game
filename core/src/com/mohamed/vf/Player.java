package com.mohamed.vf;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mohamed.vf.screens.PlayScreen;
import static com.mohamed.vf.VirusFighters.PPM;

public class Player extends Sprite implements avatar{
        public World world;
        public Body mbody;
        
        private TextureRegion stand;
        public enum State  {STANDING,RUNNING,UP,DOWN};
        public State currentstate;
        public State previoustate;
        
        private Animation<TextureRegion>running;
        
        
        private boolean directionx;//true right---left false
        
        private float statetimer;
        
        
        
        public Player(World world,PlayScreen screen){
            super(screen.getAtlas().findRegion("rpg_sprite_walk"));
            
            
            this.currentstate=State.STANDING;
            this.previoustate=State.STANDING;
            this.statetimer=0;
            this.directionx=true;
       
            
            
            //running x
            Array<TextureRegion> framesx=new Array<TextureRegion>();

            for(int i=0;i<8;i++)
                framesx.add(new TextureRegion(this.getTexture(),i*24,32*3,24,37));
            
           this.running=new<TextureRegion>Animation(0.2f,framesx);
           framesx.clear();
           
           
            
            this.world=world;
            definePlayer(500,1150);
            this.stand=new TextureRegion(getTexture(),0,32*3,24,37);
            this.setBounds(0,0,32/VirusFighters.PPM,32/VirusFighters.PPM);
            this.setRegion(stand);
        }
        @Override
        public void definePlayer(int n,int m) {
        BodyDef bdef=new BodyDef();
        bdef.position.set(n/PPM,m/PPM);
        bdef.type=BodyDef.BodyType.DynamicBody;
        mbody=world.createBody(bdef);
        
        FixtureDef mfdef=new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(6/PPM);
        mfdef.shape=shape;
        
        mbody.createFixture(mfdef);
    }
    
    
    public void update(float dt){
    this.setPosition(this.mbody.getPosition().x-getWidth()/2,this.mbody.getPosition().y-getHeight()/2);
    this.setRegion(getFrame(dt));
    }
    
    
    public TextureRegion getFrame(float dt){
        this.currentstate=this.getstate();
    
        TextureRegion region;
        switch(this.currentstate){
            
            case RUNNING:
                region=this.running.getKeyFrame(this.statetimer,true);
                
                break;
              
            case STANDING:
            default:
                region=this.stand;
                
                break;
        }
        if((this.mbody.getLinearVelocity().x<0 ||!this.directionx) &&!region.isFlipX()){
            region.flip(true, false);
            this.directionx=false;
        
        
        }
        else if((this.mbody.getLinearVelocity().x>0 ||this.directionx) &&region.isFlipX()){
            region.flip(true, false);
            this.directionx=true;
        
        
        }
        
        this.statetimer=this.currentstate==this.previoustate?this.statetimer+dt:0;
        this.previoustate=this.currentstate;
        return region;
    }
    public State getstate(){
        if(mbody.getLinearVelocity().x!=0)
            return State.RUNNING;
        
        
        else
            return State.STANDING;
    
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

    public TextureRegion getStand() {
        return stand;
    }

    public void setStand(TextureRegion stand) {
        this.stand = stand;
    }

    public State getCurrentstate() {
        return currentstate;
    }

    public void setCurrentstate(State currentstate) {
        this.currentstate = currentstate;
    }

    public State getPrevioustate() {
        return previoustate;
    }

    public void setPrevioustate(State previoustate) {
        this.previoustate = previoustate;
    }

    public Animation<TextureRegion> getRunning() {
        return running;
    }

    public void setRunning(Animation<TextureRegion> running) {
        this.running = running;
    }

    public boolean isDirectionx() {
        return directionx;
    }

    public void setDirectionx(boolean directionx) {
        this.directionx = directionx;
    }

    public float getStatetimer() {
        return statetimer;
    }

    public void setStatetimer(float statetimer) {
        this.statetimer = statetimer;
    }
    
    
}
