package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import res.ArtLoader;

public class RecycleBoi extends Meeple{

	public RecycleBoi(MEEPLE_ID id, int x, int y) {
		super(id, x, y);
		init();
	}

	
	public void init() {
		w=32;
		h=32;
		yv=5;
		rect=new Rectangle(x,y,w,h);

		
	}

	@Override
	public void update() {
		y+=yv;
		rect.x=x;
		rect.y=y;
		
	}
	public void draw(Graphics graphics) {
		if(Cycler.timer>14){
			graphics.drawImage(ArtLoader.recycle1, x, y, w, h, null);
		}
		if(Cycler.timer>7&&Cycler.timer<=14){
			graphics.drawImage(ArtLoader.recycle2, x, y, w, h, null);
		}
		if(Cycler.timer<=7){
			graphics.drawImage(ArtLoader.recycle3, x, y, w, h, null);
		}
			
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
