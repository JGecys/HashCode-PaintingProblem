package drawables;

import java.awt.*;

public class Square implements Drawable{

    private Position center;
    private int S;

    public Square(Position center, int s) {
        this.center = center;
        S = s;
    }

    @Override
    public void Draw(Painting painting) {
        if(center.coordX - S < 0 || center.coordY - S < 0
                || center.coordX + S >= painting.getWidth() || center.coordY + S >= painting.getHeight()){
            System.out.println("Bad Square command: " + center.toString() + ",  " + S);
        }
        String color = Colors.getInstance().getNext();
        for(int i = center.coordY - S; i <= center.coordY + S; i++){
            for(int j = center.coordX - S; j <= center.coordX + S; j++){
                painting.PaintCell(new Position(j, i), color);
            }
        }
    }
}
