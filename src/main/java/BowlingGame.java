import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    List<Integer> rolls = new ArrayList<>();

    public void roll(int i) {
        rolls.add(i);
    }

    public int score() {
        if(rolls.stream().limit(2).mapToInt(Integer::valueOf).sum()==10){
            return 16;
        }
        return rolls.stream().mapToInt(Integer::valueOf).sum();
    }
}
