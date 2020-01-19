package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import main.Menu;

public class Game {
	
	Canvas canvas;
	Thread thread;
	int points;
	private boolean playing;
	Cycler c;

	public Game(Canvas canvas,boolean playing,Thread thread) {
		this.canvas=canvas;
		this.playing=playing;
		this.thread=thread;
		init();
	}
	public void init() {
		c=new Cycler();
	}
	public void update() {
		c.update();
	}
	public void draw(Graphics graphics) {
		///DRAW HERE///		
		graphics.setColor(Color.DARK_GRAY);
		graphics.fillRect(0,0,Menu.WIDTH,Menu.HEIGHT);
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
