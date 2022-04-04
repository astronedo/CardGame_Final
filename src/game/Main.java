package game;

import content.Card;
import content.Player;
import content.Score;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Score score=new Score();
    private static boolean winner=true;

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Player player=new Player();
        //------------------------------------NAME
        String name;
        do{
        System.out.println("Enter Name: ");
        name=input.nextLine();
        }while("".equals(name));
        player.setName(name);
        //------------------------------------AGE
        int age;
           try{
           System.out.println("Enter Age: ");
           age=input.nextInt();
           player.setAge(age);
           }catch(Exception e){
               System.out.println("Incorrect Input");
           }//
        while(winner){
            System.out.println("Enter chosen value(1-10): ");
            int chosenValue=input.nextInt();
            String converted=Integer.toString(chosenValue);

            Card a=new Card();
            a.cardDeck();
            System.out.println("===============================("+player.getName()+"'s card"+")===============================");
            System.out.println(Arrays.toString(a.userDeck()));//user 26 cards


             int userScore=0;
            for(int i=0;i<26;i++){//we need a for loop inside for loop for each item inside array to be compared to all items inside array
                char w=a.userDeck()[i].charAt(0);
                String x=String.valueOf(w);

                for(int j=0;j<26;j++){
                    char y=a.userDeck()[i].charAt(0);
                    String z=String.valueOf(y);
                    if((x.equals(z))&&(!z.equals(a.userDeck()[i]))){
                        if(z.equals(converted)){
                            userScore+=1;
                        }
                    }else{}
                }
            }
            score.addUserScore(userScore);
            System.out.println("The number of total pair of the given value from your deck is "+userScore);
            System.out.println("Total Score: "+score.getUserScore());

            System.out.println("===============================GAME BOARD===============================");
            System.out.println("============================(Computer's card)===============================");
            System.out.println(Arrays.toString(a.compDeck()));//computer 26 cards
            int compScore=0;
            for(int i=0;i<26;i++){//we need a for loop inside for loop for each item inside array to be compared to all items inside array
                char w=a.compDeck()[i].charAt(0);
                String x=String.valueOf(w);

                for(int j=0;j<26;j++){
                    char y=a.compDeck()[j].charAt(0);
                    String z=String.valueOf(y);
                    if((x.equals(z))&&(!z.equals(a.compDeck()[i]))){
                        if(z.equals(converted)){
                            compScore+=1;
                        }


                    }else{}
                }

            }
            //hard difficulty
            compScore+=Math.random()*100;
            score.addCompScore(compScore);
            System.out.println("The number of total pair of the given value from your deck is "+compScore);
            System.out.println("Total Score: "+score.getCompScore());
            if(score.getUserScore()>500){
                System.out.println("User Wins");
                Main.winner=false;
            }else if(score.getCompScore()>500){
                System.out.println("Computer Wins");
                Main.winner=false;
            }
        }

    }
    
}
