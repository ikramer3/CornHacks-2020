package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import input.KeyWatcher;
import main.APP_STATE;
import main.Menu;

public class Cycler {
	

	public static int timer=0;
	public int enemyTimer=0;
	int groundHeight=550;
	boolean hasProjectile=false;
	
	Random r;
	ArrayList<Meeple>toBeRemoved=new ArrayList<>();
	ArrayList<Meeple> meeples=new ArrayList<>();
	
	public Cycler() {
		r=new Random();
		addMeeple(MEEPLE_ID.LIZZIE,20,20);
	}
	public void update() {
		for(Meeple m:toBeRemoved) {
			meeples.remove(m);			
		}
		for(Meeple m:meeples) {
			m.update();
		}
		collision();
		timer();
		spawn();
		projectile();
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
		if(enemyTimer%175==0) {
			addMeeple(MEEPLE_ID.FAST_TRASH,r.nextInt(Menu.WIDTH-64),50);
		}
		if(enemyTimer%300==0) {
			addMeeple(MEEPLE_ID.LOW_TRASH,r.nextInt(Menu.WIDTH-64),50);
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
			if(isEnemy(m.getId())){
				enemyCollision(m);
			}
			if(m.getId()==MEEPLE_ID.RECYCLE_NINJA_STAR) {
				RecycleCollision(m);
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
			if(isEnemy(m2.getId())) {
				if(collideCheck(m,m2)) {
					Menu.appState=APP_STATE.MAIN_MENU;
				}
			}
			if(m2.getId()==MEEPLE_ID.RECYCLE_NINJA_STAR) {
				if(collideCheck(m,m2)&&!hasProjectile){
					System.out.println("sdfsdf");
					hasProjectile=true;
					toBeRemoved.add(m2);
				}
			}
		}
	}
	public void RecycleCollision(Meeple m) {
		if(m.getY()+m.getYv()+m.getH()>groundHeight&&!m.isdCol()) {
			m.setYv(0);
			m.setdCol(true);
		}
	}
	public void enemyCollision(Meeple m){
		int elevate=0;	
		if(m.getId()==MEEPLE_ID.FAST_TRASH) {
			elevate=140;
		}else {
			elevate=0;
		}
		if(m.getX()+m.getXv()<0) {
			m.setXv(m.getSpeed());
		}
		if(m.getX()+m.getW()+m.getXv()>Menu.WIDTH) {
			m.setXv(-m.getSpeed());
		}
		if(m.getY()+m.getYv()+m.getH()>groundHeight-elevate&&!m.isdCol()) {
			m.setYv(0);
			m.setdCol(true);
			m.setXv(m.getSpeed());
		}
		for(Meeple m2:meeples) {
			if(m2.getId()==MEEPLE_ID.RECYCLE_NINJA_STAR_ATTACK) {
				if(collideCheck(m,m2)) {
					toBeRemoved.add(m);
				}
			}
		}
		
	}
	public void draw(Graphics graphics) {
		for(Meeple m:meeples) {
			m.draw(graphics);
		}
	}
	public boolean isEnemy(MEEPLE_ID id) {
		if(id==MEEPLE_ID.FAST_TRASH||id==MEEPLE_ID.LOW_TRASH) {
			return true;
		}
		return false;
	}
	public boolean collideCheck(Meeple m1,Meeple m2) {
		if(m1.getRect().intersects(m2.getRect())) {
			return true;
		}else {
			return false;
		}
	}
	public void addMeeple(MEEPLE_ID id,int x,int y) {
		Meeple m=null;
		if(id==MEEPLE_ID.LIZZIE) {
			m=new Player(id,x,y);
		}
		if(id==MEEPLE_ID.FAST_TRASH) {
			m=new Baddie1(id,x,y);
		}
		if(id==MEEPLE_ID.LOW_TRASH) {
			m=new Baddie2(id,x,y);
		}
		if(id==MEEPLE_ID.RECYCLE_NINJA_STAR) {
			m=new RecycleBoi(id,x,y);
		}
		meeples.add(m);				
	}
	public void projectile() {
		if(KeyWatcher.spaceKeyDown&&hasProjectile) {
			Player player=(Player)getMeepleOfID(MEEPLE_ID.LIZZIE);
			int spd=0;
			if(!player.getDir()) {
				spd=-5;
			}else {
				spd=4;
			}
			Meeple projectile=new Projectile(MEEPLE_ID.RECYCLE_NINJA_STAR_ATTACK,player.getX(),player.getY()+player.getH()/2,spd);
			meeples.add(projectile);
			hasProjectile=false;
		}
	}
	public Meeple getMeepleOfID(MEEPLE_ID id) {
		for(Meeple m:meeples) {
			if(m.getId()==id) {
				return m;
			}
		}
		return null;
	}
}
