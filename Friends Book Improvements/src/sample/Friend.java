package sample;

public class Friend {
    private String name;
    private int age;
    private String gender;
    private String hobby;

    //constructor
    Friend(String name, int age, String gender, String hobby){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobby = hobby;
    }

    Friend(){

    }

    public String toString(){
        String x = "";
        x = name;
        return x;
    }


    public void clear(){
        this.name = "";
        this.age = 0;
        this.gender = "";
        this.hobby = "";
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getHobby() {
        return hobby;
    }
}
