package com.me.mygdxgame;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


public class Polygon {
	
	int sides;
	Point points[];
	ShapeRenderer shapeRenderer;
	
	public Polygon( int sides, Point[] points)
	{
		this.points = points;
		//for(int i = 0; i<sides; i++)
			//System.out.println(points[i].x + " " + points[i].y);
		this.sides = sides;
		shapeRenderer = new ShapeRenderer(sides);
	}
	
	public void draw(SpriteBatch batch, Camera camera)
	{
		camera.update();
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(1, 0, 0, 1);
		
		//System.out.println("BEGIN DRAW");
		//for(int i = 0; i<sides; i++)
			//System.out.println(points[i].x + " " + points[i].y);
		
		for(int i = 0; i<sides-1; i++){
			 shapeRenderer.line(points[i].x, points[i].y, points[i+1].x, points[i+1].y);			 
		}
		shapeRenderer.line(points[sides-1].x, points[sides-1].y, points[0].x, points[0].y);
		shapeRenderer.end();
		//camera.update();
		
	}
}
