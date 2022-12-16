package dyve.aoc2022.day.day16;

import java.util.ArrayList;
import java.util.List;

public class Valve {

    private List<Valve> valves = new ArrayList<>();

    public Valve(int flow) {
        this.flow = flow;
    }

    private int flow;
}
