package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.Game;
import input.Button;
import input.MouseWatcher;

public class Menu extends Canvas implements Runnable{

	private static final long serialVersionUID = -4047650331291644852L;
	public static APP_STATE appState=APP_STATE.MAIN_MENU;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = WIDTH * 9/16;
	MouseWatcher mw;
	Button gameButton,dataButton,backButton,enterDataButton,button1,button3,button5,button10,noPlayButton;
	Points points;
	public static Game game;
	Thread thread;
	public static int numOfSpendablePoints=0;
	public static double gramsSaved = 0;

	
	private boolean active = true;





	public static void main(String args[]) {
		numOfSpendablePoints = Points.getTotalPoints();
		gramsSaved = Points.getEmissions();
		new Menu();
	}


	public Menu() {	
		gameButton=new Button("START GAME", 325, 100, WIDTH/3, HEIGHT * 1/3);
		dataButton=new Button("ENTER MILES", 325, 300, WIDTH/3, HEIGHT * 1/3);
		backButton=new Button("BACK", 325, 100, WIDTH/3, HEIGHT * 1/3);
		enterDataButton=new Button("ENTER DATA", 325, 300, WIDTH/3, HEIGHT * 1/3);
		button1=new Button("Biked 1 Mi", 75, 300, WIDTH/5, HEIGHT/4);
		button3=new Button("Biked 3 Mi", 275, 300, WIDTH/5, HEIGHT/4);
		button5=new Button("Biked 5 Mi", 475, 300, WIDTH/5, HEIGHT/4);
		button10=new Button("Biked 10 Mi", 675, 300, WIDTH/5, HEIGHT/4);
		noPlayButton=new Button("You do not have enough points to play", 0, 0, WIDTH, HEIGHT);
		
		mw=new MouseWatcher(gameButton,dataButton,backButton,enterDataButton, button1, button3, button5, button10, noPlayButton);
		this.addMouseListener(mw);
		active = true;
		canvasSetSize();
		appState=APP_STATE.MAIN_MENU;
		this.setFocusable(true);
		thread=new Thread(this);
		thread.start();


	}


	public void run() {
		new GameWindow(this);
		game = new Game(this,true,thread);
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
			gameButton.draw(g, Color.white);
			dataButton.draw(g, Color.white);
		}
		if(appState==APP_STATE.DATA_ENTRY) {
			backButton.draw(g, Color.red);
			button1.draw(g, Color.blue);
			button3.draw(g, Color.cyan);
			button5.draw(g, Color.blue);
			button10.draw(g, Color.cyan);
		}
		if(appState==APP_STATE.GAME_TEE_HEE) {
			game.draw(g);
		}
		if(appState == APP_STATE.NO_PLAY) {
			noPlayButton.draw(g, Color.RED);
		}


	}
	
	private void update() {
		
		if(appState==APP_STATE.MAIN_MENU) {
			
		}
		if(appState==APP_STATE.DATA_ENTRY) {
			
		}
		if(appState==APP_STATE.GAME_TEE_HEE) {
			game.update();
		}
		if(appState == APP_STATE.NO_PLAY) {
			;
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
