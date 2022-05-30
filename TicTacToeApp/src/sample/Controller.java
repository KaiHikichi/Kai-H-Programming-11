package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    //Main Menu
    public ListView<Player> listViewPlayers = new ListView<>();
    public Label lblPlayer1;
    public Label lblPlayer2;
    public TextField txtAddPlayer;

    public void addPlayer(ActionEvent actionEvent) throws IOException { //add player to player list and file
        String name = txtAddPlayer.getText();
        int counter = 0;
        MainMenu.getPlayersFromFile();
        for (int i = 0; i < MainMenu.getPlayers().size(); i++) {  //if name already exists adds a number to the end
            if (MainMenu.getPlayers().get(i).name.equals(name)) {
                i = 0;
                counter++;
                name = txtAddPlayer.getText() + "" + counter;
            }
        }
        Player newPlayer = new Player(name, 0);
        listViewPlayers.getItems().add(newPlayer);
        txtAddPlayer.clear();

        MainMenu.addPlayerToFile(newPlayer, true);    //adds player to file
    }

    public void deletePlayer(ActionEvent actionEvent) throws IOException {  //removes player from list and file list
        String selectedPlayerName;
        selectedPlayerName = listViewPlayers.getSelectionModel().getSelectedItem().name;

        refreshList();

        for (int i = 0; i < listViewPlayers.getItems().size(); i++) {  //removes player from list view
            if (listViewPlayers.getItems().get(i).name.equals(selectedPlayerName)) {
                listViewPlayers.getItems().remove(i);
            }
        }

        boolean append = false;
        for (int i = 0; i < listViewPlayers.getItems().size(); i++) {      //clears file and write players from list view to file
            if (i > 0) {
                append = true;
            }
            MainMenu.addPlayerToFile(listViewPlayers.getItems().get(i), append);
        }
    }

    public void setPlayer1(ActionEvent actionEvent) {   //sets player 1 as selected player
        Player selectedPlayer;
        selectedPlayer = listViewPlayers.getSelectionModel().getSelectedItem();
        lblPlayer1.setText(selectedPlayer.name);
        MainMenu.player1Name = selectedPlayer.name;
        if (lblPlayer2.getText().equals(selectedPlayer.name)) {
            lblPlayer2.setText("");
        }
        lblPlayer1TicTacToe.setText("Player 1: " + MainMenu.getPlayer1().toString());
    }

    public void setPlayer2(ActionEvent actionEvent) {   //sets player 2 as selected player
        Player selectedPlayer;
        selectedPlayer = listViewPlayers.getSelectionModel().getSelectedItem();
        lblPlayer2.setText(selectedPlayer.name);
        MainMenu.player2Name = selectedPlayer.name;
        if (lblPlayer1.getText().equals(selectedPlayer.name)) {
            lblPlayer1.setText("");
        }
        lblPlayer2TicTacToe.setText("Player 2: " + MainMenu.getPlayer2().toString());
    }

    public void refreshList() throws IOException {      //loads list view from file
        MainMenu.getPlayersFromFile();
        listViewPlayers.getItems().clear();
        for (int i = 0; i < MainMenu.getPlayers().size(); i++) {
            listViewPlayers.getItems().add(MainMenu.getPlayers().get(i));
        }

    }

    //Tic Tac Toe gram graphical interface
    public Rectangle boxTL;
    public Rectangle boxTC;
    public Rectangle boxTR;
    public Rectangle boxCL;
    public Rectangle boxCC;
    public Rectangle boxCR;
    public Rectangle boxBL;
    public Rectangle boxBC;
    public Rectangle boxBR;
    public Label lblEndText;
    public Button btnPlayAgain;
    public VBox vboxPlayAgain;
    public VBox vboxTicTacToe;
    public HBox hBox0;
    public Label lblWarning;
    public Label lblPlayer1TicTacToe;
    public Label lblPlayer2TicTacToe;

    public void tapBox(MouseEvent mouseEvent) throws IOException {     //changes box to player colour, changes currentPlayer, and checks for a win
        String source = mouseEvent.getSource().toString().substring(13, 18);
        if (checkSquare(source) == true) {
            setSquares(source, false);
            TicTacToe.setBoxNum(source);
            TicTacToe.changeTurn();
            TicTacToe.counter++;
            if (TicTacToe.checkWin() == true) {
                lblEndText.setText("Player " + TicTacToe.winner + " Wins!");
                lblEndText.setVisible(true);
                lblEndText.setDisable(false);
                vboxPlayAgain.setDisable(false);
                btnPlayAgain.setVisible(true);
                btnPlayAgain.setDisable(false);
                vboxTicTacToe.setDisable(true);
                btnPlayAgain.setText("Play Again");
                if (TicTacToe.winner == 1) {
                    for (int i = 0; i < MainMenu.getPlayers().size(); i++) {
                        if (MainMenu.getPlayers().get(i).name.equals(MainMenu.getPlayer1().name)) {
                            MainMenu.getPlayers().get(i).wins++;
                        }
                    }
                } else if (TicTacToe.winner == 2) {
                    for (int i = 0; i < MainMenu.getPlayers().size(); i++) {
                        if (MainMenu.getPlayers().get(i).name.equals(MainMenu.getPlayer2().name)) {
                            MainMenu.getPlayers().get(i).wins++;
                        }
                    }
                }
                MainMenu.overWriteFile();
                refreshList();
            } else if (TicTacToe.counter == 9) {
                lblEndText.setText("    It's a Tie!");
                lblEndText.setVisible(true);
                lblEndText.setDisable(false);
                vboxPlayAgain.setDisable(false);
                btnPlayAgain.setVisible(true);
                btnPlayAgain.setDisable(false);
                vboxTicTacToe.setDisable(true);
                btnPlayAgain.setText("Play Again");
            }
        } else {
            System.out.println("pick an empty square");
        }
    }

    public void playAgain(ActionEvent actionEvent) {        //starts the game over
        if (MainMenu.getPlayer1() != null && MainMenu.getPlayer2() != null) {
            lblEndText.setVisible(false);
            btnPlayAgain.setVisible(false);
            btnPlayAgain.setDisable(true);
            vboxPlayAgain.setDisable(true);
            lblWarning.setVisible(false);
            vboxTicTacToe.setDisable(false);

            lblPlayer1TicTacToe.setText("Player 1: " + MainMenu.getPlayer1().toString());
            lblPlayer2TicTacToe.setText("Player 2: " + MainMenu.getPlayer2().toString());

            setSquares("", true);
            TicTacToe.resetGame();
        } else {
            lblWarning.setVisible(true);
        }

    }

    public ArrayList<Box> createBoxList() {     //creates an ArrayList list of boxes
        ArrayList<Box> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Box newBox = new Box(null, null);
            list.add(newBox);
        }
        list.get(0).square = boxTL;
        list.get(0).id = "boxTL";
        list.get(1).square = boxTC;
        list.get(1).id = "boxTC";
        list.get(2).square = boxTR;
        list.get(2).id = "boxTR";
        list.get(3).square = boxCL;
        list.get(3).id = "boxCL";
        list.get(4).square = boxCC;
        list.get(4).id = "boxCC";
        list.get(5).square = boxCR;
        list.get(5).id = "boxCR";
        list.get(6).square = boxBL;
        list.get(6).id = "boxBL";
        list.get(7).square = boxBC;
        list.get(7).id = "boxBC";
        list.get(8).square = boxBR;
        list.get(8).id = "boxBR";
        return list;
    }

    public void setSquares(String id, boolean reset) {       //sets selected box to player colour, or resets all boxes
        for (int i = 0; i < 9; i++) {
            if (reset == true) {
                createBoxList().get(i).square.setFill(Color.color(0.8, 0.8, 0.8));
                continue;
            } else if (id.equals(createBoxList().get(i).id)) {
                if (TicTacToe.currentPlayer == 1) {
                    createBoxList().get(i).square.setFill(Color.color(0, 0, 0.8));
                } else if (TicTacToe.currentPlayer == 2) {
                    createBoxList().get(i).square.setFill(Color.color(0.8, 0, 0));
                } else {
                    continue;
                }
            }
        }
    }

    public boolean checkSquare(String id) {      //checks if selected box is available (not taken by other player)
        for (int i = 0; i < 9; i++) {
            if (id.equals(createBoxList().get(i).id)) {
                if (i == 0) {
                    if (TicTacToe.numTL == 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i == 1) {
                    if (TicTacToe.numTC == 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i == 2) {
                    if (TicTacToe.numTR == 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i == 3) {
                    if (TicTacToe.numCL == 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i == 4) {
                    if (TicTacToe.numCC == 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i == 5) {
                    if (TicTacToe.numCR == 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i == 6) {
                    if (TicTacToe.numBL == 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i == 7) {
                    if (TicTacToe.numBC == 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i == 8) {
                    if (TicTacToe.numBR == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}

