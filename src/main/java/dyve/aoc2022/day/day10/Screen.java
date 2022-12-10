package dyve.aoc2022.day.day10;

public class Screen {

    private int col = 0;

    StringBuilder sb = new StringBuilder();

    public void draw(Sprite sprite){
        if(sprite.hasPixel(col)){
            sb.append("#");
        }else{
            sb.append(".");
        }
        col++;
        if(col == 40){
            col = 0;
            sb.append("\n");
        }
    }

    public String display(){
        return sb.toString();
    }
}
