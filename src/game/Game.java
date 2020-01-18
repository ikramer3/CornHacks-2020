package game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game {
	
	Canvas canvas;
	JFrame frame;
	Thread thread;
	private boolean playing;

	public Game(Canvas canvas,JFrame frame,boolean playing,Thread thread,int points) {
		this.frame=frame;
		this.canvas=canvas;
		this.playing=playing;
		this.thread=thread;
	}
	public void init() {
		
	}
	public void loop() {
		while(playing) {
			update();
			draw();
			loop();
		}
	}
	public void update() {
		
	}
	public void draw() {
		if(canvas.getBufferStrategy()==null) {
			canvas.createBufferStrategy(3);
		}
		BufferStrategy bs=canvas.getBufferStrategy();
		Graphics graphics=bs.getDrawGraphics();
		
		///DRAW HERE///
		
		
		///END DRAWING HERE///
		
		bs.show();
		graphics.dispose();		
	}
	public void pause() {
		try {
			thread.sleep(1000/60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
