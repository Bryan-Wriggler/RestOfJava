import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Generates Frequency maps of a large book
 * @author s-zihhsieh
 */

public class BookMap {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		//get book's scanner
		Scanner book = getBookScanner(console);
		
		//print book line by line
		while (book.hasNextLine()) {
			String line = book.nextLine();
			System.out.println(line);
			//Scanner lineScan = new Scanner(book.nextLine());
		}
		
		//close scanner
		book.close();
		console.close();
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
