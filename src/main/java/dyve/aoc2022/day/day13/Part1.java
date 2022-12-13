package dyve.aoc2022.day.day13;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.List;
import java.util.stream.IntStream;

public class Part1 extends Part {

    public static void main(String[] args) throws Exception {
        new Part1().subMain(13);
    }

    @Override
    protected Object execute(InputReader reader) {
        List<Pair> pairs = PacketReader.readPairs(reader);

        return IntStream.range(1, pairs.size() + 1).filter(i -> pairs.get(i - 1).rightOrder()).sum();
    }

}
