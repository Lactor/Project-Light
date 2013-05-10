package com.me.mygdxgame;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Light {
	
	int DEFINITION = 20;

	Point pos;
	float radii;
	Point[] limits;
	
	ShapeRenderer shapeRenderer;
	
	
	public Light (Point pos, float radii){
		this.radii = radii;
		this.pos = pos;
		limits = new Point[DEFINITION];
		shapeRenderer = new ShapeRenderer(DEFINITION+5);
		this.GenerateLight();
	}
	
	private void GenerateLight(){
		for(int i = 0; i<DEFINITION; i++){
			limits[i] = new Point();
			limits[i].x = (float) (Math.cos(2*Math.PI/DEFINITION * i) * radii) + pos.x;
			limits[i].y = (float) (Math.sin(2*Math.PI/DEFINITION * i) * radii) + pos.y;
		}
	}
	
	public void draw_light(SpriteBatch batch, Camera camera){
		
		camera.update();
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(1,1, 0, 1);
		
		//System.out.println("BEGIN DRAW");
		//for(int i = 0; i<sides; i++)
			//System.out.println(limits[i].x + " " + limits[i].y);
		
		for(int i = 0; i<DEFINITION-1; i++){
			 shapeRenderer.triangle(pos.x, pos.y, limits[i].x, limits[i].y, limits[i+1].x, limits[i+1].y);			 
		}
		shapeRenderer.triangle(pos.x, pos.y, limits[DEFINITION-1].x, limits[DEFINITION-1].y, limits[0].x, limits[0].y);
		shapeRenderer.end();
		
	}
	
}
