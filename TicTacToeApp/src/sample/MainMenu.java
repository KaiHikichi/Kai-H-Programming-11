package sample;

import java.io.*;
import java.util.ArrayList;

public class MainMenu {
    public static String player1Name;
    public static String player2Name;
    private static FileReader fr;
    private static BufferedReader br;
    private static FileWriter fw;
    private static BufferedWriter bw;
    private static ArrayList<Player> players = new ArrayList<>();

    public MainMenu(){

    }

    //requires: Player, boolean
    //modifies: this, PLayersFile
    //effects: writes player to file
    public static void addPlayerToFile(Player p, boolean append) throws IOException {
        players.add(p);
        fw = new FileWriter("src\\PlayersFile.txt",append);
        bw = new BufferedWriter(fw);

        bw.write("\r" + p.name+",\r");
        bw.write(p.wins + "\r");
        bw.write(";");
        bw.close();
    }

    //requires: nothing
    //modifies: this
    //effects: gets players from file and adds them to players list
    public static void getPlayersFromFile() throws IOException {
        players.clear();
        fr = new FileReader("src\\PlayersFile.txt");
        br = new BufferedReader(fr);

        String line;
        String playerString = "";
        while ((line = br.readLine()) != null){
            if(!line.equals(";")){
                playerString = playerString + line;
            }
            else{
                parsePlayer(playerString);
                playerString = "";
            }
        }
        br.close();
    }

    //requires: String
    //modifies: this
    //effects: creates a Player from a String
    private static void parsePlayer(String s){
        String name = "";
        int wins = 0;

        int pos = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.substring(i,i+1).equals(",")){
                name = s.substring(0,i);
                wins = Integer.parseInt(s.substring(i+1,s.length()));
            }
        }
        players.add(new Player(name, wins));
    }

    //requires: nothing
    //modifies: this, PlayersFile
    //effects: clears file then writes players list to file
    public static void overWriteFile() throws IOException {
        fw = new FileWriter("src\\PlayersFile.txt");
        bw = new BufferedWriter(fw);

        for (int i = 0; i<players.size(); i++){
            Player p = players.get(i);

            bw.write("\r" + p.name+",\r");
            bw.write("" + p.wins + "\r");
            bw.write(";");

        }
        bw.close();
    }

    //requires: nothing
    //modifies: this
    //effects: returns Player1 from ArrayList players
    public static Player getPlayer1(){
        for (int i = 0; i<players.size(); i++){
            if (players.get(i).name.equals(player1Name)){
                return players.get(i);
            }
        }
        return null;
    }

    //requires: nothing
    //modifies: this
    //effects: returns Player2 from ArrayList players
    public static Player getPlayer2(){
        for (int i = 0; i<players.size(); i++){
            if (players.get(i).name.equals(player2Name)){
                return players.get(i);
            }
        }
        return null;
    }


    public static ArrayList<Player> getPlayers() {
        return players;
    }
    public static void setPlayers(ArrayList<Player> players) {
        MainMenu.players = players;
    }
}
