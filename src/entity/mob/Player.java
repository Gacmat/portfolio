package SeriousGame.entity.mob;

import SeriousGame.graphics.Screen;
import SeriousGame.graphics.Sprite;
import SeriousGame.input.Keyboard;

public class Player extends Mob{

	private Keyboard input;
	private Sprite sprite;
	private int anim;
	private boolean walking = false;
	public int anim_const=40;
	public int E = 0;
	
	public Player(Keyboard input){
		this.input = input;
		sprite = Sprite.playerFS;
	}
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.playerFS;
	}
	
	public void update(){
		int xa = 0, ya = 0, boost = 1;
		if(anim < 7500) anim++; 
		else anim = 0; 
		if(input.shift){
			anim_const=20;
			boost=4;
			E=5;
		}
		if(!input.shift){
			anim_const=40;
			boost = 1;
			E=0;
		}
		if(input.up)	ya=ya-boost;
		if(input.down)	ya=ya+boost;
		if(input.left)	xa=xa-boost;
		if(input.right)	xa=xa+boost;
		
		if(xa != 0 || ya!=0){
			move(xa, ya);
			walking = true;
		}
		else 
			walking = false;
		
	}
	
	public void render(Screen screen){
		if(dir == 0 || dir == 4 || dir == 6) {
			sprite = Sprite.playerBS;
			if (walking) {
				if((anim % 40 > 0) && (anim % 40 < 10))
					sprite = Sprite.playerBW1;
				if((anim % 40 > 10) && (anim % 40 < 20))
					sprite = Sprite.playerBS;
				if((anim % 40 > 20) && (anim % 40 < 30))
					sprite = Sprite.playerBW2;
				if((anim % 40 > 30) && (anim % 40 < 40))
					sprite = Sprite.playerBS;
				/*
				if((anim % anim_const > 0) && (anim % anim_const < 10-E))
					sprite = Sprite.playerBW1;
				if((anim % anim_const > 10-E) && (anim % anim_const < 20-2*E))
					sprite = Sprite.playerBS;
				if((anim % anim_const > 20-2*E) && (anim % anim_const < 30-3*E))
					sprite = Sprite.playerBW2;
				if((anim % anim_const > 30-3*E) && (anim % anim_const < 40-4*E))
					sprite = Sprite.playerBS;
				 */
			}
		}
		if(dir == 1) {
			if(walking){
				if((anim % 40 > 0) && (anim % 40 < 10))
					sprite = Sprite.playerRW1;
				if((anim % 40 > 10) && (anim % 40 < 20))
					sprite = Sprite.playerRS;
				if((anim % 40 > 20) && (anim % 40 < 30))
					sprite = Sprite.playerRW2;
				if((anim % 40 > 30) && (anim % 40 < 40))
					sprite = Sprite.playerRS;
			}
		}
		if(dir == 2 || dir == 7 || dir == 5){
			if(walking){
				if((anim % 40 > 0) && (anim % 40 < 10))
					sprite = Sprite.playerFW1;
				if((anim % 40 > 10) && (anim % 40 < 20))
					sprite = Sprite.playerFS;
				if((anim % 40 > 20) && (anim % 40 < 30))
					sprite = Sprite.playerFW2;
				if((anim % 40 > 30) && (anim % 40 < 40))
					sprite = Sprite.playerFS;
			}
		}
		if(dir == 3) {
			if(walking){
				if((anim % 40 > 0) && (anim % 40 < 10))
					sprite = Sprite.playerLW1;
				if((anim % 40 > 10) && (anim % 40 < 20))
					sprite = Sprite.playerLS;
				if((anim % 40 > 20) && (anim % 40 < 30))
					sprite = Sprite.playerLW2;
				if((anim % 40 > 30) && (anim % 40 < 40))
					sprite = Sprite.playerLS;
			}
		}
		screen.renderPlayer(x, y, sprite);
	}
}
