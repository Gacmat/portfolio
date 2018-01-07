package SeriousGame.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import SeriousGame.graphics.Screen;
import SeriousGame.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	//public static Level menu = new SpawnLevel("/levels/manu.png");
	public static Level spawn = new SpawnLevel("/levels/level.png");
	
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}	
	
	public Level(String path){
		loadLevel(path);
		generateLevel();
	}
	
	protected void generateLevel(){
	}
	
	protected void loadLevel(String path){
	}
	
	public void update(){
	}
	
	private void time(){
	}
	
	public void render(int xScroll, int yScroll, Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 5;
		int x1 = (xScroll + screen.width+32) >> 5;
		int y0 = yScroll >> 5; 
		int y1 = (yScroll + screen.height+32) >> 5;
	
		for (int y = y0; y < y1; y++)
			for(int x = x0 ; x < x1; x++){
				getTile(x, y).render(x, y, screen);
			}
	}
	
	//Icons
	// Start
	// Exit
	// Credits
	// Options
	
	// Grass 	= 0xFF00FF00	(green)
	// Flower 	= 0xFFFFFF00	(yellow)
	// Metal	= 0xFFBFBFBF  	(light grey)
	// MetalFloor = 0xFFBFBFFF	(lightest grey? xd)-------------
	// Wood 	= 0xFFA52A2A  	(Brown)	
	// Rock 	= 0xFF7F7F7F	(grey)
	// Brick 	= 0xFFFF0000	(red)
	
	// TileName = 0xAARRGGBB	(color)-------------
	
	//CompOn1	= 0xFF0000FF	(color)-------------
	//CompOn2	= 0xFFRRGGBB	(color)-------------
	//ComOff1	= 0xFFRRGGBB	(color)-------------
	//CompOff2	= 0xFRRGGBB	(color)-------------
	
	//Door1Closed = 0xFF000000	(color)-------------
	//Door2closed = 0xFF000077	(color)-------------
	public Tile getTile(int x, int y){
		if (x < 0 || y < 0 || x>=width || y >=height){
			return Tile.voidTile; 
		}
		if (tiles[x + y * width] == 0xFF00FF00) return Tile.grass;
		if (tiles[x + y * width] == 0xFFFFFF00) return Tile.flower;
		if (tiles[x + y * width] == 0xFFBFBFBF) return Tile.metal;
		if (tiles[x + y * width] == 0xFFA52A2A) return Tile.wood;
		
		if (tiles[x + y * width] == 0xFF00FF00) return Tile.grass;
		if (tiles[x + y * width] == 0xFFFFFF00) return Tile.flower;
		if (tiles[x + y * width] == 0xFFBFBFBF) return Tile.metal;
		if (tiles[x + y * width] == 0xFFA52A2A) return Tile.wood;
		if (tiles[x + y * width] == 0xFF7F7F7F) return Tile.rock;
		if (tiles[x + y * width] == 0xFFFF0000) return Tile.brick;
		if (tiles[x + y * width] == 0xFFBFBFFF) return Tile.metalFloor;
		//if (tiles[x+y*width] == 0xFFRRGGBB) return Tile.name;-----------
		
		if (tiles[x+y*width] == 0xFF000000) return Tile.Door1Closed;
		if (tiles[x+y*width] == 0xFF000077) return Tile.Door2Closed;
		//if (tiles[x+y*width] == 0xFFRRGGBB) return Tile.name;-----------
		//if (tiles[x+y*width] == 0xFFRRGGBB) return Tile.name;-----------
		
		if (tiles[x+y*width] == 0xFF0000FF) return Tile.CompOn1;
		//if (tiles[x+y*width] == 0xFFRRGGBB) return Tile.name;-----------
		//if (tiles[x+y*width] == 0xFFRRGGBB) return Tile.name;-----------
		//if (tiles[x+y*width] == 0xFFRRGGBB) return Tile.name;-----------
		return Tile.voidTile;
	}
	
}
