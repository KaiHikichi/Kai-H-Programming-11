package sample;

public class Player {
    public String name;
    public int wins;

    public Player(){

    }

    public Player(String name, int wins){
        this.name = name;
        this.wins = wins;
    }

    @Override
    public String toString() {
        return this.name + " " + wins;
    }
}
