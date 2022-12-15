package dyve.aoc2022.day.day15;

public record Position(int x, int y) {

    public int manhattanDistance(Position other){
        return Math.abs(x - other.x) + Math.abs(y - other.y);
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
