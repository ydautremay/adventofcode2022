package dyve.aoc2022.day.day14;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

public class Part1 extends Part {

    public static void main(String[] args) throws Exception {
        new Part1().subMain(14);
    }

    @Override
    protected Object execute(InputReader reader) {
        Cave cave = CaveReader.read(reader);
        Position emitter = new Position(500, 0);
        cave.placeEmitter(emitter);

        int restedSand = 0;
        SandState sandState = SandState.RESTED;
        while (sandState != SandState.ABYSS) {
            sandState = cave.emitAndflowSand(emitter);
            restedSand++;
        }
        restedSand--;
        System.out.println(cave);

        return restedSand;
    }
}