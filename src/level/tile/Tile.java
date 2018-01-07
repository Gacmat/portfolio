package SeriousGame.level.tile;

import SeriousGame.graphics.Screen;
import SeriousGame.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	
	//Pod³o¿a
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile metal = new MetalTile(Sprite.metal);
	public static Tile metalFloor = new metalFloor(Sprite.metalFloor);
	public static Tile wood = new WoodTile(Sprite.wood);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile brick = new BrickTile(Sprite.brick);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	
	//Drzwi
	public static Tile Door1Closed = new Door1ClosedTile(Sprite.Door1Closed);
//	public static Tile Door1Opening0 = new TerminalBigTile(Sprite.TerminalBig);
//	public static Tile Door1Opening1 = new TerminalBigTile(Sprite.TerminalBig);
//	public static Tile Door1Opening2 = new TerminalBigTile(Sprite.TerminalBig);
//	public static Tile Door1Opening3 = new TerminalBigTile(Sprite.TerminalBig);
	public static Tile Door2Closed = new Door2ClosedTile(Sprite.Door2Closed);
//	public static Tile Door2Opening0 = new TerminalBigTile(Sprite.TerminalBig);
//	public static Tile Door2Opening1 = new TerminalBigTile(Sprite.TerminalBig);
//	public static Tile Door2Opening2 = new TerminalBigTile(Sprite.TerminalBig);
//	public static Tile Door2Opening3 = new TerminalBigTile(Sprite.TerminalBig);
	
	
	//Terminale
	public static Tile TerminalSmall = new TerminalSmallTile(Sprite.TerminalSmall);
	public static Tile TerminalBig = new TerminalBigTile(Sprite.TerminalBig);
	
	//Chest
	
	
	//Skill structure Comp Tree
	public static Tile CompOn1 = new CompOn1Tile(Sprite.CompOn1);
	public static Tile CompOn2 = new CompOn2Tile(Sprite.CompOn2);
	public static Tile CompOff1 = new CompOff1Tile(Sprite.CompOff1);
	public static Tile CompOff2 = new CompOff2Tile(Sprite.CompOff2);
	
	//Ikony
	public static Tile Options	= new Option(Sprite.Options);
	public static Tile Start 	= new Start(Sprite.Start);
	public static Tile Exit 	= new Exit(Sprite.Exit);
	public static Tile Credits1 = new Credits1(Sprite.Credits1);
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}
	
	public boolean moveable(){
		return false;
	}

}
