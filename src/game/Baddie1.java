package game;

import java.awt.Color;
import java.awt.Graphics;

public class Baddie1 extends Meeple{

	public Baddie1(MEEPLE_ID id, int x, int y) {
		super(id, x, y);
		init();
	}

	public void init() {
		speed = 2;
		yv=1;
		w=64;
		h=64;
		xv=0;
		y+=yv;
		
	}
	public void update() {
		x+=xv;		
		y+=yv;
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(x,y,w,h);
		
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
