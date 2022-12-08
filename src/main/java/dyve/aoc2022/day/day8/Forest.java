package dyve.aoc2022.day.day8;

import java.util.HashMap;
import java.util.Map;

public class Forest {

    private Map<Integer, Map<Integer, Tree>> trees = new HashMap<>();

    int maxX;

    int maxY;

    public void plantTree(int x, int y, int height){
        maxX = Math.max(x, maxX);
        maxY = Math.max(y, maxY);
        trees.computeIfAbsent(x, __ -> new HashMap<>()).put(y, new Tree(height));
    }

    public Tree getTree(int x, int y){
        return trees.get(x).get(y);
    }
}
