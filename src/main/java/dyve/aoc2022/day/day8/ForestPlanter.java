package dyve.aoc2022.day.day8;

import dyve.aoc2022.input.InputReader;

import java.util.concurrent.atomic.AtomicInteger;

public class ForestPlanter {

    public static Forest plantForest(InputReader reader){
        Forest forest = new Forest();
        AtomicInteger y = new AtomicInteger(0);
        reader.stream().forEach(line -> {
            AtomicInteger x = new AtomicInteger(0);
            line.chars().mapToObj(c -> Character.toString((char) c)).mapToInt(Integer::parseInt).forEach(h -> {
                forest.plantTree(x.get(), y.get(), h);
                x.incrementAndGet();
            });
            y.incrementAndGet();
        });
        return forest;
    }
}
