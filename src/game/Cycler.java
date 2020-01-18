package game;

import java.awt.Graphics;
import java.util.ArrayList;

public class Cycler {

	int groundHeight=550;
	ArrayList<Meeple> meeples=new ArrayList<>();
	
	public Cycler() {
		addMeeple(MEEPLE_ID.LIZZIE,20,20);
		addMeeple(MEEPLE_ID.LIZZIE,100,20);

	}
	public void update() {
		for(Meeple m:meeples) {
			m.update();
		}
		collision();
	}
	public void collision() {
		for(Meeple m:meeples) {
			if(m.getId()==MEEPLE_ID.LIZZIE) {
				lizzieCollision(m);
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
	}
	public void draw(Graphics graphics) {
		for(Meeple m:meeples) {
			m.draw(graphics);
		}
	}
	public void addMeeple(MEEPLE_ID id,int x,int y) {
		Meeple m=null;
		if(id==MEEPLE_ID.LIZZIE) {
			m=new Player(id,x,y);
		}
		meeples.add(m);
				
	}
}
