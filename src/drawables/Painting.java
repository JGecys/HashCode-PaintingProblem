package drawables;

import java.util.Arrays;

public class Painting implements PaintCommands {

    private final int width;
    private final int height;

    private final Cell[][] painting;

    public Painting(int width, int height) {
        this.width = width;
        this.height = height;
        this.painting = new Cell[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                painting[i][j] = new Cell(false);
            }
        }
    }

    public Cell getAt(Position pos) {
        return painting[pos.coordY][pos.coordX];
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(painting);
    }

    @Override
    public void PaintSquare(Position center, int S) {
        if (center.coordX - S < 0 || center.coordY - S < 0
                || center.coordX + S >= width || center.coordY + S >= height) {
            System.out.println("Bad Square command: " + center.toString() + ",  " + S);
        }
        for (int i = center.coordY - S; i <= center.coordY + S; i++) {
            for (int j = center.coordX - S; j <= center.coordX + S; j++) {
                painting[i][j].value = true;
            }
        }
    }

    @Override
    public void PaintLine(Position start, Position end) {
        if (start.coordX != end.coordX && start.coordY != end.coordY) {
            System.out.println("Bad line command: " + start.toString() + "   " + end.toString());
        }
        for (int i = start.coordY; i <= start.coordY; i++) {
            for (int j = end.coordX; j <= end.coordX; j++) {
                painting[i][j].value = true;
            }
        }
    }

    @Override
    public void PaintCell(Position pos) {
        if (pos.coordX < 0 || pos.coordX >= width || pos.coordY < 0 || pos.coordY >= height) {
            System.out.println("Bad input at " + pos);
            return;
        }
        painting[pos.coordY][pos.coordX].value = true;
    }

    public void PaintCell(Position pos, String color) {
        if (pos.coordX < 0 || pos.coordX >= width || pos.coordY < 0 || pos.coordY >= height) {
            System.out.println("Bad input at " + pos);
            return;
        }
        painting[pos.coordY][pos.coordX].value = true;
        painting[pos.coordY][pos.coordX].color = color;
    }

    @Override
    public void EraseCell(Position pos) {
        painting[pos.coordY][pos.coordX].value = false;
        painting[pos.coordY][pos.coordX].color = Colors.RESET;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(width).append(" ").append(height).append('\n');

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                builder.append(painting[i][j].color);
                builder.append(painting[i][j].value ? '#' : '.');
            }
            builder.append('\n');
        }
        builder.append(Colors.RESET);
        return builder.toString();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void PrintCollisions(){
        for (int j = 0; j < getHeight(); j++) {
            for (int i = 0; i < getWidth(); i++) {

                int size = getAt(new Position(i, j)).drawables.size();
                System.out.print(Colors.getInstance().colors[size]);
                System.out.print(size);
            }
            System.out.print('\n');
        }
        System.out.println(Colors.RESET);
    }
}
