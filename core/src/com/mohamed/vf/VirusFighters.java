package com.mohamed.vf;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mohamed.vf.screens.LevelSelect;
import com.mohamed.vf.screens.MenuScreen;
import com.mohamed.vf.screens.PlayScreen;

public class VirusFighters extends Game {
	public SpriteBatch batch;
	public static final int V_WIDTH=720;
	public static final int V_HEIGHT=500;
	public static final float PPM=100;
        private MenuScreen menuscreen;
        private PlayScreen playscreen;
        private LevelSelect levels;

        
            private Music bgroundmusic;

        
        public void changed(int screen){
            
            menuscreen=new MenuScreen(this);
            this.setScreen(menuscreen);

        }
        
	@Override
	public void create () {
            bgroundmusic=Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        bgroundmusic.setLooping(true);
        bgroundmusic.play();
		batch = new SpriteBatch();
                changed(0);
		
	}

	@Override
	public void render () {
            super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

    public MenuScreen getMenuscreen() {
        return menuscreen;
    }

    public void setMenuscreen(MenuScreen menuscreen) {
        this.menuscreen = menuscreen;
    }


    public PlayScreen getPlayscreen() {
        if(this.playscreen==null)  
        this.playscreen=new PlayScreen(this,1);
        return playscreen;
    }

    public void setPlayscreen(PlayScreen playscreen) {
        this.playscreen = playscreen;
    }

    public Music getBgroundmusic() {
        return bgroundmusic;
    }

    public void setBgroundmusic(Music bgroundmusic) {
        this.bgroundmusic = bgroundmusic;
    }

    public LevelSelect getLevels() {
        return levels;
    }

    public void setLevels(LevelSelect levels) {
        this.levels = levels;
    }
        
        
}
