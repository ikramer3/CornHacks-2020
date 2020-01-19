package game;

import java.awt.Graphics;
import java.awt.Rectangle;

import input.KeyWatcher;
import res.ArtLoader;

public class Player extends Meeple{
	boolean facingRight=false;
	public Player(MEEPLE_ID id,int x,int y) {
		super(id,x,y);
		init();
	}
	public void init() {
		speed=5;
		w=64;
		h=64;
		xv=0;
		yv=0;
		rect=new Rectangle(x,y,w,h);
	}
	public void update() {	
		move();
		rect.x=x;
		rect.y=y;
	}
	public void draw(Graphics graphics) {
		if(xv==0&&dCol) {
			stillDraw(graphics);
		}else if(!dCol) {
			if(!facingRight) {
				graphics.drawImage(ArtLoader.playerl2,x,y,w,h,null);
			}
			if(facingRight) {
				graphics.drawImage(ArtLoader.playerr2,x,y,w,h,null);
			}
		}else if(dCol&&xv!=0) {
			dynamicDraw(graphics);
		}

	}
	public void stillDraw(Graphics graphics) {
		if(facingRight) {
			graphics.drawImage(ArtLoader.playerr1,x,y,w,h,null);	
		}
		if(!facingRight) {
			graphics.drawImage(ArtLoader.playerl1,x,y,w,h,null);	
		}

	}
	public void dynamicDraw(Graphics graphics) {
		if(facingRight) {
			if(Cycler.timer>10) {
				graphics.drawImage(ArtLoader.playerr1,x,y,w,h,null);	
			}else {
				graphics.drawImage(ArtLoader.playerr2,x,y,w,h,null);	
			}
		}
		if(!facingRight) {
			if(Cycler.timer>10) {
				graphics.drawImage(ArtLoader.playerl1,x,y,w,h,null);	
			}else {
				graphics.drawImage(ArtLoader.playerl2,x,y,w,h,null);	
			}
			
		}
	}


	public void move() {
		if(!lCol&&KeyWatcher.leftKeyDown&&!KeyWatcher.rightKeyDown) {
			xv=-speed;
			facingRight=false;
		}
		if(!rCol&&!KeyWatcher.leftKeyDown&&KeyWatcher.rightKeyDown) {
			xv=speed;
			facingRight=true;
		}
		if(dCol) {
			if(KeyWatcher.upKeyDown) {
				yv=-18;
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
	public boolean getDir() {
		return facingRight;
	}


}
