package dyve.aoc2022.day.day2;

public enum Shape {
    ROCK(1), PAPER(2), SCISSORS(3);

    final int value;

    Shape(int value){
        this.value = value;
    }

    boolean canBeat(Shape shape){
        return switch (this){
            case ROCK -> shape == SCISSORS;
            case PAPER -> shape == ROCK;
            case SCISSORS -> shape == PAPER;
        };
    }

    Shape beats(){
        return switch (this){
            case ROCK -> SCISSORS;
            case PAPER -> ROCK;
            case SCISSORS -> PAPER;
        };
    }

    Shape losesTo(){
        return switch (this){
            case ROCK -> PAPER;
            case PAPER -> SCISSORS;
            case SCISSORS -> ROCK;
        };
    }

    public static Shape fromInput(String input){
        return switch (input){
            case "A", "X" -> ROCK;
            case "B", "Y" -> PAPER;
            case "C", "Z" -> SCISSORS;
            default -> throw new RuntimeException();
        };
    }

    public static int round(Shape me, Shape opponent){
        int score = me.value;
        if(me == opponent){
            return score + 3;
        }
        if(me.canBeat(opponent)){
            return score + 6;
        }else{
            return score;
        }
    }
}
