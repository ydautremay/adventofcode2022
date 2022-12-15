package dyve.aoc2022.day.day14;

public record Position(int x, int y) {

    public static Position fromString(String s){
        String[] coordinates = s.split(",");
        return new Position(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }

    public Position under(){
        return new Position(x, y + 1);
    }

    public Position diagLeft(){
        return new Position(x - 1, y + 1);
    }

    public Position diagRight(){
        return new Position(x + 1, y + 1);
    }
}
