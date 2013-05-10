package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	MainLoop main;
	Polygon Square;
	Polygon Trig;
	Light luz;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(w, h);
		batch = new SpriteBatch();
				
		Point A = new Point(10,10);
		Point B = new Point(10,-10);
		Point C = new Point(-10,-10);
		Point D = new Point(-10,10);
		Point E = new Point(20,20);
		Point R = new Point(30,-20);
		Point lista[] = {A,B,C,D};
		Square = new Polygon(4, lista);
		Point lista2[] = {D,E,R};
		Trig = new Polygon(3, lista2);
		luz = new Light(new Point(20,20), 50);
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		Square = null;
		Trig = null;
	}

	@Override
	public void render() {	
		
			batch.begin();
			batch.setProjectionMatrix(camera.combined);
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			//System.out.println("ASDASDAS");
			Square.draw(batch, camera);
			Trig.draw(batch, camera);
			luz.draw_light(batch, camera);
			batch.end();
		
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
}
