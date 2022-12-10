package dyve.aoc2022.day.day10;

import java.util.HashSet;
import java.util.Set;

public class Sprite {

    private final Set<Integer> pixels = new HashSet<>();

    public static Sprite fromMiddle(int middle){
        Sprite sprite = new Sprite();
        sprite.pixels.add(middle - 1);
        sprite.pixels.add(middle);
        sprite.pixels.add(middle + 1);
        return sprite;
    }

    public boolean hasPixel(int pixel){
        return pixels.contains(pixel);
    }
}
