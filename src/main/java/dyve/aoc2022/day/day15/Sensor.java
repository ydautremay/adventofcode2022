package dyve.aoc2022.day.day15;

public record Sensor(Position position, Position nearestBeacon) {

    public boolean isDetected(Position p){
        return position.manhattanDistance(p) <= radius();
    }

    public int radius(){
        return position().manhattanDistance(nearestBeacon);
    }
}
