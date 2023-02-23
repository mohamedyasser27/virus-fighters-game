
package com.mohamed.vf;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mohamed.vf.screens.CreditMenu;

public class HUD {
    public Stage stage;
    private FitViewport vp;
    
    private TextButton back;
    private Skin skin;    
    public VirusFighters game;
    public HUD(SpriteBatch sb, final VirusFighters game){
   this.game=game;
    this.vp=new FitViewport(VirusFighters.V_WIDTH,VirusFighters.V_HEIGHT,new OrthographicCamera());
    this.stage=new Stage(this.vp,sb);
        this.skin = new Skin(Gdx.files.internal("skin/quantum-horizon-ui.json"));
    Table  table=new Table();
    table.top();
    table.setFillParent(true);
    
   this.back=new TextButton("back",skin);
   this.back.addListener(new ChangeListener() {
            
	@Override
	public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                       game.setScreen(new CreditMenu(game));

        }

         }
        );
     table.add(back);
    stage.addActor(table);
    
    }
}
