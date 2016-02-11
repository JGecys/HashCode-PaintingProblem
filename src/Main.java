import drawables.*;

import java.io.*;
import java.util.*;

public class Main {

    public static final String FILE_NAME = "learn_and_teach.in";
    public static final String RESULT_NAME = "learn_and_teach.txt";

    public static void main(String[] args) {
        new Main();
    }

    private Painting painting;
    private HashMap<Position, Drawable> map = new LinkedHashMap<>();

    public Main() {
        readFile();
        analyzePainting();
        System.out.println(painting.toString());
        testResult();
        System.out.println("Command count: " + map.size());
        writeResultToFile();
    }

    public void writeResultToFile() {
        try {
            final PrintWriter writer = new PrintWriter(RESULT_NAME, "UTF-8");
            writer.write(Integer.toString(map.size()) + "\r\n");
            map.forEach((position, drawable) -> {
                writer.write(drawable.toString() + "\r\n");
            });
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void testResult() {
        Painting result = new Painting(painting.getWidth(), painting.getHeight());
        map.forEach((position, drawable) -> drawable.Draw(result));
        System.out.println(result);
        System.out.println("Collisions: ");
        result.PrintCollisions();
        System.out.println(painting.hashCode() == result.hashCode() ? "Correct" : "Incorrect");
    }

    public void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            Scanner scanner = new Scanner(br);

            int height = scanner.nextInt();
            int width = scanner.nextInt();
            scanner.nextLine();
            painting = new Painting(width, height);
            int y = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int x = 0;
                for (char symbol : line.toCharArray()) {
                    if (symbol == '#') {
                        painting.PaintCell(new Position(x, y));
                    }
                    x++;
                }
                y++;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void analyzePainting() {
        analyzeRange(
                new Position(0, 0),
                new Position(painting.getWidth(), painting.getHeight()),
                map);
    }


    public void analyzeRange(Position start, Position end, Map<Position, Drawable> tmpCommands) {
        Painting tmp = new Painting(painting.getWidth(), painting.getHeight());
        tmpCommands.forEach((position, drawable) -> drawable.Draw(tmp));
        new Range(
                start,
                end
        ).ForEach(pos -> analyzePosition(tmp, pos, tmpCommands));
    }

    private void analyzePosition(Painting tmp, Position pos, Map<Position, Drawable> commandMap) {
        if (!tmp.getAt(pos).value && painting.getAt(pos).value) {
            Line horizontal = getHorizontal(pos);
            Line vertical = getVertical(pos);
            if (compareLines(horizontal, vertical, tmp)) {
                commandMap.put(pos, horizontal);
                horizontal.Draw(tmp);
            } else {
                commandMap.put(pos, vertical);
                vertical.Draw(tmp);
            }
        }
    }

    public Line getHorizontal(Position start) {
        int i = start.coordX;
        for (; i < painting.getWidth(); i++) {
            if (!painting.getAt(new Position(i, start.coordY)).value) {
                break;
            }
        }
        i--;
        return new Line(start, new Position(i, start.coordY));
    }

    public Line getVertical(Position start) {
        int i = start.coordY;
        for (; i < painting.getHeight(); i++) {
            if (!painting.getAt(new Position(start.coordX, i)).value) {
                break;
            }
        }
        i--;
        return new Line(start, new Position(start.coordX, i));
    }


    public boolean isSquare(Position start, Position end) {
        for (int i = start.coordX; i <= end.coordX; i++) {
            if (!painting.getAt(new Position(i, end.coordY)).value) {
                return false;
            }
        }
        for (int j = start.coordY; j <= end.coordY; j++) {
            if (!painting.getAt(new Position(end.coordX, j)).value) {
                return false;
            }
        }
        return true;
    }

    public boolean compareLines(Line a, Line b, Painting tmp) {
        int aCnt = 0;
        int bCnt = 0;
        for (Position position : a.getEachPosition()) {
            if (!tmp.getAt(position).value) {
                aCnt++;
            }
        }
        for (Position position : b.getEachPosition()) {
            if (!tmp.getAt(position).value) {
                bCnt++;
            }
        }
        return aCnt > bCnt;
    }

}
