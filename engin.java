package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class dict {

public static void main(String[] args) {
	int category = 1;
	Map words = getWords(category);
    	System.out.println("Total words: " + words.size());
 }

public static Map<String, String> getWords(int category) {
	Map dictionary = new HashMap();
	String link ="";
	switch(category){
	case 1: link="cars.txt";
	
	}
	File file = new File(link);
    
    try {

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String word = sc.nextLine();
            String hint = sc.nextLine();
            String check = sc.nextLine();
            dictionary.put(word, hint);
        }
        sc.close();
    } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
	
	return dictionary;
}

}
