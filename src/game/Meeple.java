package game;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Meeple{
	///FIELDS///
	protected int x,y,w,h,xv,yv,speed;
	protected Rectangle rect;
	protected boolean lCol,rCol,uCol,dCol;
	protected MEEPLE_ID id;

	public Meeple(MEEPLE_ID id, int x, int y) {
		this.id=id;
		this.x=x;
		this.y=y;
		lCol=false;
		rCol=false;
		uCol=false;
		dCol=false;
	}

	public abstract void init();

	public abstract void update();

	public abstract void draw(Graphics graphics);

	public abstract void move();

	protected int getXv() {
		return xv;
	}
	protected void setXv(int xv) {
		this.xv = xv;
	}
	protected int getYv() {
		return yv;
	}
	protected void setYv(int yv) {
		this.yv = yv;
	}

	protected boolean islCol() {
		return lCol;
	}

	protected void setlCol(boolean lCol) {
		this.lCol = lCol;
	}

	protected boolean isrCol() {
		return rCol;
	}

	protected void setrCol(boolean rCol) {
		this.rCol = rCol;
	}

	protected boolean isuCol() {
		return uCol;
	}

	protected void setuCol(boolean uCol) {
		this.uCol = uCol;
	}

	protected boolean isdCol() {
		return dCol;
	}

	protected void setdCol(boolean dCol) {
		this.dCol = dCol;
	}
	protected MEEPLE_ID getId() {
		return id;
	}
	protected void setId(MEEPLE_ID id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Rectangle getRect() {
		return rect;
	}
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}


}
