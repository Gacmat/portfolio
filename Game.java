package SeriousGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	public static int width = 320;
	public static int height = width/4*3;
	public static int scale = 3;
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	// -------GAME----------------------------------------------GAME
	public Game(){	
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		frame = new JFrame();
	}
	// -------start----------------------------------------------start
	public synchronized void start(){
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	// -------stop------------------------------------------------stop
	public synchronized void stop(){
		running = false;
		try{
			thread.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	// -------run--------------------------------------------------run
	public void run(){
		new Game();
		while(running){
			update();
			render();
		}
	}
	// -------update----------------------------------------------update
	public void update(){	
	}
	// -------render----------------------------------------------render
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		// Grafika start
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		// Grafika stop
		g.dispose();
		bs.show();
	}
	// -------main------------------------------------------------main
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("Mathroidvania");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
}
