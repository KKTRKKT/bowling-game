package bowling;

public class Game {
    private int currentRoll = 0;
    private int[] rolls = new int[21];

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int currentFrame = 0;
        for(int frame = 0; frame < 10; frame++){
            if(isStrike(currentFrame)){
                score += 10 + rolls[currentFrame+1] + rolls[currentFrame+2];
                currentFrame+=1;
            }
            else if(isScore(currentFrame)){
                score += 10 + rolls[currentFrame+2];
                currentFrame+=2;
            }
            else{
                score += rolls[currentFrame] + rolls[currentFrame+1];
                currentFrame+=2;
            }
        }
        return score;
    }

    private boolean isStrike(int currentFrame) {
        return rolls[currentFrame] == 10;
    }

    private boolean isScore(int currentFrame) {
        return rolls[currentFrame] + rolls[currentFrame + 1] == 10;
    }
}