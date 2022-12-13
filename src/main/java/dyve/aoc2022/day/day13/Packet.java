package dyve.aoc2022.day.day13;

public class Packet {

    private final ListContent listContent = new ListContent(null);

    public ListContent getListContent() {
        return listContent;
    }

    @Override
    public String toString() {
        return listContent.toString();
    }
}
