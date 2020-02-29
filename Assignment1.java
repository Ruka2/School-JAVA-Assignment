/*
Write a Java program that inputs a document and
then outputs the frequencies of each alphabet character that
appears within that document.
*/

import java.util.HashMap;        //Quickly find character content
import java.util.Scanner;        //To input a document
import java.util.Set;            //Set collections to add elements and iterate through iterators

public class Assignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<>();        //Constructed a new HashMap object, given the variable hashMap

        System.out.println("The document is:");
        String line = scanner.nextLine();

        line = line.toUpperCase();                                 //Make character be Big Alphabet
        line = line.replace(" ","");                               //Remove spaces
        String[] Words = line.split("");                           //Separate each letter

        Set<String> wordSet = hashMap.keySet();

        for (int i = 0; i < Words.length; i++) {
            String Word = Words[i];                                //Store every character
            if (wordSet.contains(Word)) {
                Integer number = hashMap.get(Word);
                number++;
                hashMap.put(Word, number);
            } else {
                hashMap.put(Word, 1);                              //else, only appears 1 time that character equal to 1
            }
        }
        double total = 0.0;                                        //To default total value
        for(int i = 0;i < hashMap.keySet().size(); i++){
            total += hashMap.get(Words[i]);
        }
        for (String word : hashMap.keySet()) {
            int percentage = (int)(hashMap.get(word)/total * 100); // Make it to show percentage
            System.out.printf("Alphabet character: %s   Frequency: %2d%%   Times: %2d\n",
                              word, percentage, hashMap.get(word));
        }
    }
}