// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package snakefall.tiles;

import java.util.Arrays;

import snakefall.Game;
import snakefall.events.SnakeMove;
import snakefall.util.Position;

/**
 * Represents one section of the snake on the board.
 *
 * @author David J. Pearce
 *
 */
public class SnakeTile implements Tile {
	/**
	 * Identifies the section number of this tile in the snake, where section 0
	 * represents the head of the snake. For the purposes of this test, we limit the
	 * length of the snake to at most five sections.
	 */
	private final int section;

	/**
	 * Construct a new snake tile representing a given section of the snake.
	 *
	 * @param section The section number of the snake.
	 */
	public SnakeTile(int section) {
		if(section < 0 || section > 4) {
			throw new IllegalArgumentException("invalid snake section (" + section + ")");
		}
		this.section = section;
	}

	/**
	 * Identify the section of the snake that this tile represents, where zero is
	 * the head of the snake.
	 *
	 * @return The section number this tile represents in the snake.
	 */
	public int getSection() {
		return section;
	}

	/**
	 * Find the positions making up the snake, returning them in order starting from
	 * the head.
	 *
	 * @param game
	 * @return The positions which make up the snake.
	 */
	public Position[] identify(Game game) {
		return SnakeMove.findSnake(game);
	}

	@Override
	public String toString() {
		switch(section) {
		case 0:
			return "O";
		case 1:
			return "A";
		case 2:
			return "B";
		case 3:
			return "C";
		case 4:
			return "D";
		default:
			throw new IllegalStateException("invalid snake");
		}
	}

	@Override
	public boolean providesSupport() {
		return true;
	}

	@Override
	public boolean isObstruction() {
		return true;
	}
}
