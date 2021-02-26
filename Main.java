//start of code
//Two Computers Playing each other in Rock Paper Scissors
import java.util.*;
//import java.util.concurrent.TimeUnit;
import java.lang.*;
import java.text.*;

class Main {

  public static void main(String [] args) {

    System.out.println("Welcome to my game of Rock, Paper, Scissors!");

    //declare variables
    Scanner keyboard = new Scanner(System.in);
    int compWins=0,comp2Wins=0,totalWins,round=0,drawCount=0,input,compChoice;
    double drawRate;
    String humanStr,compStr,humanName,compName;
    Random rd = new Random();
    DecimalFormat format = new DecimalFormat("00");

    //collect input
    System.out.print("Enter a name for CPU1: ");
    humanName = keyboard.next();
    System.out.print("Enter a name for CPU2: ");
    compName = keyboard.next();
    System.out.print("How many rounds are needed for victory? ");
    totalWins = keyboard.nextInt();
    System.out.println();

    while(compWins<totalWins && comp2Wins<totalWins) {

      round+=1;
      System.out.println("Round #"+round);
      //throws InterruptedException {};
      //TimeUnit.SECONDS.sleep(1000);
      //System.out.print("Enter 0=rock, 1=paper, 2=scissors: ");
      //input = keyboard.nextInt();
      input = rd.nextInt(3);

      //test input validity
      switch(input){
        case 0:
          humanStr="rock";
          break;
        case 1:
          humanStr="paper";
          break;
        case 2: 
          humanStr="scissors";
          break;
        default:
          System.out.println("Invalid input.");
          System.out.println("You must enter a 0, 1, or 2.");
          System.out.println();
          continue;
      } //end of switch statement

      //generate computer choice
      compChoice=rd.nextInt(3);
      switch(compChoice){
        case 0:
          compStr="rock";
          break;
        case 1:
          compStr="paper";
          break;
        case 2:
        default:
          compStr="scissors";
          break;
      } //end of switch statement

      //compare choices
      System.out.println();
      System.out.println(humanName+": "+humanStr+"    "+compName+": "+compStr);

      int outcome = input - compChoice;
      switch(outcome){
        case 0:
          System.out.println("This round ended in a draw.");
          drawCount+=1;
          break;
        case 1:
        case -2:
          System.out.println(humanName+" wins this round.");
          comp2Wins+=1;
          break;
        case -1:
        case 2:
        default:
          System.out.println(compName+" wins this round.");
          compWins+=1;
          break;
      } //end of switch loop
      //TimeUnit.SECONDS.sleep(1000);

      System.out.println("Total Score: "+humanName+" "+comp2Wins);
      System.out.println("             "+compName+" "+compWins);
      System.out.println();

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    } //end of while loop

    if(comp2Wins>compWins) {
      System.out.println(humanName+" wins in "+round+" rounds.");
    } else {
      System.out.println(compName+" wins in "+round+" rounds.");
    } //end of if loop
    drawRate = Math.floor(100*drawCount/round);
    System.out.println("Draw count: "+drawCount+"  Draw rate: "+format.format(drawRate)+"%");

    System.out.println("Goodbye, play again sometime.");

  } //end of main method

} //end of Rock class
//end of code
