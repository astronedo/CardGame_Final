
package content;

public class Score {
    private int userScore;
    private int compScore;
    public void addUserScore(int userScore){
        this.userScore+=userScore;
    }
    public int getUserScore(){
        return this.userScore;
    }
    public void addCompScore(int compScore){
       this.compScore+=compScore;
    }
    public int getCompScore(){
        return this.compScore;
    }
}
