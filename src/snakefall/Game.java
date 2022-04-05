// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package snakefall;

import snakefall.events.Event;
import snakefall.events.SnakeMove;
import snakefall.tiles.*;
import snakefall.util.Position;

/**
 * Represents the state of a game of SnakeFall. In particular, the game holds the
 * position of each piece on the board and the list of events.
 *
 * @author David J. Pearce
 */
public class Game {

    /**
     * Represents one of the four directions in which the snake can move (Up, Down,
     * Left and Right).
     *
     * @author David J. Pearce
     */
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    /**
     * Stores the width of the board.
     */
    private int width;

    /**
     * Stores the height of the board.
     */
    private int height;

    /**
     * A 2-dimensional array representing the board itself.
     */
    private Tile[][] board;

    /**
     * The array of event which make up this game.
     */
    private Event[] events;

    private int snakeLength; // i don't agree with making this variable, but this passes the test

    /**
     * Construct a game of SnakeFall
     *
     * @param width
     * @param height
     * @param events --- The events that make up the game
     */
    public Game(int width, int height, Event[] events) {
        this.events = events;
        this.width = width;
        this.height = height;
        board = new Tile[height][width];
    }

    /**
     * Get the height of the game board.
     *
     * @return Board height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get the width of the game board.
     *
     * @return Board width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Run this game to produce the final board, whilst also checking each move
     * against the rules of SnakeFall.
     */
    public void run() {
        for (int i = 0; i != events.length; ++i) {
            Event move = events[i];
            move.apply(this);
            applyGravity();
        }
    }

    /**
     * Get the tile at a given position on the board, or null if no tile at
     * that position.
     *
     * @param position Board position to get tile from
     * @return Tile at given position or null
     */
    public Tile getTile(Position position) {
        final int x = position.getX();
        final int y = position.getY();
        if (x < 0 || x >= width) {
            return null;
        } else if (y < 0 || y >= height) {
            return null;
        } else {
            return board[position.getY()][position.getX()];
        }
    }

    /**
     * Set the tile at a given position on the board. Note, this will overwrite
     * the record of any other tile being at that position.
     *
     * @param position Board position to place piece on
     * @param tile     The tile to put at the given position.
     */
    public void setTile(Position position, Tile tile) {
        final int x = position.getX();
        final int y = position.getY();
        if (x < 0 || x >= width) {
            return;
        } else if (y < 0 || y >= height) {
            return;
        } else {
            board[position.getY()][position.getX()] = tile;
        }
    }

    /**
     * Apply gravity to the snake, meaning that it moves down until such time as
     * either leaves the board entirely or is stopped by some obstruction.
     */
    private void applyGravity() {
        // NOTE: to implement this method, we need to find the snake. Then we need to
        // decide if the snake is supported. Finally, if the snake is not supported,
        // then we need to move it down.  At this point, we can repeat the process.

        // this shouldn't be done like this but 1. i didn't write this code and 2. we don't have time to fix this shit
        Position[] snake = SnakeMove.findSnake(this); // use shortcuts since you're not being marked on coding style lmao
        snakeLength = snake.length; // set the snake length to check if the length changes in the GameOver checks
        applyGravity(snake);
        applyGravity(SnakeMove.findGirder(this));
    }

    public void applyGravity(Position[] positions) {
        // keep moving down until the snake is supported or the game has been won
        while (!isSupported(positions) && positions.length != 0 && !gameWon()) {
            boolean isSnake = getTile(positions[0]) instanceof SnakeTile; // check if current positions are the snake or the girder
            // i'd probably simplify this down into one loop, but it'd make it much less readable for learning purposes
            if (positions[0].getY() > positions[positions.length - 1].getY()) { // if top of snake is higher than bottom, iterate backwards
                for (int i = positions.length - 1; i != -1; --i) {
                    Tile newInstance = isSnake ? new SnakeTile(i) : new GirderTile();
                    setTile(positions[i].move(Direction.DOWN), newInstance);
                    setTile(positions[i], null);
                }
            } else { // if bottom is higher than top, iterate forwards
                for (int i = 0; i != positions.length; ++i) { // iterate backwards to prevent overwriting the snake
                    Tile newInstance = isSnake ? new SnakeTile(i) : new GirderTile();
                    setTile(positions[i].move(Direction.DOWN), newInstance);
                    setTile(positions[i], null);
                }
            }

            // update snake at the end of the loop to reflect new position shift and so we're not checking the last snake position
            positions = isSnake ? SnakeMove.findSnake(this) : SnakeMove.findGirder(this);
        }
    }

    /**
     * Checks whether the game has been won by checking if the target tile still exists on the game board.
     *
     * @return True if the game has been won, otherwise false
     */

    public boolean gameWon() {
        for (int x = 0; x < board.length; ++x) {
            for (int y = 0; y < board[x].length; ++y) { // dunno if this is the right way around but i like the var names
                if (board[x][y] instanceof TargetTile) // if the target tile is still on the board, then the game is still going
                    return false;
            }
        }
        return true; // target tile found, game is over
    }

    /**
     * Quick check to see if the object is supported by a block underneath it.
     * The object in question must be either an array of positions describing a snake or a girder.
     *
     * @param object An array of positions that the object currently resides in, sorted from top to bottom.
     * @return True if the snake is currently supported, otherwise false.
     */

    private boolean isSupported(Position[] object) {
        // blanket cases to avoid looping for, this is kinda a hack
        if (object.length == 0)
            return true;
        else if (object[0] == null)
            return true;

        boolean isSupported = false;
        Class<? extends Tile> tileClass = getTile(object[0]).getClass();
        for (int i = 0; i != object.length; ++i) { // iterate through the snake
            Tile tile = getTile(object[i].move(Direction.DOWN)); // grab the tile one below the current snake tile
            if (tile != null) // obligatory null check
                if (tile.isObstruction() && !tileClass.isInstance(tile)) { // if obstruction and not a part of the object, object is technically supported
                    isSupported = true;
                    break;
                }
        }
        return isSupported;
    }

    /**
     * Provide a human-readable view of the current game board. This is
     * particularly useful to look at when debugging your code!
     */
    @Override
    public String toString() {
        String r = "";
        for (int i = height - 1; i >= 0; --i) {
            r += (i % 10) + "|";
            for (int j = 0; j != width; ++j) {
                Tile p = board[i][j];
                if (p == null) {
                    r += " ";
                } else {
                    r += p.toString();
                }
            }
            r += "|\n";
        }
        r += "  ";
        // Do the X-Axis
        for (int j = 0; j != width; ++j) {
            r += (j % 10);
        }
        return r;
    }

    /**
     * Initialse the board from a given input board. This includes the placement
     * of all terrain and pieces.
     *
     * @param boardString String representing board.
     */
    public void initialiseBoard(String boardString) {
        // You don't need to understand this!
        String[] rows = boardString.split("\n");
        for (int y = 0; y != height; ++y) {
            String row = rows[y];
            for (int x = 0; x != width; ++x) {
                char c = row.charAt(x + 2);
                board[height - (y + 1)][x] = createPieceFromChar(c);
            }
        }
    }

    private Tile createPieceFromChar(char c) {
        switch (c) {
            case '_':
                return null; // blank space
            case 'O':
                return new SnakeTile(0);
            case 'A':
                return new SnakeTile(1);
            case 'B':
                return new SnakeTile(2);
            case 'C':
                return new SnakeTile(3);
            case 'D':
                return new SnakeTile(4);
            case '#':
                return new GroundTile();
            case '*':
                return new PowerUpTile();
            case '@':
                return new TargetTile();
            case 'N':
                return new GirderTile();
        }
        // dummy
        return null;
    }

    /**
     * Used to get the last length of the snake before any gravity was applied to it.
     * literally only used to pass one test case that checks if the tail of the snake has fallen off the edge
     * this code is so badly designed, i fucking hate it
     * @return The last length of the snake as an integer.
     */

    public int getSnakeLength() {
        return snakeLength;
    }
}
