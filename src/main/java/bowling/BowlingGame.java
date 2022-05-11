package bowling;

public class BowlingGame {
    private int[] rolls = new int[21];
    private int currentRoll = 0;
    private int firstFrame;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public Integer score() {
        int score = 0;
        firstFrame = 0;
        for(int frame=0; frame<10; frame++){
            if(isStrike(firstFrame)){
                score += nextTwoBallsForStrike();
                firstFrame += 1;
            }else if(isSpare(firstFrame)) {
                score += nextBallForSpare();
                firstFrame += 2;
            }else{
                score += nextBallsInFrame();
                firstFrame += 2;
            }
        }
        return score;
    }

    private int nextBallsInFrame() {
        return rolls[firstFrame] + rolls[firstFrame + 1];
    }

    private int nextBallForSpare() {
        return 10 + rolls[firstFrame + 2];
    }

    private int nextTwoBallsForStrike() {
        return 10 + rolls[firstFrame + 1] + rolls[firstFrame + 2];
    }

    private boolean isStrike(int firstFrame) {
        return rolls[firstFrame] == 10;
    }

    private boolean isSpare(int firstFrame) {
        return rolls[firstFrame] + rolls[firstFrame + 1] == 10;
    }
}
