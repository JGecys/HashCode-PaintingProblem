package drawables;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    public String color = Colors.RESET;
    public boolean value = false;
    public List<Drawable> drawables = new ArrayList<>();

    public Cell(boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return value == cell.value;

    }

    @Override
    public int hashCode() {
        return (value ? 1 : 0);
    }
}
