package dyve.aoc2022.day.day7;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.Set;
import java.util.regex.Pattern;

public class Part1 extends Part {

    Pattern cdPattern = Pattern.compile("\\$ cd (.+)");

    Pattern dirPattern = Pattern.compile("dir (.+)");

    Pattern filePattern = Pattern.compile("(\\d+) (.+)");

    public static void main(String[] args) throws Exception {
        new Part1().subMain(7);
    }

    @Override
    protected Object execute(InputReader reader) {
        Set<Directory> directories = Parser.parse(reader);

        return directories.stream().filter(d -> d.size() < 100000).mapToInt(Directory::size).sum();
    }
}
