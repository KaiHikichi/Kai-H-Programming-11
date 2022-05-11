package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;

public class Controller {
    public TextField txtName;
    public TextField txtAge;
    public TextField txtGender;
    public TextField txtHobby;
    public Button btnAddFriend;
    public ListView<Friend> friendsList = new ListView<>();
    public Label lblName;
    public Label lblAge;
    public Label lblGender;
    public Label lblHobby;
    public Button btnSave;
    public Button btnLoad;
    public TextField txtListName;
    public Button btnClear;
    public ListView<String> groupList = new ListView<>();

    String name;
    int age;
    String gender;
    String hobby;


    public void addFriend(ActionEvent actionEvent) {
        name = txtName.getText();
        age = Integer.parseInt(txtAge.getText());
        gender = txtGender.getText();
        hobby = txtHobby.getText();
        Friend newFriend = new Friend(name, age, gender, hobby);
        friendsList.getItems().add(newFriend);
        txtName.setText("");
        txtAge.setText("");
        txtGender.setText("");
        txtHobby.setText("");
    }

    public void displayFriend(MouseEvent mouseEvent) {
        Friend selectedItem;
        selectedItem = friendsList.getSelectionModel().getSelectedItem();
        lblName.setText(selectedItem.getName());
        lblAge.setText(toString().valueOf(selectedItem.getAge()));
        lblGender.setText(selectedItem.getGender());
        lblHobby.setText(selectedItem.getHobby());
    }

    public void delFriend(ActionEvent actionEvent) {
        Friend selectedItem;
        selectedItem = friendsList.getSelectionModel().getSelectedItem();
        friendsList.getItems().remove(selectedItem);
        lblName.setText("");
        lblAge.setText("");
        lblGender.setText("");
        lblHobby.setText("");
    }


    public void saveList(ActionEvent actionEvent) throws IOException {      //saves friends to file
        if(txtListName.getText().equals("")){
            System.out.println("Add A Group Name");
            return;
        }

        String listName = txtListName.getText();        //creates new file
        File newFile = new File("files\\"+listName+".txt");
        newFile.createNewFile();


        FileWriter fw = new FileWriter("files\\"+listName+".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        ObservableList<Friend> allItems = friendsList.getItems();

        for(int i = 0; i < friendsList.getItems().size(); i++){ //writes all information to file
            Friend item;
            item = allItems.get(i);
            bw.write(item.getName()+",!\r");
            bw.write(item.getAge()+",@\r");
            bw.write(item.getGender()+",#\r");
            bw.write(item.getHobby()+",$\r");
            bw.write(";\r");
        }

        friendsList.getItems().clear();
        bw.close();
    }

    public void loadList(ActionEvent actionEvent) throws IOException {      //loads friends list with friends from file

        friendsList.getItems().clear();
        CreateFriendGroup group = new CreateFriendGroup();
        ArrayList<Friend> loadFriends = new ArrayList<>();
        loadFriends = group.makeFriendGroup(txtListName.getText());

        for(int i = 0; i < loadFriends.size(); i++){
            friendsList.getItems().add(loadFriends.get(i));
        }

    }

    public void clearList(ActionEvent actionEvent) {        //clears friends list
        friendsList.getItems().clear();
    }

    public void displayGroups(ActionEvent actionEvent) {    //displays all group names in list
        groupList.getItems().clear();
        ArrayList<String> groups = new ArrayList<>();
        File folder = new File("files");
        File[] listOfFiles = folder.listFiles();
        for(int i = 0; i < listOfFiles.length; i++){
            groupList.getItems().add(listOfFiles[i].getName().substring(0,listOfFiles[i].getName().length()-4));
        }

    }

    public void fillGroupName(MouseEvent mouseEvent) {      //fills text bar with group name
        String selectedItem;
        selectedItem = groupList.getSelectionModel().getSelectedItem();
        txtListName.setText(selectedItem);
    }
}