package dyve.aoc2022.day.day13;

public final class IntegerContent implements Content {

    private final int value;

    private final ListContent parent;

    public IntegerContent(int value, ListContent parent) {
        this.value = value;
        this.parent = parent;
    }

    @Override
    public ListContent getParent() {
        return parent;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
