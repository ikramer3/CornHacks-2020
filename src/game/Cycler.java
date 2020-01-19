package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import main.APP_STATE;
import main.Menu;

public class Cycler {
	

	public static int timer=0;
	public int enemyTimer=0;
	int groundHeight=550;
	
	Random r;
	ArrayList<Meeple> meeples=new ArrayList<>();
	
	public Cycler() {
		r=new Random();
		addMeeple(MEEPLE_ID.LIZZIE,20,20);
		

	}
	public void update() {
		for(Meeple m:meeples) {
			m.update();
		}
		collision();
		timer();
		spawn();
	}
	public void timer() {
		enemyTimer++;
		if(timer==0) {
			timer=20;
		}else {
			timer--;
		}
	}
	public void spawn() {
		if(enemyTimer%200==0) {
			addMeeple(MEEPLE_ID.FAST_TRASH,r.nextInt(Menu.WIDTH-64),50);
		}
		if(enemyTimer%600==50) {
			addMeeple(MEEPLE_ID.RECYCLE_NINJA_STAR,r.nextInt(Menu.WIDTH-64),50);
		}
	}
	public void collision() {
		for(Meeple m:meeples) {
			if(m.getId()==MEEPLE_ID.LIZZIE) {
				lizzieCollision(m);
			}
			if(m.getId()==MEEPLE_ID.FAST_TRASH) {
				enemyCollision(m);
			}
		}
	}
	public void lizzieCollision(Meeple m) {
		if(m.getY()+m.getYv()+m.getH()>groundHeight) {
			m.setdCol(true);
			m.setYv(0);
		}else {
			m.setdCol(false);
		}
		if(m.getX()+m.getXv()<0) {
			m.setlCol(true);
			m.setXv(1);
		}else {
			m.setlCol(false);
		}
		if(m.getX()+m.getW()+m.getXv()>Menu.WIDTH) {
			m.setrCol(true);
			m.setXv(-1);
		}else {
			m.setrCol(false);
		}
		for(Meeple m2:meeples) {
			if(m2.getId()==MEEPLE_ID.FAST_TRASH) {
				if(collideCheck(m,m2)) {
					Menu.appState=APP_STATE.MAIN_MENU;
				}
			}
		}
	}
	public void enemyCollision(Meeple m){
		if(m.getX()+m.getXv()<0) {
			m.setXv(m.getSpeed());
		}
		if(m.getX()+m.getW()+m.getXv()>Menu.WIDTH) {
			m.setXv(-m.getSpeed());
		}
		if(m.getY()+m.getYv()+m.getH()>groundHeight&&!m.isdCol()) {
			m.setYv(0);
			m.setdCol(true);
			m.setXv(m.getSpeed());
		}
	}
	public void draw(Graphics graphics) {
		for(Meeple m:meeples) {
			m.draw(graphics);
		}
	}
	public boolean twoObjectsTouching(Meeple m1,Meeple m2) {
		if(m1.getX()>m2.getX()&&m1.getX()<m2.getX()+m2.getW()) {
			if(m1.getY()>m2.getY()&&m1.getY()<m2.getY()+m2.getH()) {
				return true;
			}
			if(m1.getY()+m1.getH()>m2.getY()&&m1.getY()+m1.getH()<m2.getY()+m2.getH()) {
				return true;
			}
		}
		if(m1.getX()+m1.getW()>m2.getX()&&m1.getX()+m1.getW()<m2.getX()+m2.getW()) {
			if(m1.getY()>m2.getY()&&m1.getY()<m2.getY()+m2.getH()) {
				return true;
			}
			if(m1.getY()+m1.getH()>m2.getY()&&m1.getY()+m1.getH()<m2.getY()+m2.getH()) {
				return true;
			}
		}
		return false;

	}
	public boolean collideCheck(Meeple m1,Meeple m2) {
		if(twoObjectsTouching(m1,m2)||twoObjectsTouching(m2,m2)) {
			return true;
		}
		return false;
	}
	public void addMeeple(MEEPLE_ID id,int x,int y) {
		Meeple m=null;
		if(id==MEEPLE_ID.LIZZIE) {
			m=new Player(id,x,y);
		}
		if(id==MEEPLE_ID.FAST_TRASH) {
			m=new Baddie1(id,x,y);
		}
		if(id==MEEPLE_ID.RECYCLE_NINJA_STAR) {
			m=new RecycleBoi(id,x,y);
		}
		meeples.add(m);
				
	}
}
