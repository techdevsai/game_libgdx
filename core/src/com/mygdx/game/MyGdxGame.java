package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private TextureAtlas ballrotation;
    private Animation animate_balls;
	private float time_passed = 0;

	//SpriteBatch batch;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		ballrotation = new TextureAtlas(Gdx.files.internal("BallRotations.atlas"));
        animate_balls = new Animation(1/5f, ballrotation.getRegions());
       // img = new Texture("BEEBEE.jpg");
	}
    @Override
    public void dispose () {
        batch.dispose();
       ballrotation.dispose();
    }
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        time_passed += Gdx.graphics.getDeltaTime();
      //  batch.draw(img, 0, 0);
        //animate_balls.getKeyFrame(time_passed,true);

        batch.draw((TextureRegion) animate_balls.getKeyFrame(time_passed, true), 100, 500);
		batch.end();
	}
	

}
