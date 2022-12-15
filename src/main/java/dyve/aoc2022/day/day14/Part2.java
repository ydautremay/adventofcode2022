package dyve.aoc2022.day.day14;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

public class Part2 extends Part {

    public static void main(String[] args) throws Exception {
        new Part2().subMain(14);
    }

    @Override
    protected Object execute(InputReader reader) {
        Cave cave = CaveReader.read(reader);
        Position emitter = new Position(500, 0);
        cave.placeEmitter(emitter);

        int restedSand = 0;
        SandState sandState = SandState.RESTED;
        while (sandState != SandState.EMITTER) {
            sandState = cave.emitAndflowSand(emitter);
            restedSand++;
        }
        System.out.println(cave);

        return restedSand;
    }
}