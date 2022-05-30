package sample;

public class TicTacToe {
    public static int numTL;    //Top Left box
    public static int numTC;    //Top Center box
    public static int numTR;    //Top Left box
    public static int numCL;    //Center Right box
    public static int numCC;
    public static int numCR;
    public static int numBL;
    public static int numBC;
    public static int numBR;
    public static int winner;
    public static int currentPlayer = 1;
    public static int counter = 0;

    public TicTacToe(){

    }

    //requires: nothing
    //modifies: this
    //effects: changes to next players currentPlayer
    public static void changeTurn(){
        if(currentPlayer == 1){
            currentPlayer = 2;
        }
        else if(currentPlayer == 2){
            currentPlayer = 1;
        }
    }

    //requires: nothing
    //modifies: this
    //effects: checks if a player has won, if so, returns true and the winner
    public static boolean checkWin(){

        if(numTL == numTC && numTC == numTR && numTL != 0){
            winner = numTL;
            return true;
        }
        else if(numCL == numCC && numCC == numCR && numCL != 0){
            winner = numCL;
            return true;
        }
        else if(numBL == numBC && numBC == numBR && numBL != 0){
            winner = numBL;
            return true;
        }
        else if(numTL == numCL && numCL == numBL && numTL != 0){
            winner = numTL;
            return true;
        }
        else if(numTC == numCC && numCC == numBC && numTC != 0){
            winner = numTC;
            return true;
        }
        else if(numTR == numCR && numCR == numBR && numTR != 0){
            winner = numTR;
            return true;
        }
        else if(numTL == numCC && numCC == numBR && numTL != 0){
            winner = numTL;
            return true;
        }
        else if(numTR == numCC && numCC == numBL && numTR != 0){
            winner = numTR;
            return true;
        }
        else {
            return false;
        }
    }

    //requires: String int
    //modifies: this
    //effects: sets selected id to currentPlayer number
    public static void setBoxNum(String id){
        if(id.equals("boxTL")){
            TicTacToe.numTL = currentPlayer;
        }
        else if(id.equals("boxTC")){
            TicTacToe.numTC = currentPlayer;
        }
        else if(id.equals("boxTR")){
            TicTacToe.numTR = currentPlayer;
        }
        else if(id.equals("boxCL")){
            TicTacToe.numCL = currentPlayer;
        }
        else if(id.equals("boxCC")){
            TicTacToe.numCC = currentPlayer;
        }
        else if(id.equals("boxCR")){
            TicTacToe.numCR = currentPlayer;
        }
        else if(id.equals("boxBL")){
            TicTacToe.numBL = currentPlayer;
        }
        else if(id.equals("boxBC")){
            TicTacToe.numBC = currentPlayer;
        }
        else if(id.equals("boxBR")){
            TicTacToe.numBR = currentPlayer;
        }
    }

    public static void resetGame(){
        numTL = 0;
        numTC = 0;
        numTR = 0;
        numCL = 0;
        numCC = 0;
        numCR = 0;
        numBL = 0;
        numBC = 0;
        numBR = 0;
        currentPlayer = 1;
        winner = 0;
        counter = 0;
    }
}
