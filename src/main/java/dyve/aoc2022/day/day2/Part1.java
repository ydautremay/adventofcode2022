package dyve.aoc2022.day.day2;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

public class Part1 extends Part {

    public static void main(String[] args) throws Exception {
        new Part1().subMain(2);
    }

    @Override
    protected Object execute(InputReader reader) {
        return reader.stream().mapToInt(this::round).sum();
    }

    public int round(String input){
        Shape opponent = Shape.fromInput(input.substring(0, 1));
        Shape me = Shape.fromInput(input.substring(2));
        return Shape.round(me, opponent);
    }
}
