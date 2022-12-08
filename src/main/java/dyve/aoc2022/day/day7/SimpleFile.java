package dyve.aoc2022.day.day7;

import java.util.Objects;

public record SimpleFile (String name, int size) implements File {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleFile that = (SimpleFile) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
