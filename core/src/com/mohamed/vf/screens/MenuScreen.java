package com.mohamed.vf.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mohamed.vf.VirusFighters;

public class MenuScreen implements Screen{
    private VirusFighters game;    

        
        private  Stage stage;
        private  Table table;
        private  Skin skin;
        
        private  TextButton start;
        private TextButton musics;
        private  TextButton credit;
        private  TextButton exit;        
        private Texture backgroundImage;
        

        
        
    public MenuScreen(final VirusFighters game)   
 {
        this.game=game;    
        this.backgroundImage=new Texture(Gdx.files.internal("bg.jpg"));
        
        this.stage=new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        this.table = new Table();
        this.table.setFillParent(true);
        this.table.setDebug(false);
        this.stage.addActor(table);
        
        this.skin = new Skin(Gdx.files.internal("skin/quantum-horizon-ui.json"));
        
        
        this.start = new TextButton("Start", this.skin);
        this.start.addListener(new ChangeListener() {
            
	@Override
	public void changed(ChangeListener.ChangeEvent event, Actor actor) {
            
            game.setScreen(new LevelSelect(game));
            
        }

         }
        );
        this.musics = new TextButton("music", this.skin);
        this.musics.addListener(new ChangeListener() {
            
	@Override
	public void changed(ChangeListener.ChangeEvent event, Actor actor) {
            if(game.getBgroundmusic().isPlaying()==true)
            game.getBgroundmusic().stop();
            else
            game.getBgroundmusic().play();
        }

         }
        );
        this.credit = new TextButton("Credit", this.skin);
        this.credit.addListener(new ChangeListener() {
            
	@Override
	public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                       game.setScreen(new CreditMenu(game));

        }

         }
        );
        
        this.exit = new TextButton("Exit", this.skin);
        this.exit.addListener(new ChangeListener() {
	@Override
	public void changed(ChangeListener.ChangeEvent event, Actor actor) {
		Gdx.app.exit();				
	}  
         });
        this.table.row().pad(10, 0, 10, 0);
        this.table.add(this.start).fillX().uniformX();        
        this.table.row().pad(10, 0, 10, 0);
        this.table.add(this.musics).fillX().uniformX();
        this.table.row().pad(10, 0, 10, 0);
        this.table.add(this.credit).fillX().uniformX();
        this.table.row().pad(10, 0, 10, 0);
        this.table.add(this.exit).fillX().uniformX();
    }

    
    
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {   
        this.game.batch.begin();
        this.game.batch.draw(this.backgroundImage, 0, 0,VirusFighters.V_WIDTH,VirusFighters.V_HEIGHT);
        this.game.batch.end();
 
        this.stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        this.stage.draw();
        this.stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
       
    }

    @Override
    public void resize(int width, int height) {
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
    }

    public VirusFighters getGame() {
        return game;
    }

    public void setGame(VirusFighters game) {
        this.game = game;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public TextButton getStart() {
        return start;
    }

    public void setStart(TextButton start) {
        this.start = start;
    }

    public TextButton getExit() {
        return exit;
    }

    public void setExit(TextButton exit) {
        this.exit = exit;
    }

    public Texture getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Texture backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

}   
