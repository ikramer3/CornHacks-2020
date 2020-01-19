package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import game.Game;
import input.Button;
import input.KeyWatcher;
import input.MouseWatcher;
import res.ArtLoader;

public class Menu extends Canvas implements Runnable{
	
	/*
	 * STATIC VALUES* 
	 * 
	 */

	private static final long serialVersionUID = -4047650331291644852L;
	public static APP_STATE appState=APP_STATE.MAIN_MENU;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = WIDTH * 9/16;
	public static int numOfSpendablePoints=0;
	public static double gramsSaved = 0;
	
	/*
	 * OBJECTS
	 */
	
	JFrame jf;
	MouseWatcher mw;
	KeyWatcher kw;
	Button gameButton,
		dataButton,
		backButton,
		enterDataButton,
		button1,
		button3,
		button5,
		button10,
		noPlayButton;
	Points points;
	
	Thread thread;
	ArtLoader al;
	public static Game game;	
	private boolean active = true;
	
	int bigButtonWidth=WIDTH/3;
	int bigButtonHeight=HEIGHT/4;
	int medButtonWidth=WIDTH/5;



	///MAIN METHOD

	public static void main(String args[]) {
		numOfSpendablePoints = Points.getTotalPoints();
		gramsSaved = Points.getEmissions();
		new Menu();
	}


	public Menu() {	
		thread=new Thread(this);
		thread.start();
	}
	
	public void init() {
		gameButton=new Button("START GAME",
					WIDTH-bigButtonWidth,
					100,
					bigButtonWidth,
					bigButtonHeight);
		dataButton=new Button("ENTER MILES",
					WIDTH-bigButtonWidth,
					300, 
					bigButtonWidth,
					bigButtonHeight);
		backButton=new Button("BACK",
					getCenter(bigButtonWidth),
					100,
					bigButtonWidth,
					bigButtonHeight);
		enterDataButton=new Button("ENTER DATA", getCenter(bigButtonWidth),
					300,
					bigButtonWidth,
					bigButtonHeight);
		button1=new Button("Biked 1 Mi",
					75,
					300,
					WIDTH/5,
					HEIGHT/4);
		button3=new Button("Biked 3 Mi", 
					275, 
					300, 
					WIDTH/5, 
					HEIGHT/4);
		button5=new Button("Biked 5 Mi", 
					475, 
					300, 
					WIDTH/5, 
					HEIGHT/4);
		button10=new Button("Biked 10 Mi",
					675, 
					300, 
					WIDTH/5, 
					HEIGHT/4);
		noPlayButton=new Button("You do not have enough points to play", 
					0, 
					0, 
					WIDTH, 
					HEIGHT);
		al=new ArtLoader();
		mw=new MouseWatcher(gameButton,dataButton,backButton,enterDataButton, button1, button3, button5, button10, noPlayButton);
		kw = new KeyWatcher();
		this.addMouseListener(mw);
		this.addKeyListener(kw);
		active = true;
		canvasSetSize();
		appState=APP_STATE.MAIN_MENU;
		this.setFocusable(true);
		new GameWindow(this,jf);
		game = new Game(this,true,thread);
		
	}
	
	private int getCenter(int width) {
		return WIDTH/2-width/2;
	}


	public void run() {
		init();
		while(this.active == true) {
			update();
			draw();
			pause();
		}
	}

	private void drawBackground(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.drawString(String.format("You can spend %d points on mini game\n", numOfSpendablePoints), 20, 20);
		g.drawString(String.format("You have saved %.2f kilograms of carbon emmissions", gramsSaved/1000.0), 20, 35);
		if(appState==APP_STATE.MAIN_MENU) {
			g.drawImage(ArtLoader.mainMenuBit,
					0,HEIGHT-ArtLoader.mainMenuBit.getHeight()/2,
					ArtLoader.mainMenuBit.getWidth()/2,
					ArtLoader.mainMenuBit.getHeight()/2,
					null);
			gameButton.draw(g, Color.white);
			dataButton.draw(g, Color.white);			
		}
		if(appState==APP_STATE.DATA_ENTRY) {
			backButton.draw(g, Color.red);
//			button1.draw(g, Color.blue);
//			button3.draw(g, Color.cyan);
//			button5.draw(g, Color.blue);
//			button10.draw(g, Color.cyan);
			g.drawString(kw.getInput(),100,100);
		}
		if(appState==APP_STATE.GAME_TEE_HEE) {
			
			game.draw(g);
		}
		if(appState == APP_STATE.NO_PLAY) {
			noPlayButton.draw(g, Color.RED);
		}


	}
	
	private void update() {
		
		if(appState==APP_STATE.MAIN_MENU) {}
		if(appState==APP_STATE.DATA_ENTRY) {}
		if(appState==APP_STATE.GAME_TEE_HEE) {
			game.update();
		}
		if(appState == APP_STATE.NO_PLAY) {
			
		}
	}
	public void pause() {
		try {
			thread.sleep(1000/60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	private void draw() {
		//Drawing tools
		BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null) {
			this.createBufferStrategy(3);
			return;
		}		
		Graphics g = buffer.getDrawGraphics();
		///ALL DRAWING HAPPENS HERE
		drawBackground(g);
		///ALL DRAWING ENDS HERE
		g.dispose();
		buffer.show();	
	}

	private void canvasSetSize() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));		
	}
}
