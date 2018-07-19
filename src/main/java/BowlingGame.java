public class BowlingGame {
    int[] rolls = new int[21];
    int rollIndex = 0;

    public void roll(int pins) {
        rolls[rollIndex++] = pins;
    }

    public int score() {
        int score = 0;
        int index = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rolls[index])) {
                score += 10 + rolls[index+1] + rolls[index + 2];
                index += 1;
            } else if (isSpare(index)) {
                score += 10 + rolls[index + 2];
                index += 2;
            } else {
                score += rolls[index] + rolls[index + 1];
                index += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }

    private boolean isSpare(int index) {
        return rolls[index] + rolls[index + 1] == 10;
    }


}
