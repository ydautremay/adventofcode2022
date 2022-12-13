package dyve.aoc2022.day.day13;

public record Pair(Packet left, Packet right) {

    public boolean rightOrder(){
        return compare(left().getListContent(), right().getListContent()) == CompareResult.RIGHT_ORDER;
    }

    public CompareResult compare(Content left, Content right){
        if(left instanceof IntegerContent leftIc && right instanceof IntegerContent rightIc){
            if(leftIc.getValue() < rightIc.getValue()){
                return CompareResult.RIGHT_ORDER;
            }else if(leftIc.getValue() > rightIc.getValue()){
                return CompareResult.WRONG_ORDER;
            }else{
                return CompareResult.SAME;
            }
        }
        if(left instanceof ListContent leftList && right instanceof ListContent rightList){
            for(int i = 0; i <= leftList.getContents().size(); i++){
                if(i < leftList.getContents().size() && i < rightList.getContents().size()){
                    CompareResult r = compare(leftList.getContents().get(i), rightList.getContents().get(i));
                    if(r == CompareResult.WRONG_ORDER || r == CompareResult.RIGHT_ORDER){
                        return r;
                    }
                }else if(i == leftList.getContents().size() && i == rightList.getContents().size()){
                    return CompareResult.SAME;
                }else if(i == leftList.getContents().size() && i < rightList.getContents().size()){
                    return CompareResult.RIGHT_ORDER;
                }else{
                    return CompareResult.WRONG_ORDER;
                }
            }
        }
        if(!left.getClass().equals(right.getClass())){
            ListContent tmp = new ListContent(null);
            if(left instanceof IntegerContent ic){
                tmp.getContents().add(ic);
                return compare(tmp, right);
            }else if(right instanceof IntegerContent ic){
                tmp.getContents().add(ic);
                return compare(left, tmp);
            }
        }

        return null;
    }
}
