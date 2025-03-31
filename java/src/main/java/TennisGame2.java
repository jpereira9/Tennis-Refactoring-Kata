import java.util.Objects;

public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    public String player1Res = "";
    public String player2Res = "";

    public TennisGame2(String player1Name, String player2Name) {
    }

    public StringBuilder getScore(){
        StringBuilder score = new StringBuilder();
        if (player1Points == player2Points) {
            score = getScoreIfEqualPoints();
        } else {
            player1Res = getPlayerRes(player1Points);
            player2Res = getPlayerRes(player2Points);
            score = new StringBuilder(player1Res + "-" + player2Res);
        }
        
        if (player1Points > player2Points && player2Points >= 3) {
            score = new StringBuilder("Advantage player1");
        }
        if (player2Points > player1Points && player1Points >= 3) {
            score = new StringBuilder("Advantage player2");
        }
        if (player1Points >= 4 && player2Points >= 0 && (player1Points - player2Points) >= 2) {
            score = new StringBuilder("Win for player1");
        }
        if (player2Points >= 4 && player1Points >= 0 && (player2Points - player1Points) >= 2) {
            score = new StringBuilder("Win for player2");
        }
        return score;
    }

    private StringBuilder getScoreIfEqualPoints() {
        StringBuilder score = new StringBuilder("Deuce");
        if (player1Points < 3) {
            if (player1Points == 0) {
                score = new StringBuilder("Love");
            }
            if (player1Points == 1) {
                score = new StringBuilder("Fifteen");
            }
            if (player1Points == 2) {
                score = new StringBuilder("Thirty");
            }
            score.append("-All");
        }

        return score;
    }

    private String getPlayerRes(int playerPoints) {
        switch (playerPoints) {
            case 1 -> {
                return "Fifteen";
            }
            case 2 -> {
                return "Thirty";
            }
            case 3 -> {
                return "Forty";
            }
        }
        return "Love";
    }

    public void player1Points(){
        player1Points++;
    }
    
    public void player2Points(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, "player1")) {
            player1Points();
        } else {
            player2Points();
        }
    }
}