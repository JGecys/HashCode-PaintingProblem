package drawables;

import java.util.ArrayList;
import java.util.List;

public class Line implements Drawable {

    private Position start;
    private Position end;

    public Line(Position start, Position end) {
        this.start = start;
        this.end = end;
    }

    public int length(){
        return Math.max(Math.abs(start.coordX - end.coordX), Math.abs(start.coordY - end.coordY));
    }

    public List<Position> getEachPosition(){
        List<Position> list = new ArrayList<>();
        for(int i = start.coordY; i <= end.coordY; i++){
            for(int j = start.coordX; j <= end.coordX; j++){
                list.add(new Position(j,i));
            }
        }
        return list;
    }

    @Override
    public void Draw(Painting painting) {
        if(start.coordX != end.coordX && start.coordY != end.coordY){
            System.out.println("Bad line command: " + start.toString() + "   " + end.toString());
        }
        String color = Colors.getInstance().getNext();
        for(int i = start.coordY; i <= end.coordY; i++){
            for(int j = start.coordX; j <= end.coordX; j++){
                Position pos = new Position(j, i);
                painting.PaintCell(pos, color);
                painting.getAt(pos).drawables.add(this);
            }
        }
    }

    @Override
    public String toString() {
        return "PAINT_LINE " + start.coordY + " " + start.coordX + " " + end.coordY + " " + end.coordX;
    }
}
