package dyve.aoc2022.day.day9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Rope {

    private final List<Knot> knots = new ArrayList<>(10);

    public Rope(){
        IntStream.range(0, 10).forEach(__ -> knots.add(Knot.of(0, 0)));
    }

    public void moveHead(Direction direction){
        knots.get(0).move(direction);
        for (int i = 1; i < knots.size(); i++){
            knots.get(i).follow(knots.get(i - 1));
        }
    }

    public Knot getTail(){
        return knots.get(knots.size() - 1);
    }
}
