package drawables;

import drawables.Position;

public interface PaintCommands {

    /**
     * @param center    Center coord.
     * @param S         S - distance from center to edge.(0 would give PaintCell)
     */
    void PaintSquare(Position center, int S);

    void PaintLine(Position start, Position end);

    void PaintCell(Position pos);

    void EraseCell(Position pos);

}
