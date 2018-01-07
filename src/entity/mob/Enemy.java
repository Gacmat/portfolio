package SeriousGame.entity.mob;

import SeriousGame.graphics.Screen;
import SeriousGame.graphics.Sprite;
import SeriousGame.input.Keyboard;

public class Enemy extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim;
	private boolean walking = false;
	private static int ASpeed = 24;
	private static int AStep = 4;

	public Enemy(Keyboard input) {
		this.input = input;
		sprite = Sprite.EnemyFS;
	}

	public Enemy(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.EnemyFS;
	}

	public void update() {
		int xa = 0, ya = 0, boost = 1;
		if (anim < 7500) anim++;
		else
			anim = 0;

		if (input.up) ya = ya - boost;
		if (input.down) ya = ya + boost;
		if (input.left) xa = xa - boost;
		if (input.right) xa = xa + boost;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else
			walking = false;

	}

	public void render(Screen screen) {
		int flip = 0;
		sprite = Sprite.EnemyBS;
		if (dir == 0 || dir == 4 || dir == 6) {
			sprite = Sprite.EnemyFS;
			if (walking) {
				AStep = 6;
				if ((anim % ASpeed >= 0) && (anim % ASpeed < AStep)) sprite = Sprite.EnemyFW1;
				if ((anim % ASpeed >= 1 * AStep) && (anim % ASpeed < 2 * AStep)) sprite = Sprite.EnemyFS;
				if ((anim % ASpeed >= 2 * AStep) && (anim % ASpeed < 3 * AStep)) sprite = Sprite.EnemyFW2;
				if ((anim % ASpeed >= 3 * AStep) && (anim % ASpeed < 4 * AStep)) sprite = Sprite.EnemyFS;
			}
		}
		if (dir == 1 ) {
			sprite = Sprite.EnemyRS;
			if (walking) {
				AStep = 4;
				if ((anim % ASpeed >= 0) && (anim % ASpeed < AStep)) sprite = Sprite.EnemyWR0;
				if ((anim % ASpeed >= 1 * AStep) && (anim % ASpeed < 2 * AStep)) sprite = Sprite.EnemyWR1;
				if ((anim % ASpeed >= 2 * AStep) && (anim % ASpeed < 3 * AStep)) sprite = Sprite.EnemyWR2;
				if ((anim % ASpeed >= 3 * AStep) && (anim % ASpeed < 4 * AStep)) sprite = Sprite.EnemyWR3;
				if ((anim % ASpeed >= 4 * AStep) && (anim % ASpeed < 5 * AStep)) sprite = Sprite.EnemyWR4;
				if ((anim % ASpeed >= 5 * AStep) && (anim % ASpeed < 6 * AStep)) sprite = Sprite.EnemyWR5;
			}
		}
		if (dir == 3 ) {
			flip = 1;
			sprite = Sprite.EnemyRS;
			if (walking) {
				AStep = 4;
				if ((anim % ASpeed >= 0 * AStep) && (anim % ASpeed < 1 * AStep)) sprite = Sprite.EnemyWR0;
				if ((anim % ASpeed >= 1 * AStep) && (anim % ASpeed < 2 * AStep)) sprite = Sprite.EnemyWR1;
				if ((anim % ASpeed >= 2 * AStep) && (anim % ASpeed < 3 * AStep)) sprite = Sprite.EnemyWR2;
				if ((anim % ASpeed >= 3 * AStep) && (anim % ASpeed < 4 * AStep)) sprite = Sprite.EnemyWR3;
				if ((anim % ASpeed >= 4 * AStep) && (anim % ASpeed < 5 * AStep)) sprite = Sprite.EnemyWR4;
				if ((anim % ASpeed >= 5 * AStep) && (anim % ASpeed < 6 * AStep)) sprite = Sprite.EnemyWR5;

			}
		}

		if (dir == 2 || dir == 5 || dir == 7) {
			sprite = Sprite.EnemyBS;
			if (walking) {
				AStep = 6;
				if ((anim % ASpeed >= 0 * AStep) && (anim % ASpeed < 1 * AStep)) sprite = Sprite.EnemyBW1;
				if ((anim % ASpeed >= 1 * AStep) && (anim % ASpeed < 2 * AStep)) sprite = Sprite.EnemyBS;
				if ((anim % ASpeed >= 2 * AStep) && (anim % ASpeed < 3 * AStep)) sprite = Sprite.EnemyBW2;
				if ((anim % ASpeed >= 3 * AStep) && (anim % ASpeed < 4 * AStep)) sprite = Sprite.EnemyBS;
			}
		}
		screen.renderEnemy(x, y, sprite, flip);
	}
}
