package game;

import java.awt.Color;
import java.awt.Graphics;

import input.KeyWatcher;

public class Player extends Meeple{

	public Player(MEEPLE_ID id, int x, int y) {
		super(id, x, y);
		init();
	}
	public void init() {
		speed=5;
		w=64;
		h=64;
		xv=0;
		yv=0;
	}

	
	public void update() {		
		move();
	}
	public void draw(Graphics graphics) {
		graphics.setColor(Color.GREEN);
		graphics.fillRect(x, y, w, h);
	}

	
	public void move() {
		if(!lCol&&KeyWatcher.leftKeyDown&&!KeyWatcher.rightKeyDown) {
			xv=-speed;
		}
		if(!rCol&&!KeyWatcher.leftKeyDown&&KeyWatcher.rightKeyDown) {
			xv=speed;
		}
		if(dCol) {
			if(KeyWatcher.upKeyDown) {
				yv=-20;
				dCol=false;
			}
		}else {
			yv++;
		}
		if(!KeyWatcher.rightKeyDown&&!KeyWatcher.leftKeyDown) {
			xv=0;
		}
		x+=xv;
		y+=yv;
	}
	

}
