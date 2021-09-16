
public class TennisGame implements ITennisGame {
    
    private int playerTwo;
    private int playerOne;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore() {
        //Declare veriable to hold score
        String score;
        if (playerOne < 4 && playerTwo < 4 && !(playerOne + playerTwo == 6)) {

            // Create Array of possible outcome when both players Scores less than 4
            String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            
            // Save player one point in score variable
            score = points[playerOne];

            // find score in point array using score
            return withHighestScore(score, points);

        } 


        /* If both players score less than 4  and the sum of their score is 6
           Or both players score greater or equals 4 
        */
        else { 

            // check if both player score equals 
            if (playerOne == playerTwo)
                return "Deuce";
              
            if( playerOne > playerTwo){
                score = playerOneName;
            }else{
                score = playerTwoName;
            }
            
            return advantageWinCheck(score);
        }
    }

    // Check if there is a win or advantage
    private String advantageWinCheck(String score) {
        if((playerOne-playerTwo)*(playerOne-playerTwo) == 1){
            return "Advantage " + score;
        } 
        return "Win for " + score;
    }

    private String withHighestScore(String score, String[] points) {
       if (playerOne == playerTwo){
           return score + "-All";
        }
        return score + "-" + points[playerTwo];
    }
    

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.playerOne++;
        else
            this.playerTwo++; 
        
    }
    

}
