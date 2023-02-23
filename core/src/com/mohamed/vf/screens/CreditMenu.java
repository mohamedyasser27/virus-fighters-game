package com.mohamed.vf.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mohamed.vf.VirusFighters;

public class CreditMenu
        implements Screen{
    private VirusFighters game;    

        
        private  Stage stage;
        private  Table table;
        private  Skin skin;
        

        private TextField name1;
        private TextField name2;
        private TextField name3;
        private TextField name4;
        private TextField name5;
        private TextField name6;
        private TextButton back;
        private Texture backgroundImage;
        

        
        
    public CreditMenu(final VirusFighters game)   
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
        this.back = new TextButton("back", this.skin);
        this.back.addListener(new ChangeListener() {
	@Override
	public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                        game.setScreen(new MenuScreen(game));
	}  
         });
                  name1=new TextField("Mohamed yasser",skin);
                  name2=new TextField("Ahmed Taha",skin);
                  name3=new TextField("Nour Eldeen",skin);
                  name4=new TextField("mohamed sayed",skin);
                  name5=new TextField("Ahmed emira",skin);
                  name6=new TextField("Ahmed hemdan",skin);
                this.table.row().pad(10, 0, 10, 0);
                this.table.add(this.name1).fillX();        
                this.table.row().pad(10, 0, 10, 0);
                this.table.add(this.name2).fillX();
                this.table.row().pad(10, 0, 10, 0);
                this.table.add(this.name3).fillX();
                this.table.row().pad(10, 0, 10, 0);
                this.table.add(this.name4).fillX();        
                this.table.row().pad(10, 0, 10, 0);
                this.table.add(this.name5).fillX();
                this.table.row().pad(10, 0, 10, 0);
                this.table.add(this.name6).width(300);
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

}   
