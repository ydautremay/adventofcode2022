package dyve.aoc2022.day.day7;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Part2 extends Part {

    public static void main(String[] args) throws Exception {
        new Part2().subMain(7);
    }

    @Override
    protected Object execute(InputReader reader) {
        Set<Directory> directories = Parser.parse(reader);

        int diskSize = directories.stream().filter(d -> d.name().equals("/")).findFirst().orElseThrow().size();
        int freeSpace = 70000000 - diskSize;
        int toFree = 30000000 - freeSpace;

        return directories.stream().filter(d -> d.size() > toFree).mapToInt(Directory::size).min().orElseThrow();
    }
}
