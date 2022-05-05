import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main {

        public static void main(String args[]) throws IOException {

                FileReader fr = new FileReader("in.txt");       //create ArrayList of lines
                BufferedReader br = new BufferedReader(fr);
                String line;
                ArrayList<String> lines = new ArrayList<>();
                while((line = br.readLine()) != null){
                        lines.add(line);
                }

                for(int i=0; i < searchWord("program",lines).length; i++){      //print indexs
                        System.out.print(searchWord("program", lines)[i] + " ");
                }
        }

        public static int[] searchWord(String word, ArrayList<String> list){ //searches given arrayList of Strings for given String
                String line;
                char[] wordLetters = new char[word.length()];          //creates a list of chars from the searched word
                word.getChars(0,word.length(),wordLetters,0);
                ArrayList<Integer> indexs = new ArrayList();

                for(int i = 0; i < list.size();i++){            //loops through each line from array list
                        line = list.get(i);
                        char[] lineLetters = new char[line.length()];           //creates a list of chars of the line
                        line.getChars(0,line.length(),lineLetters,0);

                                int l = 0;
                                int counter = 0;
                                for(int k = 0; k < lineLetters.length; k++){    //checks each char of the line, if it matches the first char from the search word it will check the second char
                                        if(lineLetters[k] == wordLetters[l]){
                                                l++;
                                                counter++;
                                        }
                                        else if (lineLetters[k] == wordLetters[0]){
                                                l = 1;
                                                counter = 1;
                                        }
                                        else{
                                                l = 0;
                                                counter = 0;
                                        }
                                        if(counter == word.length()){   //adds succsesful index to arrayList
                                                indexs.add(i+1);
                                                break;
                                        }
                                }
                }


                int[] finalList = new int[indexs.size()];       //changes arraylist to char list
                for(int i = 0; i<indexs.size(); i++){
                        finalList[i] = indexs.get(i);
                }
                return finalList;
        }


}
