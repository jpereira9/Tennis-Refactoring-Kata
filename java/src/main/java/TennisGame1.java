import java.util.Objects;

public class TennisGame1 implements TennisGame {
    
    private int player1Points = 0;
    private int player2Points = 0;

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1")) {
            player1Points += 1;
        } else
            player2Points += 1;
    }

    public StringBuilder getScore() {
        StringBuilder score = new StringBuilder();
        if (player1Points == player2Points) {
            score = getScoreIfEqualPoints();
        } else if (player1Points >= 4 || player2Points >= 4) {
            score = getScoreIfFourPoints();
        } else {
            getScoreIfDifferenceInPoints(score);
        }
        return new StringBuilder(score.toString());
    }

    private void getScoreIfDifferenceInPoints(StringBuilder score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Points;
            }
            else {
                score.append("-");
                tempScore = player2Points;
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
        int player1PointsMinusPlayer2Points = player1Points - player2Points;
        if (player1PointsMinusPlayer2Points == 1) {
            score = new StringBuilder("Advantage player1");
        } else if (player1PointsMinusPlayer2Points == -1) {
            score = new StringBuilder("Advantage player2");
        } else if (player1PointsMinusPlayer2Points>= 2) {
            score = new StringBuilder("Win for player1");
        } else {
            score = new StringBuilder("Win for player2");
        }
        return score;
    }

    private StringBuilder getScoreIfEqualPoints() {
        StringBuilder score;
        score = new StringBuilder(switch (player1Points) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        });
        return score;
    }
}
