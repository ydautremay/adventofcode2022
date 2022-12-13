package dyve.aoc2022.day.day13;

import java.util.Comparator;

public class PacketComparator implements Comparator<Packet> {

    @Override
    public int compare(Packet p1, Packet p2) {
        Pair pair = new Pair(p1, p2);
        return switch (pair.compare(p1.getListContent(), p2.getListContent())){
            case WRONG_ORDER -> 1;
            case RIGHT_ORDER -> -1;
            case SAME -> 0;
        };
    }
}
