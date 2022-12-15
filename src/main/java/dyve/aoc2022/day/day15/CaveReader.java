package dyve.aoc2022.day.day15;

import dyve.aoc2022.input.InputReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaveReader {

    private static final Pattern pattern = Pattern.compile("Sensor at x=(-?\\d+), y=(-?\\d+): closest beacon is at x=(-?\\d+), y=(-?\\d+)");

    public static Cave read(InputReader reader){
        Cave cave = new Cave();
        reader.stream().forEach(l -> {
            Matcher m = pattern.matcher(l);
            m.matches();
            Position position = new Position(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
            Position beaconPosition = new Position(Integer.parseInt(m.group(3)), Integer.parseInt(m.group(4)));
            cave.addSensor(position, beaconPosition);
        });
        return cave;
    }
}
