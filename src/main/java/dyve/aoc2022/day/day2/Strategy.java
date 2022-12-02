package dyve.aoc2022.day.day2;

public enum Strategy {
    WIN, LOSE, DRAW;

    public static Strategy fromInput(String input){
        return switch (input){
            case "X" -> LOSE;
            case "Y" -> DRAW;
            case "Z" -> WIN;
            default -> throw new RuntimeException();
        };
    }
}
