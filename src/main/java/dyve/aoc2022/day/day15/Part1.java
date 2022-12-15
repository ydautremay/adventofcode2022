package dyve.aoc2022.day.day15;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Part1 extends Part {

    public static void main(String[] args) throws Exception {
        new Part1().subMain(15);
    }

    @Override
    protected Object execute(InputReader reader) {
        Cave cave = CaveReader.read(reader);
        int row = 2000000;
        Set<Integer> impossiblePositions = new HashSet<>();

        for(Map.Entry<Position, Sensor> sensorEntry : cave.getSensors().entrySet()){
            int distanceToBeacon = sensorEntry.getKey().manhattanDistance(sensorEntry.getValue().nearestBeacon());
            int verticalDistance = Math.abs(sensorEntry.getKey().y() - row);
            for(int i = 0; i <= distanceToBeacon - verticalDistance; i++){
                impossiblePositions.add(sensorEntry.getKey().x() - i);
                impossiblePositions.add(sensorEntry.getKey().x() + i);
            }
        }
        cave.getBeacons().keySet().stream().filter(p -> p.y() == row).map(Position::x).toList().forEach(impossiblePositions::remove);
        return impossiblePositions.size();
    }
}