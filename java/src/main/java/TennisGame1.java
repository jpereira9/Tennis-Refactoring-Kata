import java.util.Objects;

public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;

    public TennisGame1(String player1Name, String player2Name) {
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1")) {
            player1Score += 1;
        } else
            player2Score += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        if (player1Score == player2Score) {
            score = getScoreIfEqualPoints();
        } else if (player1Score >= 4 || player2Score >= 4) {
            score = getScoreIfFourPoints();
        } else {
            getScoreIfDifferenceInPoints(score);
        }
        return score.toString();
    }

    private void getScoreIfDifferenceInPoints(StringBuilder score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Score;
            }
            else {
                score.append("-");
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0 -> score.append("Love");
                case 1 -> score.append("Fifteen");
                case 2 -> score.append("Thirty");
                case 3 -> score.append("Forty");
            }
        }
    }

    private StringBuilder getScoreIfFourPoints() {
        StringBuilder score;
        int player1ScoreMinusPlayer2Score = player1Score - player2Score;
        if (player1ScoreMinusPlayer2Score == 1) score = new StringBuilder("Advantage player1");
        else if (player1ScoreMinusPlayer2Score == -1) score = new StringBuilder("Advantage player2");
        else if (player1ScoreMinusPlayer2Score>= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }

    private StringBuilder getScoreIfEqualPoints() {
        StringBuilder score;
        score = new StringBuilder(switch (player1Score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        });
        return score;
    }
}
