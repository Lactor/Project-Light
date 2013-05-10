package com.me.mygdxgame;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class MainLoop {
	
	Polygon Square;
	private SpriteBatch batch;
	
	public MainLoop(SpriteBatch batch)
	{
		this.batch = batch;
		//Initialize
		Point A = new Point(10,10);
		Point B = new Point(10,-10);
		Point C = new Point(-10,-10);
		Point D = new Point(-10,10);
		Point lista[] = {A,B,C,D};
		Square = new Polygon(4, lista);
		this.loop();
		
	}
	
	public void loop()
	{
		
	}
	
	public void dispose(){
		Square = null;
		batch = null;
	}
	
}
