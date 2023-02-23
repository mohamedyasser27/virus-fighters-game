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

public class LevelSelect implements Screen{
    private VirusFighters game;    

        
        private  Stage stage;
        private  Table table;
        private  Skin skin;
        
        private  TextButton level1;
        private  TextButton level2;
        private TextButton level3;
        private TextButton back;
        
        private Texture backgroundImage;
        

        
        
    public LevelSelect(final VirusFighters game)   
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
        
        
        this.level1 = new TextButton("level 1", this.skin);
        this.level1.addListener(new ChangeListener() {
            
	@Override
	public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                        game.setScreen(new PlayScreen(game,1));

            
        }

         }
        );
        
        this.level2 = new TextButton("Level 2", this.skin);
        this.level2.addListener(new ChangeListener() {
            
	@Override
	public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                                    game.setScreen(new PlayScreen(game,2));

        }

         }
        );
        
        this.level3 = new TextButton("level 3", this.skin);
        this.level3.addListener(new ChangeListener() {
	@Override
	public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                        game.setScreen(new PlayScreen(game,3));
	}  
         });
        this.back = new TextButton("back", this.skin);
        this.back.addListener(new ChangeListener() {
	@Override
	public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                        game.setScreen(new MenuScreen(game));
	}  
         });
        this.table.row().pad(10, 0, 10, 0);
        this.table.add(this.level1).fillX().uniformX();        
        this.table.row().pad(10, 0, 10, 0);
        this.table.add(this.level2).fillX().uniformX();
        this.table.row().pad(10, 0, 10, 0);
        this.table.add(this.level3).fillX().uniformX();
        this.table.row().pad(10, 0, 10, 0);
        this.table.add(this.back).fillX().uniformX();
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

    

    public Texture getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Texture backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public TextButton getLevel1() {
        return level1;
    }

    public void setLevel1(TextButton level1) {
        this.level1 = level1;
    }

    public TextButton getLevel2() {
        return level2;
    }

    public void setLevel2(TextButton level2) {
        this.level2 = level2;
    }

    public TextButton getLevel3() {
        return level3;
    }

    public void setLevel3(TextButton level3) {
        this.level3 = level3;
    }

}   
