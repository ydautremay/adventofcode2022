package dyve.aoc2022.day.day9;

import java.util.HashMap;
import java.util.Map;

public class Positions {

    private final Map<Integer, Map<Integer, Boolean>> matrix = new HashMap<>();

    int maxX = Integer.MIN_VALUE;
    int minX = Integer.MAX_VALUE;
    int maxY = Integer.MIN_VALUE;
    int minY = Integer.MAX_VALUE;

    public void visited(Position position){
        matrix.computeIfAbsent(position.x(), __ -> new HashMap<>()).put(position.y(), Boolean.TRUE);
        maxX = Math.max(maxX, position.x());
        minX = Math.min(minX, position.x());
        maxY = Math.max(maxY, position.y());
        minY = Math.min(minY, position.y());
    }


    public int countVisited(){
        return matrix.values().stream().mapToInt(Map::size).sum();
    }
}
