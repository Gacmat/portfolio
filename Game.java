package SeriousGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import SeriousGame.graphics.Screen;
import SeriousGame.input.Keyboard;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	public static int width = 320;
	public static int height = width/4*3;
	public static int scale = 3;
	public int acc_mov = 1;
	
	public static String title= "Mathroidvania";
	private Thread thread;
	private JFrame frame;
	private Keyboard key = new Keyboard();
	private boolean running = false;
	
	private Screen screen;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	// -------GAME----------------------------------------------GAME
	public Game(){	
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();
		
		addKeyListener(key);	
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
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >=1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer+=1000;
				frame.setTitle(title + " | " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}	
		}
		stop();
	}
	//=====
	int x = 0, y = 0;
	// -------update----------------------------------------------update
	public void update(){
		key.update();
		
		if(key.shift)
			acc_mov = 3;
		else	acc_mov = 1;
		if(key.up)		y -= acc_mov;
		if(key.down)	y += acc_mov;
		if(key.left)	x -= acc_mov;
		if(key.right)	x += acc_mov; 
	}
	// -------render----------------------------------------------render
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		screen.render(x, y);
		
		for(int i = 0 ; i < pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		// Grafika start
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		// Grafika stop
		g.dispose();
		bs.show();
	}
	// -------main------------------------------------------------main
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
}
