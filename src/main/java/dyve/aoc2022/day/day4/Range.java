package dyve.aoc2022.day.day4;

public class Range {

    int start;

    int end;

    Range(String input){
        String[] s = input.split("-");
        start = Integer.parseInt(s[0]);
        end = Integer.parseInt(s[1]);
    }

    boolean contains(Range other){
        return start <= other.start && end >= other.end;
    }

    boolean overlaps(Range other){
        return !(end < other.start || start > other.end);
    }
}
