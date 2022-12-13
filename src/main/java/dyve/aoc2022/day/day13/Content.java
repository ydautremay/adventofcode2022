package dyve.aoc2022.day.day13;

public sealed interface Content permits ListContent, IntegerContent {

    ListContent getParent();

}
