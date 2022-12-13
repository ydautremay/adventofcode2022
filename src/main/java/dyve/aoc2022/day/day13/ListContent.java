package dyve.aoc2022.day.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class ListContent implements Content {

    private final List<Content> contents = new ArrayList<>();

    private final ListContent parent;

    public ListContent(ListContent parent) {
        this.parent = parent;
    }

    public List<Content> getContents(){
        return contents;
    }

    @Override
    public ListContent getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "[" + contents.stream().map(Content::toString).collect(Collectors.joining(",")) + "]";
    }
}
