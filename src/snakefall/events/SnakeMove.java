// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package snakefall.events;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import snakefall.Game;
import snakefall.Game.Direction;
import snakefall.tiles.GirderTile;
import snakefall.tiles.PowerUpTile;
import snakefall.tiles.SnakeTile;
import snakefall.tiles.Tile;
import snakefall.util.Position;

/**
 * Represents a directional move of the snake within a given input sequence.
 *
 * @author David J. Pearce
 *
 */
public class SnakeMove implements Event {
	private final Direction direction;

	/**
	 * Construct a new snake move object for a given direction.
	 *
	 * @param direction
	 */
	public SnakeMove(Direction direction) {
		this.direction = direction;
	}

	@Override
	public void apply(Game game) {
		// Identify all sections of the snake
		Position[] snake = findSnake(game);
		// Calculate next position of snake head
		Position next = snake[0].move(direction);
		if (game.getTile(next) != null) {
			// This is fucking horrible but this is under timed conditions and i'm not writing my magnum opus in this time
			switch (game.getTile(next).toString()) {
				case "@":
					moveSnake(next, snake, game);
					break;
				case "*":
					lengthenSnake(next, snake, game);
					break;
				case "N":
					if (moveGirder(direction, game)) // only move snake if you can move the girder
						moveSnake(next, snake, game);
					break;
				default:
					// add something here idk
			}
		} else { // if null, empty space
			moveSnake(next, snake, game);
		}
	}

	private boolean moveGirder(Direction direction, Game game) {
		Position[] girder = findGirder(game);
		boolean traverseBackwards = true;
		// really badly done direction stuff to make sure we're moving the right way, i'm basically gonna implement this like the snake
		switch (direction) {
			case UP:
				if (girder[0].getY() > girder[girder.length - 1].getY())
					traverseBackwards = false;
				break;
			case DOWN:
				if (girder[0].getY() < girder[girder.length - 1].getY())
					traverseBackwards = false;
				break;
			case LEFT:
				if (girder[0].getX() < girder[girder.length - 1].getX())
					traverseBackwards = false;
				break;
			case RIGHT:
				if (girder[0].getX() > girder[girder.length - 1].getX())
					traverseBackwards = false;
				break;
		}

		for (int i = 0; i != girder.length; ++i) {
			Tile newPos = game.getTile(girder[i].move(direction));
			if (newPos != null)
				if (newPos.isObstruction() && !(newPos instanceof GirderTile))
					return false;
		}

		// duplicate code, sue me
		if (traverseBackwards) {
			for (int i = girder.length - 1; i != -1; --i) {
				game.setTile(girder[i].move(direction), new GirderTile());
				game.setTile(girder[i], null);
			}
		} else {
			for (int i = 0; i != girder.length; ++i) {
				game.setTile(girder[i].move(direction), new GirderTile());
				game.setTile(girder[i], null);
			}
		}
		return true;
	}

	private void moveSnake(Position next, Position[] snake, Game game) {
		// Move each section along where the head moves in the direction of movement and
		// all others follow the previous section.
		for (int i = 0; i != snake.length; ++i) {
			// Set tile on board
			game.setTile(next, new SnakeTile(i));
			// Configure location for next section
			next = snake[i];
		}
		// Remove old tail section
		game.setTile(next, null);
	}

	private void lengthenSnake(Position next, Position[] snake, Game game) {
		// Move each section along where the head moves in the direction of movement and
		// all others follow the previous section.
		int i = 0; // declare i outside of the loop scope so i can reference it at the end
		for (; i != snake.length; ++i) {
			// Set tile on board
			game.setTile(next, new SnakeTile(i));
			// Configure location for next section
			next = snake[i];
		}
		// Set the last tile to be the end piece of the snake
		game.setTile(next, new SnakeTile(i));
	}

	/**
	 * Find the positions making up the snake, returning them in order starting from
	 * the head.
	 *
	 * @param game
	 * @return Positions making up the snake in section order.
	 */
	public static Position[] findSnake(Game game) {
		int length = 0;
		// Snake has at most five sections
		Position[] sections = new Position[5];
		// Find all sections
		for (int x = 0; x < game.getWidth(); ++x) {
			for (int y = 0; y < game.getHeight(); ++y) {
				Position p = new Position(x,y);
				// Extract tile at x,y position
				Tile t = game.getTile(p);
				// Check whether is part of snake
				if(t instanceof SnakeTile) {
					SnakeTile st = (SnakeTile) t;
					sections[st.getSection()] = p;
					length = length + 1;
				}
			}
		}
		// Trim the array down to size
		sections = Arrays.copyOf(sections,length);
		// Done
		return sections;
	}

	/**
	 * Basically the same as findSnake, imagine rewriting this in a timed test lmao
	 * This shouldn't be here but i really don't care at this point
	 * @param game
	 * @return
	 */

	public static Position[] findGirder(Game game) {
		// Snake has at most five sections
		List<Position> sections = new ArrayList<>();
		// Find all sections
		for (int x = 0; x < game.getWidth(); ++x) {
			for (int y = 0; y < game.getHeight(); ++y) {
				Position p = new Position(x,y);
				// Extract tile at x,y position
				Tile t = game.getTile(p);
				// Check whether is part of snake
				if(t instanceof GirderTile) {
					sections.add(p);
				}
			}
		}
		// ArrayList is implemented using an array underneath so it basically does the same copy operation as what happens in findSnake
		return sections.toArray(new Position[0]); // Done
	}
}
