package dyve.aoc2022.day.day5;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Part1 extends Part {

    Pattern pattern = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");

    public static void main(String[] args) throws Exception {
        new Part1().subMain(5);
    }

    @Override
    protected Object execute(InputReader reader) {
        Platform platform = Platform.fromInput(reader.stream().takeWhile(s -> s.startsWith("[") || s.startsWith(" ")).toList());
        System.out.println(platform.stacks);

        reader.stream().filter(s -> s.startsWith("m")).forEach(s -> {
            Matcher matcher = pattern.matcher(s);
            matcher.find();
            for(int i = 0; i < Integer.parseInt(matcher.group(1)); i++){
                platform.move(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
            }
        });
        return platform.stacks.stream().map(Deque::getLast).collect(Collectors.joining());
    }
}
