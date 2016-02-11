package drawables;

public class Erase implements Drawable {

    private Position pos;

    public Erase(Position pos) {
        this.pos = pos;
    }

    @Override
    public void Draw(Painting painting) {
        painting.EraseCell(pos);
    }
}
