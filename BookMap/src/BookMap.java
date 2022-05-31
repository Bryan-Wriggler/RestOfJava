import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Generates Frequency maps of a large book
 * @author s-zihhsieh
 */

public class BookMap {
	
	public static void main(String[] args) throws FileNotFoundException {
		//scanners creation
		Scanner console = new Scanner(System.in);
		Scanner book = getBookScanner(console);
		
		//Create a map of words for their occurance
		Map <String, Integer> bookMap = new TreeMap<String, Integer>(); //String: key, Integer: stored value
		
		//read book line by line
		while (book.hasNextLine()) {
			String line = book.nextLine();
			line = formatLine(line); //modify line
			Scanner lineScan = new Scanner(line); //scanner of line
			
			//read each word
			while(lineScan.hasNext()) {
				String word = lineScan.next();
				
				//check if there's a key similar to word
				if (bookMap.containsKey(word)) {
					int newVal = bookMap.get(word) +1; //increment word's value by 1
					bookMap.put(word,  newVal);
					
				} else {
					bookMap.put(word,  1); //put the word as new key
				}
			}
			
			//close linScan
			lineScan.close();
		}
		
		//close scanner
		book.close();
		console.close();
	}
	
	/**
	 * Removes punctuation from line of text
	 * 
	 * @param s -> the input string (line)
	 * @return -> the modified line
	 */
	public static String formatLine(String s) {
		s = s.toLowerCase(); //turn it to all lower case
		
		s = s.replace('.', ' '); //replace period
		s = s.replace(',', ' '); //replace comma
		s = s.replace(';', ' '); //replace semicolon
		s = s.replace(':', ' '); //replace colon
		s = s.replace('?', ' '); //replace question mark
		s = s.replace('!', ' '); //replace exclamation mark
		s = s.replace('"', ' '); //replace quotation
		s = s.replace('(', ' '); //replace paranthesis (left)
		s = s.replace(')', ' '); //replace paranthesis (right)
		
		return s;
	}
	
	/**
	 * @param console -> the user input
	 * @return -> the scanner of file
	 * 
	 * get the text file from user, and return the scanner of file
	 */
	public static Scanner getBookScanner(Scanner console) throws FileNotFoundException {
		System.out.print("Give Book File Name: ");
		File f = new File(console.nextLine());
		Scanner s = new Scanner(f);
		
		return s;
	}
}
