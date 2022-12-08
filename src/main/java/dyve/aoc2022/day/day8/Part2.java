package dyve.aoc2022.day.day8;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.stream.IntStream;

public class Part2 extends Part {

    public static void main(String[] args) throws Exception {
        new Part2().subMain(8);
    }

    @Override
    protected Object execute(InputReader reader) {
        Forest forest = ForestPlanter.plantForest(reader);


        return IntStream.range(0, forest.maxX + 1)
                .mapToLong(x -> IntStream.range(0, forest.maxY + 1).mapToLong(y -> Observer.scenicScore(x, y, forest)).max().orElse(0))
                .max().orElse(0);
    }
}
