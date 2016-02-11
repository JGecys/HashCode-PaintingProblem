package drawables;

public class Range {

    private Position start;
    private Position end;

    public Range(Position start, Position end) {
        this.start = start;
        this.end = end;
    }

    public void ForEach(RangeConsumer consumer) {
        for (int i = start.coordX; i < end.coordX; i++) {
            for (int j = start.coordY; j < end.coordY; j++) {
                consumer.at(new Position(i, j));
            }
        }
    }

}
