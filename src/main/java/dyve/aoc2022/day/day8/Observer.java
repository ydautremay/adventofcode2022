package dyve.aoc2022.day.day8;

import java.util.stream.IntStream;

public class Observer {

    public static boolean isVisible(int x, int y, Forest forest){
        if(x == 0 || x == forest.maxX || y == 0 || y == forest.maxY){
            return true;
        }
        int height = forest.getTree(x, y).height();
        return IntStream.range(0, x).map(currX -> forest.getTree(currX, y).height()).noneMatch(h -> h >= height)
                || IntStream.range(x + 1, forest.maxX + 1).map(currX -> forest.getTree(currX, y).height()).noneMatch(h -> h >= height)
                || IntStream.range(0, y).map(currY -> forest.getTree(x, currY).height()).noneMatch(h -> h >= height)
                || IntStream.range(y + 1, forest.maxY + 1).map(currY -> forest.getTree(x, currY).height()).noneMatch(h -> h >= height);
    }

    public static long scenicScore(int x, int y, Forest forest){
        if(x == 0 || x == forest.maxX || y == 0 || y == forest.maxY){
            return 0;
        }
        int height = forest.getTree(x, y).height();
        long left = 0;
        for (int currX = x - 1; currX >= 0; currX--) {
            left++;
            if(forest.getTree(currX, y).height() >= height){
                break;
            }
        }
        long right = 0;
        for (int currX = x + 1; currX <= forest.maxX; currX++) {
            right++;
            if(forest.getTree(currX, y).height() >= height){
                break;
            }
        }
        long up = 0;
        for (int currY = y - 1; currY >= 0; currY--) {
            up++;
            if(forest.getTree(x, currY).height() >= height){
                break;
            }
        }
        long down = 0;
        for (int currY = y + 1; currY <= forest.maxY; currY++) {
            down++;
            if(forest.getTree(x, currY).height() >= height){
                break;
            }
        }
        return left * right * up * down;
    }
}
