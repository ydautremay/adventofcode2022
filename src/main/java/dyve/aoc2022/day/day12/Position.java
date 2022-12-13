package dyve.aoc2022.day.day12;

public record Position(int x, int y) {

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Position left(){
        return new Position(x - 1, y);
    }

    public Position up(){
        return new Position(x, y - 1);
    }

    public Position right(){
        return new Position(x + 1, y);
    }

    public Position down(){
        return new Position(x, y + 1);
    }
}
