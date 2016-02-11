import drawables.*;

/**
 * Created by jgecy on 2016-02-11.
 */
public class SquareTest {

    public static void main(String[] args) {
        Painting tmp = new Painting(10, 6);
        Drawable drawable = new Square(new Position(3, 3), 2);
        drawable.Draw(tmp);
        System.out.println(tmp);
    }

}
