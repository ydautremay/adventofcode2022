package dyve.aoc2022.day.day15;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Map;

public class Part2 extends Part {

    public static void main(String[] args) throws Exception {
        new Part2().subMain(15);
    }

    @Override
    protected Object execute(InputReader reader) {
        /*
         * If there is only one position that fits, it will be just over the frontier
         * of a sensor. To simplify the problem, we look at positions around all sensors
         * until we find one in no sensor detection
         */
        Cave cave = CaveReader.read(reader);
        int max = 4000000;
        for (Map.Entry<Position, Sensor> sensorEntry : cave.getSensors().entrySet()) {
            int distanceToBeacon = sensorEntry.getValue().radius();
            System.out.println(sensorEntry.getKey() + " : " + distanceToBeacon);
            int x = sensorEntry.getKey().x() + distanceToBeacon + 2;
            int y = sensorEntry.getKey().y() - 1;
            Position p;
            while(x > sensorEntry.getKey().x()){
                x--;
                y++;
                p = new Position(x, y);
                if(found(p, cave.sensors.values(), max)) {
                    return tune(p);
                }
            }
            while(y > sensorEntry.getKey().y()){
                x--;
                y--;
                p = new Position(x, y);
                if(found(p, cave.sensors.values(), max)) {
                    return tune(p);
                }
            }
            while(x < sensorEntry.getKey().x()){
                x++;
                y--;
                p = new Position(x, y);
                if(found(p, cave.sensors.values(), max)) {
                    return tune(p);
                }
            }
            while(y < sensorEntry.getKey().y()){
                x++;
                y++;
                p = new Position(x, y);
                if(found(p, cave.sensors.values(), max)) {
                    return tune(p);
                }
            }

        }
        return "Nothing found";
    }

    private boolean isDetectedByAnySensor(Position p, Collection<Sensor> sensors){
        return sensors.stream().anyMatch(s -> s.isDetected(p));
    }

    private BigInteger tune(Position p){
        return new BigInteger(String.valueOf(p.x())).multiply(new BigInteger(String.valueOf(4000000))).add(new BigInteger(String.valueOf(p.y())));
    }

    private boolean found(Position p, Collection<Sensor> sensors, int max){
        if(p.x() > max || p.y() > max || p.x() < 0 || p.y() < 0){
            return false;
        }
        return !isDetectedByAnySensor(p, sensors);
    }
}