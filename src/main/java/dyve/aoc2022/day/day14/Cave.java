package dyve.aoc2022.day.day14;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Cave {

    private final Map<Position, Element> map = new HashMap<>();

    private int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
    private int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

    public boolean isFree(Position p){
        return map.get(p) == null;
    }

    public int rockDepth(){
        return maxY;
    }

    public void placeEmitter(Position position){
        minX = Math.min(minX, position.x());
        minY = Math.min(minY, position.y());
        maxX = Math.max(maxX, position.x());
        maxY = Math.max(maxY, position.y());
        map.put(position, new Emitter());
    }

    public void fillRocks(Position from, Position to){
        if(from.x() != to.x() && from.y() != to.y()){
            throw new RuntimeException("Can only fill in line");
        }
        if(from.x() == to.x()){
            minX = Math.min(minX, from.x());
            maxX = Math.max(maxX, from.x());
            if(from.y() < to.y()) {
                xLine(from, to, from.x());
            }else{
                xLine(to, from, from.x());
            }
        }else{
            minY = Math.min(minY, from.y());
            maxY = Math.max(maxY, from.y());
            if(from.x() < to.x()) {
                yLine(from, to, from.y());
            }else{
                yLine(to, from, from.y());
            }
        }
    }

    public SandState emitAndflowSand(Position emitPosition) {
        boolean rested = false;
        Position currentPosition = emitPosition;
        while (!rested) {
            if(isFree(currentPosition.under())){
                currentPosition = currentPosition.under();
            }else if(isFree(currentPosition.diagLeft())){
                currentPosition = currentPosition.diagLeft();
            }else if(isFree(currentPosition.diagRight())){
                currentPosition = currentPosition.diagRight();
            }else{
                map.put(currentPosition, new Sand());
                rested = true;
            }
            if(currentPosition.y() > rockDepth()){
                map.put(currentPosition, new Sand());
                maxX = Math.max(maxX, currentPosition.x());
                minX = Math.min(minX, currentPosition.x());
                return SandState.ABYSS;
            }
            if(currentPosition.equals(emitPosition)){
                return SandState.EMITTER;
            }
        }
        return SandState.RESTED;
    }

    private void xLine(Position from, Position to, int x) {
        minY = Math.min(minY, from.y());
        maxY = Math.max(maxY, to.y());
        IntStream.rangeClosed(from.y(), to.y())
                .mapToObj(i -> new Position(x, i))
                .forEach(p -> {
                    map.put(p, new Rock());
                });
    }

    private void yLine(Position from, Position to, int y) {
        minX = Math.min(minX, from.x());
        maxX = Math.max(maxX, to.x());
        IntStream.rangeClosed(from.x(), to.x())
                .mapToObj(i -> new Position(i, y))
                .forEach(p -> {
                    map.put(p, new Rock());
                });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int y = minY; y <= maxY + 2; y++){
            for(int x = minX; x <= maxX; x++){
                if(map.get(new Position(x, y)) instanceof Rock || y == maxY + 2) {
                    sb.append("#");
                }else if(map.get(new Position(x, y)) == null){
                    sb.append(".");
                }else if(map.get(new Position(x, y)) instanceof Sand){
                    sb.append("O");
                }else if(map.get(new Position(x, y)) instanceof Emitter){
                    sb.append("+");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
