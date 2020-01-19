package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import res.ArtLoader;

public class Projectile extends Meeple{

	public Projectile(MEEPLE_ID id, int x, int y,int xv) {
		super(id, x, y);
		this.xv=xv;
		init();
	}


	public void init() {
		w=16;
		h=16;	
		rect=new Rectangle(x,y,w,h);

	}

	
	public void update() {
		x+=xv;		
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
