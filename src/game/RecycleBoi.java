package game;

import java.awt.Color;
import java.awt.Graphics;

public class RecycleBoi extends Meeple{

	public RecycleBoi(MEEPLE_ID id, int x, int y) {
		super(id, x, y);
		init();
	}

	
	public void init() {
		w=32;
		h=32;
		yv=5;
		
	}

	@Override
	public void update() {
		y+=yv;
		
	}
	public void draw(Graphics graphics) {
		graphics.setColor(Color.YELLOW);
		graphics.fillOval(x, y, w, h);
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
