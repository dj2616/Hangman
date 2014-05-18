package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class dictionary {

public static void main(String[] args) {

	System.out.println("Welcome to Hangman !");
	System.out.println();
	System.out.println("Choose a category: ");	
	System.out.println("1.Countries");
	System.out.println("2.Famous People");	
	System.out.println("3.Companies");	
	System.out.print("Insert number of category: ");	
	
	Scanner input = new Scanner(System.in);
	int category = input.nextInt(); // or as an integer
	input.close();

	//Calling getRandomWord(); method
	String[] word = getRandomWord(category);
	
	System.out.println("************ Random Word and Hint ************");
	System.out.println("Word: " + word[0]);
	System.out.println("Hint: " + word[1]);
	
	// Call the  chooseDifficulty(); method
	

 }

public static String[] getRandomWord(int category){
	String[] random = new String[2];
	
	//Calling getWords(); method
	Map<String, String> words = getWords(category);
	
	// Getting a random entry from the Map.
    Object[] crunchifyKeys = words.keySet().toArray();
    Object key = crunchifyKeys[new Random().nextInt(crunchifyKeys.length)];
	random[0]= (String) key ;
	random[1]= (String) words.get(key) ;
	
	//Returning random word and hint in String array
	return random;
	
}

public static Map<String, String> getWords(int category) {
	Map<String, String> dictionary = new HashMap<String, String>();
	String link ="";
	switch (category) {
	case 1:	link = "Countries.txt";	
		break;
	case 2: link = "FamousPeople.txt";	
		break;
	case 3: link = "Companies.txt";	
		break;
	default:
		break;
	}
	
	File file = new File(link);
    
    try {
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String word = sc.nextLine();
            String hint = sc.nextLine();
            dictionary.put(word, hint);
            word = sc.nextLine();//reading the empty line
        }
        sc.close();
    } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    //Returning map with all words from the category file
	return dictionary;
}

}
