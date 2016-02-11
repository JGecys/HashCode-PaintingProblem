package drawables;

public class CellPaint implements Drawable {

    private Position pos;

    public CellPaint(Position pos) {
        this.pos = pos;
    }

    @Override
    public void Draw(Painting painting) {
        painting.PaintCell(pos);
    }
}
