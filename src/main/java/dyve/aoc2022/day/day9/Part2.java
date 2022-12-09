package dyve.aoc2022.day.day9;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 extends Part {

    private static final Pattern pattern = Pattern.compile("([UDLR]) (\\d+)");

    public static void main(String[] args) throws Exception {
        new Part2().subMain(9);
    }

    @Override
    protected Object execute(InputReader reader) {
        Positions positions = new Positions();
        Rope rope = new Rope();
        positions.visited(rope.getTail().position());

        reader.stream().forEach(s -> {
            Matcher m = pattern.matcher(s);
            m.matches();
            Direction dir = Direction.valueOf(m.group(1));
            int nb = Integer.parseInt(m.group(2));
            for(int i = 0; i < nb; i++){
                rope.moveHead(dir);
                positions.visited(rope.getTail().position());
            }
        });
        return positions.countVisited();
    }
}
