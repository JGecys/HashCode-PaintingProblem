package drawables;

public class Position {

    public int coordX;
    public int coordY;

    public Position() {
    }

    public Position(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    @Override
    public String toString() {
        return "Position{" +
                "coordX=" + coordX +
                ", coordY=" + coordY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (coordX != position.coordX) return false;
        return coordY == position.coordY;

    }

    @Override
    public int hashCode() {
        int result = coordX;
        result = 31 * result + coordY;
        return result;
    }
}
