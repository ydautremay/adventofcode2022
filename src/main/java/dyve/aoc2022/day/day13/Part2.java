package dyve.aoc2022.day.day13;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Part2 extends Part {

    public static void main(String[] args) throws Exception {
        new Part2().subMain(13);
    }

    @Override
    protected Object execute(InputReader reader) {
        List<Packet> packets = new ArrayList<>(PacketReader.readPackets(reader));
        Packet divider1 = new Packet();
        ListContent listContent1 = new ListContent(divider1.getListContent());
        listContent1.getContents().add(new IntegerContent(2, listContent1));
        divider1.getListContent().getContents().add(listContent1);

        Packet divider2 = new Packet();
        ListContent listContent2 = new ListContent(divider1.getListContent());
        listContent2.getContents().add(new IntegerContent(6, listContent1));
        divider2.getListContent().getContents().add(listContent2);

        packets.add(divider1);
        packets.add(divider2);

        packets.sort(new PacketComparator());

        return IntStream.range(1, packets.size() + 1).filter(i -> packets.get(i - 1) == divider1 || packets.get(i - 1) == divider2).reduce((a, b) -> a * b).orElseThrow();
    }

}
