// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package snakefall.events;

import snakefall.Game;
import snakefall.io.GameError;
import snakefall.tiles.TargetTile;
import snakefall.util.Position;

/**
 * Represents the end of the game as a result of either the target tile being
 * taken, or the snake falling of the board in some way.
 *
 * @author David J. Pearce
 *
 */
public class GameOver implements Event {
	/**
	 * Indicates whether the game was won (true) or lost (false).
	 */
	private final boolean won;

	/**
	 * Construct a new GameOver event which indicates whether or not the game was
	 * won.
	 *
	 * @param won This is true if the game was won, or false otherwise.
	 */
	public GameOver(boolean won) {
		this.won = won;
	}

	@Override
	public void apply(Game game) {
		if (won) {
			if (!game.gameWon())
				throw new GameError("The game's not over lmao"); // target tile exists even though the sim reports game is over
		} else {
			Position[] snake = SnakeMove.findSnake(game);
			if (game.gameWon())
				throw new GameError("The game's done lmao"); // no target tile even though the sim reports game is still going
			else if (snake.length != 0) // testing if no snake exists
				if (snake[0] != null && snake.length >= game.getSnakeLength()) // testing if head of snake is null or tail of snake is null
					throw new GameError("bro the snake's still in play"); // snake is still alive, game is still going

		}
	}
}
