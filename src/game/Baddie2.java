package game;

import java.awt.Graphics;
import java.awt.Rectangle;

import res.ArtLoader;

public class Baddie2 extends Meeple{
	
	public Baddie2(MEEPLE_ID id, int x, int y) {
		super(id, x, y);
		init();
	}

	public void init() {
		speed = 1;
		yv=10;
		w=64;
		h=64;
		xv=0;
		y+=yv;
		rect=new Rectangle(x,y,w,h);

		
	}
	public void update() {
		x+=xv;		
		y+=yv;
		rect.x=x;
		rect.y=y;
	}

	@Override
	public void draw(Graphics graphics) {
		if(Cycler.timer>10) {
			graphics.drawImage(ArtLoader.m21,x,y,w,h,null);	
		}else {
			graphics.drawImage(ArtLoader.m22,x,y,w,h,null);	
		}		
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
}
