package dyve.aoc2022.day.day4;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

public class Part2 extends Part {

    public static void main(String[] args) throws Exception {
        new Part2().subMain(4);
    }

    @Override
    protected Object execute(InputReader reader) {
        return reader.stream().filter(input -> {
            String[] pair = input.split(",");
            Range range1 = new Range(pair[0]);
            Range range2 = new Range(pair[1]);
            return range1.overlaps(range2);
        }).count();
    }
}
