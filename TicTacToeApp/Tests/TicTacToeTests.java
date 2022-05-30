
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.TicTacToe;

public class TicTacToeTests {

    TicTacToe testGame;

    @Before
    public void setup(){
        testGame = new TicTacToe();
        TicTacToe.resetGame();
    }

    @Test
    public void testChangeTurn(){
        //check player 1 currentPlayer
        Assert.assertEquals(1,testGame.currentPlayer);
        //change currentPlayer
        testGame.changeTurn();
        //check player 2 currentPlayer
        Assert.assertEquals(2,testGame.currentPlayer);
        //change currentPlayer
        testGame.changeTurn();
        //check player 1 currentPlayer
        Assert.assertEquals(1,testGame.currentPlayer);
    }

    @Test
    public void testResetGame(){
        //set box numbers
        TicTacToe.numTL = 1;
        TicTacToe.numCL = 2;
        TicTacToe.numTC = 1;
        TicTacToe.numCC = 2;
        TicTacToe.numTR = 1;
        //Reset game
        TicTacToe.resetGame();
        //check box numbers are all reset
        Assert.assertEquals(0,TicTacToe.numTL);
        Assert.assertEquals(0,TicTacToe.numTC);
        Assert.assertEquals(0,TicTacToe.numTR);
        Assert.assertEquals(0,TicTacToe.numCL);
        Assert.assertEquals(0,TicTacToe.numCC);
        Assert.assertEquals(0,TicTacToe.numCR);
        Assert.assertEquals(0,TicTacToe.numBL);
        Assert.assertEquals(0,TicTacToe.numBC);
        Assert.assertEquals(0,TicTacToe.numBR);
    }

    @Test
    public void testCheckWin(){
        //check for no win
        Assert.assertFalse(testGame.checkWin());
        //set up a win
        testGame.numTL = 2;
        testGame.numTC = 2;
        testGame.numTR = 2;
        //check for player 2 win
        Assert.assertTrue(testGame.checkWin());
        Assert.assertEquals(2,testGame.winner);
        //reset game
        TicTacToe.resetGame();
        //check for no win
        Assert.assertFalse(testGame.checkWin());
        //set up a win
        testGame.numTL = 1;
        testGame.numTC = 1;
        testGame.numTR = 1;
        //check for player 1 win
        Assert.assertTrue(testGame.checkWin());
        Assert.assertEquals(1,testGame.winner);
    }

    @Test
    public void testSetBoxNum(){
        //check box number
        Assert.assertEquals(0,testGame.numTL);
        //set box number
        testGame.setBoxNum("boxTL");
        //check box number
        Assert.assertEquals(1,testGame.numTL);
    }








}
