package ohtu;

public class TennisGame {
    
    private int pointsPlayer1 = 0;
    private int pointsPlayer2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            pointsPlayer1 += 1;
        else
            pointsPlayer2 += 1;
    }

    public String getScore() {
        String score = "";
        int matchPoint = 4;
        if (pointsPlayer1==pointsPlayer2)
        {
            score = scoreCasesFirstPerson();
        }
        else if (pointsPlayer1 >= matchPoint || pointsPlayer2 >= matchPoint)
        {
            score = bothPlayersFourPoints();
        }
        else
        {
            score = scoreCasesSecondPerson();
        }
        return score;
    }

    public String bothPlayersFourPoints() {
        String score = "";
        int scoreAdvantage = pointsPlayer1-pointsPlayer2;
            if (scoreAdvantage==1) score ="Advantage player1";
            else if (scoreAdvantage ==-1) score ="Advantage player2";
            else if (scoreAdvantage>=2) score = "Win for player1";
            else score ="Win for player2";
            return score;
    }

    public String scoreCasesFirstPerson() {
        String score = "";
        switch (pointsPlayer1)
            {
                case 0:
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                case 3:
                        score = "Forty-All";
                    break;
                default:
                        score = "Deuce";
                    break;
            }
        return score;
    }

    public String scoreCasesSecondPerson() {
        String score = "";
        int tempScore = 0;
        int scoreAmount = 3;
        for (int i=1; i < scoreAmount; i++)
            {
                if (i==1) tempScore = pointsPlayer1;
                else {score+="-"; tempScore = pointsPlayer2;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        return score;
    }
}