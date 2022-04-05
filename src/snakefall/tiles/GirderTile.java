package snakefall.tiles;

public class GirderTile implements Tile {
    @Override
    public boolean providesSupport() {
        return true;
    }

    @Override
    public boolean isObstruction() {
        return true;
    }

    @Override
    public String toString() {
        return "N";
    }
}
