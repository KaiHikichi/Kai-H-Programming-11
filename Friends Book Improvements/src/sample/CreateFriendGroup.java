package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriendGroup {
    private static String name;
    private static int age;
    private static String gender;
    private static String hobby;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();


    CreateFriendGroup(){

    }

    public ArrayList makeFriendGroup(String listName) throws IOException {
        if(listName.equals("")){                    //checks for empty text bar
            System.out.println("Add A Group Name");
            return friends;
        }
        friends.clear();

        fr = new FileReader("files\\"+listName+".txt");
        br = new BufferedReader(fr);

        String line;
        String friendString = "";
        while ((line = br.readLine()) != null){     //reads all lines of file and saves sets to a string
            if(!line.equals(";")){                  //starts new string when ';' is read
                friendString = friendString + line;
            }
            else{
                parseFriend(friendString);
                friendString = "";

            }


        }
        br.close();
        return friends;
    }

    private static void parseFriend(String s){      //reads string and creates a friend and adds to arraylist
        name = "";
        age = 0;
        gender = "";
        hobby = "";

        int prevPos = 0;
        for(int i = 0; i<s.length()-1; i++){        //identifies each property using if statements and special characters
            if(s.substring(i,i+2).equals(",!")){
                name = s.substring(prevPos,i);
                prevPos = i+2;
            }
            else if(s.substring(i,i+2).equals(",@")){
                age = Integer.parseInt(s.substring(prevPos,i));
                prevPos = i+2;
            }
            else if(s.substring(i,i+2).equals(",#")){
                gender = s.substring(prevPos,i);
                prevPos = i+2;
            }
            else if(s.substring(i,i+2).equals(",$")){
                hobby = s.substring(prevPos,i);
                prevPos = i+2;
            }
        }

        friends.add(new Friend(name,age,gender,hobby));
    }

}
