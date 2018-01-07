package SeriousGame.entity.mob;

import SeriousGame.entity.Entity;
import SeriousGame.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = -1;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		if (xa > 0 && ya == 0) dir = 1; // Right 	
		if (xa > 0 && ya > 0) dir = 5; // Right Down
		if (xa > 0 && ya < 0) dir = 4; // Right Up
		if (xa < 0 && ya == 0) dir = 3; // Left 	
		if (xa < 0 && ya > 0) dir = 7; // Left Down
		if (xa < 0 && ya < 0) dir = 6; // Left Up
		if (ya > 0 && xa == 0) dir = 2; // Down	
		if (ya < 0 && xa == 0) dir = 0; // Up 		

		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	public void update() {
	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 20 + 5) / 32;
			int yt = ((y + ya) + c / 2 * 10 + 20 ) / 32;
			if (level.getTile(xt, yt).solid()) solid = true;
		}
		return solid;
	}

	public void render() {
	}
}
