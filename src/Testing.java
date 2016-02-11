import drawables.Line;
import drawables.Painting;
import drawables.Position;

/**
 * Created by jgecy on 2016-02-11.
 */
public class Testing {

    public static void main(String[] args) {
        Painting tmp = new Painting(10, 3);
        Line line = new Line(new Position(1, 1), new Position(1, 8));
        line.Draw(tmp);
        System.out.println(tmp);
    }

}
