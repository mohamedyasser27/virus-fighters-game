package com.mohamed.vf.screens;

import com.mohamed.vf.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mohamed.vf.VirusFighters;
import static com.mohamed.vf.VirusFighters.PPM;
import com.mohamed.vf.HUD;
import com.mohamed.vf.enem;
import com.mohamed.vf.tools.B2WorldCreator;
public class PlayScreen implements Screen{
    private final VirusFighters game;    
    
    private final OrthographicCamera gamecam;
    private final StretchViewport gameport;
    private HUD hud;
    
    
    private final TmxMapLoader maploader;
    private final TiledMap map;
    private final OrthogonalTiledMapRenderer renderer;
    
    private final World world;
    private final Box2DDebugRenderer b2dr;
    
    B2WorldCreator  creator;
    private final Player player; 
      
      
    public int []Layers={0,1,2,3};
    
//animation
    private TextureAtlas atlas;

    private final Array<enem>enemies;

   
    private TextureAtlas atlas2;
 
 

   
 
    public PlayScreen(VirusFighters game,int x) {
        this.atlas =new TextureAtlas("main character/main_character.atlas");
        this.atlas2=new TextureAtlas("enemy.atlas");
        this.game=game;
                
        this.hud=new HUD(game.batch,game);
        
        
        gamecam =new OrthographicCamera();
     //   gamecam.zoom=.5f;
        gameport=new StretchViewport(VirusFighters.V_WIDTH/PPM,VirusFighters.V_HEIGHT/PPM,gamecam);
        
        maploader= new TmxMapLoader();
        if(x==2)
        map =maploader.load("map2.tmx");
        else if(x==1)
        map =maploader.load("map.tmx");
        else 
        map =maploader.load("map3.tmx");
        renderer=new OrthogonalTiledMapRenderer(map,1/PPM);
        gamecam.position.set(gameport.getWorldWidth()/2,gameport.getWorldHeight()/2,0);
        world=new World(new Vector2(0,0),true);
        b2dr =new Box2DDebugRenderer();        
          creator=new B2WorldCreator(world,map,5);
                player=new Player(world,this);
                this.enemies=new Array<>();
               this.enemies.add(new enem(world,this,900,1150));
               this.enemies.add(new enem(world,this,1000,1150));
               this.enemies.add(new enem(world,this,800,1150));
               this.enemies.add(new enem(world,this,800,1000));
               this.enemies.add(new enem(world,this,900,900));
                              this.enemies.add(new enem(world,this,900,700));
               this.enemies.add(new enem(world,this,800,600));

    }
    
    
    
    @Override
    public void show() {
       
        
    }

    @Override
    public void render(float delta) {
        
       update(delta);
      Gdx.gl.glClearColor(0, 0, 0, 1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      
      
      
      
      renderer.render(Layers);
      
//      b2dr.render(world, gamecam.combined);
    

      game.batch.setProjectionMatrix(gamecam.combined);
      
      game.batch.begin();
      this.player.draw(game.batch);
      for(int i=0;i<this.enemies.size;i++)
          enemies.get(i).draw(game.batch);
      game.batch.end();
      
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

      
    }
    
    
    public void handleinput(float dt){
        
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && this.player.mbody.getLinearVelocity().x<=1){
             player.mbody.applyLinearImpulse(new Vector2(.1f, 0), player.mbody.getWorldCenter(),true);
            
            
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && this.player.mbody.getLinearVelocity().x>=-1){
             player.mbody.applyLinearImpulse(new Vector2(-.1f, 0), player.mbody.getWorldCenter(),true);
            
            
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.UP) && this.player.mbody.getLinearVelocity().y<=1){
             player.mbody.applyLinearImpulse(new Vector2(0f, .1f), player.mbody.getWorldCenter(),true);
            
            
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && this.player.mbody.getLinearVelocity().y>=-1){
             player.mbody.applyLinearImpulse(new Vector2(0f, -.1f), player.mbody.getWorldCenter(),true);
            
            
        }
        else if(this.player.mbody.getLinearVelocity().y>-1 &&this.player.mbody.getLinearVelocity().y<1
                &&this.player.mbody.getLinearVelocity().x>-1 &&this.player.mbody.getLinearVelocity().x<1
                )
            player.mbody.applyForce(new Vector2(0f, 0f), player.mbody.getWorldCenter(),true);
            
             
    
    
    }
        
       
    public void update(float dt){
        Vector2 vel= enemies.get(0).mbody.getLinearVelocity();
        handleinput(dt);
        world.step(1/60f, 6, 2);

 if(  vel.y<=0.33f){

            enemies.get(0).mbody.applyForce(new Vector2(0,1f), enemies.get(0).mbody.getWorldCenter(),true);
    enemies.get(1).mbody.applyForce(new Vector2(0,1f), enemies.get(1).mbody.getWorldCenter(),true);
        } 
        else {
    enemies.get(0).mbody.applyForce(new Vector2(0,-11f), enemies.get(0).mbody.getWorldCenter(),true);
            enemies.get(1).mbody.applyForce(new Vector2(0,-11f), enemies.get(1).mbody.getWorldCenter(),true);
        }
        player.update(dt);
      for(int i=0;i<this.enemies.size;i++)
          enemies.get(i).update(dt);
        gamecam.position.x=player.mbody.getPosition().x;
        gamecam.position.y=player.mbody.getPosition().y;
        gamecam.update();
        
        renderer.setView(gamecam);
    
    }

    
    @Override
    public void resize(int width, int height) {
        gameport.update(width, height);
    }

    @Override
    public void pause() {
  
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
       this.map.dispose();
        this.renderer.dispose();
        this.world.dispose();
        this.b2dr.dispose();
        this.atlas.dispose();
        this.atlas2.dispose();
        
    }   

    World getWorld() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public B2WorldCreator getCreator() {
        return creator;
    }

    public void setCreator(B2WorldCreator creator) {
        this.creator = creator;
    }

    public int[] getLayers() {
        return Layers;
    }

    public void setLayers(int[] Layers) {
        this.Layers = Layers;
    }
     public TextureAtlas getAtlas2() {
        return atlas2;
    }

    public void setAtlas2(TextureAtlas atlas) {
        this.atlas2 = atlas;
    }
     public TextureAtlas getAtlas() {
        return atlas;
    }

    public void setAtlas(TextureAtlas atlas) {
        this.atlas = atlas;
    }
}
