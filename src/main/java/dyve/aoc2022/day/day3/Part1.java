package dyve.aoc2022.day.day3;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Part1 extends Part {

    public static void main(String[] args) throws Exception {
        new Part1().subMain(3);
    }

    @Override
    protected Object execute(InputReader reader) {
        AtomicInteger priority = new AtomicInteger();
        reader.stream().forEach(r -> {
            String comp1 = r.substring(0, r.length()/2);
            String comp2 = r.substring(r.length()/2);
            priority.addAndGet(comp1.chars().mapToObj(c -> String.valueOf((char) c))
                    .filter(comp2::contains)
                    .limit(1)
                    .mapToInt(s -> Letter.valueOf(s).value)
                    .sum());
        });
        return priority.get();
    }

}
