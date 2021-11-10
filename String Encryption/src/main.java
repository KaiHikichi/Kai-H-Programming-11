import java.util.Scanner;

public class main {
    public static void main(String args[]){
        //setup scanner
        Scanner input = new Scanner(System.in);
        String message = input.nextLine();

        int charCount = message.length();
        System.out.println("Input: " + message);

        //add "Bo" to the start, flip the string, add "oms" to the end
        message = "Bo" + message.substring(charCount/2,charCount) + message.substring(0,charCount/2) + "oms";
        System.out.println("Encryption: " + message);

        //check if charCount is odd
        int countOdd = 0;
        if(charCount%2 == 1){
            countOdd++;
        }

        //get rid of the extra start and end characters
        String decrypt = message.substring(2,charCount+2);
        //flip the string back
        decrypt = decrypt.substring(charCount/2+countOdd,charCount) + decrypt.substring(0,charCount/2+countOdd);
        System.out.println("Decryption: " + decrypt);





    }
}
