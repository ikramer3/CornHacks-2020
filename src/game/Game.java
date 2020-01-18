package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Game {
	
	Canvas canvas;
	Thread thread;
	int points;
	private boolean playing;
	Cycler c=new Cycler();

	public Game(Canvas canvas,boolean playing,Thread thread) {
		
		this.canvas=canvas;
		this.playing=playing;
		this.thread=thread;
	}
	public void init() {
		
	}
	public void update() {
		c.update();
	}
	public void draw(Graphics graphics) {
		
		
		///DRAW HERE///		
		graphics.setColor(Color.RED);
		graphics.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
		c.draw(graphics);
		///END DRAWING HERE///	
	}
	public void pause() {
		try {
			thread.sleep(1000/60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
