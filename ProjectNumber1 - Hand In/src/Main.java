public class Main {


    //Code your solution to problem number one here
    static int problemOne(String s){
        int answer = 0;
        //your code here
        int numChar = s.length();
        int numVowels = 0;
        for (int i = 0; i < numChar; i++) {   // check each char of s for any of the 5 vowels
            for (int v=0;v<5;v++){
                String vowels = "aeiou";
                if ((s.substring(i, i + 1)).equals(vowels.substring(v,v+1))) {
                    numVowels++;
                }
            }
        }
        answer=numVowels;
        return answer;
    }


    //Code you problem number two here
    static int problemTwo(String s){
        int answer = 0;
        //your code here
        int numChar = s.length();
        int numBob = 0;
        for (int i = 0; i < numChar-2; i++) {         // check each 3 digit segment of s for "bob"
            if((s.substring(i,i+3)).equals("bob")){
                numBob++;
            }
        }
        answer=numBob;
        return answer;
    }


    //Code your solution to problem number 3 here
    static String problemThree(String s){
        //your code here
        String out="";
        int numChar = s.length();
        int count = 1;
        int highCount = 0;      // tracks the longest segment of alphabetical chars
        int highCountIndex = 0; // tracks the index of the end of the longest sequence

        for (int i=0; i<numChar-1; i++){        // checks each char with the next for alphabetical order
            char letter = s.charAt(i);
            char nextLetter = s.charAt(i+1);

            if (letter<=nextLetter) {
                count++;
            }
            else{
                count = 1;
            }
            if(count>highCount){
                highCount = count;
                highCountIndex = i+2;
            }
        }

        out=s.substring(highCountIndex-(highCount),highCountIndex);

        if (highCount==1){          // checks for 1 length highCount segments
            out=s.substring(0,1);
        }
        else if (numChar==1){       // checks for 1 length strings
            out=s.substring(0,1);
        }

        s=out;
        return s;
    }


    public static void main(String[] args) {

    }
}
