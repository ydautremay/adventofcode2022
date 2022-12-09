package dyve.aoc2022.day.day9;

public record Position(int x, int y) {

    public static Position of(int x, int y){
        return new Position(x, y);
    }
}
