package dyve.aoc2022.day.day15;

import java.util.HashMap;
import java.util.Map;

public class Cave {

    public final Map<Position, Sensor> sensors = new HashMap<>();

    public final Map<Position, Beacon> beacons = new HashMap<>();

    private int maxBeaconDistance = Integer.MIN_VALUE;

    public void addSensor(Position p, Position beaconPosition){
        beacons.putIfAbsent(beaconPosition, new Beacon());
        sensors.putIfAbsent(p, new Sensor(p, beaconPosition));
        maxBeaconDistance = Math.max(maxBeaconDistance, p.manhattanDistance(beaconPosition));
    }

    public Map<Position, Sensor> getSensors(){
        return sensors;
    }

    public Map<Position, Beacon> getBeacons() {
        return beacons;
    }

}
