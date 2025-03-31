import java.util.Objects;

public class TennisGame3 implements TennisGame {
    
    private int player2Points;
    private int player1Points;
    private final String player1Name;
    private final String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public StringBuilder getScore() {
        String score;
        if (player1Points < 4 && player2Points < 4 && !(player1Points + player2Points == 6)) {
            String[] pointsArray = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            score = pointsArray[player1Points];
            return new StringBuilder((player1Points == player2Points) ? score + "-All" : score + "-" + pointsArray[player2Points]);
        } else {
            if (player1Points == player2Points)
                return new StringBuilder("Deuce");
            score = player1Points > player2Points ? player1Name : player2Name;
            return new StringBuilder(((player1Points - player2Points) * (player1Points - player2Points) == 1) ? "Advantage " + score : "Win for " + score);
        }
    }
    
    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1"))
            this.player1Points += 1;
        else
            this.player2Points += 1;
        
    }

}
