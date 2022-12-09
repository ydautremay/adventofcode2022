package dyve.aoc2022.day.day9;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 extends Part {

    private static final Pattern pattern = Pattern.compile("([UDLR]) (\\d+)");

    public static void main(String[] args) throws Exception {
        new Part1().subMain(9);
    }

    @Override
    protected Object execute(InputReader reader) {
        Positions positions = new Positions();
        PlanckRope planckRope = new PlanckRope(Knot.of(0, 0), Knot.of(0, 0));
        positions.visited(planckRope.tail().position());

        reader.stream().forEach(s -> {
            Matcher m = pattern.matcher(s);
            m.matches();
            Direction dir = Direction.valueOf(m.group(1));
            int nb = Integer.parseInt(m.group(2));
            for(int i = 0; i < nb; i++){
                planckRope.moveHead(dir);
                positions.visited(planckRope.tail().position());
            }
        });
        return positions.countVisited();
    }
}
