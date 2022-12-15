package dyve.aoc2022.day.day14;

import dyve.aoc2022.input.InputReader;

public class CaveReader {

    public static Cave read(InputReader reader){
        Cave cave = new Cave();
        reader.stream().forEach(s -> {
            String[] ends = s.split(" -> ");
            Position previous = Position.fromString(ends[0]);
            for(int i = 1; i < ends.length; i++){
                Position p = Position.fromString(ends[i]);
                cave.fillRocks(previous, p);
                previous = p;
            }
        });
        return cave;
    }
}
