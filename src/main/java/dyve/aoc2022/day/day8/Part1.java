package dyve.aoc2022.day.day8;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Part1 extends Part {

    public static void main(String[] args) throws Exception {
        new Part1().subMain(8);
    }

    @Override
    protected Object execute(InputReader reader) {
        Forest forest = ForestPlanter.plantForest(reader);

        return IntStream.range(0, forest.maxX + 1)
                .mapToLong(x -> IntStream.range(0, forest.maxY + 1).filter(y -> Observer.isVisible(x, y, forest)).count())
                .sum();
    }
}
