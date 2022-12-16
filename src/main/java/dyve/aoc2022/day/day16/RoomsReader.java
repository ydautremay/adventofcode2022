package dyve.aoc2022.day.day16;

import dyve.aoc2022.input.InputReader;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoomsReader {

    private static final Pattern pattern = Pattern.compile("Valve (\\w\\w) has flow rate=(\\d+); tunnels lead to valves (.+)");

    public static Map<String, Valve> readRooms(InputReader reader){
        Map<String, Valve> valves = new HashMap<>();
        reader.stream().forEach(l -> {
            Matcher m = pattern.matcher(l);
            m.matches();
            Valve v = valves.computeIfAbsent(m.group(1), k -> new Valve(Integer.parseInt(m.group(2))));
        });
        return valves;
    }
}
