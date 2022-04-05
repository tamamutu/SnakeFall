// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package snakefall.tiles;

/**
 * Represents an arbitrary tile on the board. This include the snake, as well as
 * solid ground, power ups, and girders.
 *
 * @author David J. Pearce
 *
 */
public interface Tile {
	/**
	 * Check whether this tile provides support against the action of gravity. That
	 * is, whether or not when applying gravity to e.g. the snake, this tile can
	 * prevent the snake from falling further. For example, solid ground provides
	 * support.
	 *
	 * @return True if this tile does provide support.
	 */
	public boolean providesSupport();

	/**
	 * Check whether this tile is an obstruction which prevents the snake from
	 * moving. For example, solid ground prevents the snake from moving.
	 *
	 * @return True if this tile does obstruct movement.
	 */
	public boolean isObstruction();
}
