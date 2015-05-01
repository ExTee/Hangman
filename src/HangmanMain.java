import java.util.Scanner;
import java.io.*;


//List of words belongs to Tom25 on Github, I am using his list
//https://github.com/Tom25/Hangman

public class HangmanMain {
	public static void main(String[] args){
		
		//Initialize new Scanner
		Scanner sc = new Scanner(System.in);
		
		//Counter for the number of tries
		int tries = 8;
		

		showMenu();
		
		String wordToGuess = getNewWord();
		String[] word = MakeArray(wordToGuess);
		
		
		
		//heres the empty word we test
		String[] WordToTest = new String[word.length];
		for(int i = 0; i < WordToTest.length; i++)
		{
			WordToTest[i] = "_ ";
		}
		
		System.out.println(printEmptyWord(word));
		//end of word
		while (IsWordFound(WordToTest) != true)
		{
			if(tries <= 0)
			{
				System.out.println("You've lost the game! Better luck next time!");
				System.out.println("The Word was " + wordToGuess);
				System.exit(0);
			}
		
			System.out.println("Please guess a letter");
			
			String letter = "";
			letter = sc.next();
		
			if(IsLetterThere(letter, word, WordToTest))
			{
				WordToTest = verifyLetter(letter, word, WordToTest);
			}
			
			else
			{
				tries--;
				
				System.out.println("The letter " + letter + " is not in the word.");
				System.out.println("You have " + tries + " lives left.");
				
				WordToTest = verifyLetter(letter, word, WordToTest);

			}

		
		}
		
		System.out.print("Congratulations, You won the Game!");
		//testing
		
		/*
		WordToTest = verifyLetter("n", word, WordToTest);
		boolean there = IsLetterThere("n", word, WordToTest);
		if (!there)
		{
			tries++;
		}
		boolean win1 = IsWordFound(WordToTest);
		
		WordToTest = verifyLetter("t", word, WordToTest);
		WordToTest = verifyLetter("x", word, WordToTest);
		WordToTest = verifyLetter("g", word, WordToTest);
		WordToTest = verifyLetter("i", word, WordToTest);
		WordToTest = verifyLetter("j", word, WordToTest);
		WordToTest = verifyLetter("w", word, WordToTest);
		WordToTest = verifyLetter("a", word, WordToTest);
		WordToTest = verifyLetter("o", word, WordToTest);
		boolean win2 = IsWordFound(WordToTest);
		System.out.println();
		System.out.println("_____________________________");
		System.out.println(tries);
		System.out.println(win1);
		System.out.println(win2);
		//testing
		 */

		sc.close();
	}
	
	
	//method that shows menu
	public static void showMenu()

	{
		Scanner sc = new Scanner(System.in);
		//System.out.println("Welcome to Hangman. Start Game? (Y/N)");
		String answer = "";
		
		while (!answer.equalsIgnoreCase("y"))
		{
			System.out.println("Welcome to Hangman. Start Game? (Y/N)");
			answer = sc.next();
			
			if(answer.equalsIgnoreCase("n"))
			{
				System.out.println("Okay, maybe another time! Bye!");
				System.exit(0);
			}
		}
		
		sc.close();
	}
	
	//method to get a new word
	
		//TODO
	public static String getNewWord() /*throws IOException*/
	{
		/*
		String newWord = "";
		String filename = "hello.txt";
		
		FileReader fr = new FileReader(new File(filename));
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		System.out.println(line);
		
		fr.close();
		br.close();
		*/
		return "XinTong Wang";
		//TODO
	}
	
	//method to print the _ _ _
	public static String printEmptyWord(String[] wordToPrint)
	{
		String word = "";
		
		for (int counter = 0; counter < wordToPrint.length; counter++)
		{
			if (wordToPrint[counter].equals("-")){
				word = word + " - ";}
			else if (wordToPrint[counter].equals(" ")){
				word = word + "  ";}
			else	{
				word = word + "_ ";}
		}
		
		return word;
	}
	
	//Put a String word into array
	public static String[] MakeArray(String s)
	{
		//create new empty array
		String[] sArray = new String[s.length()];
		
		//put elements of string into array
		for(int i = 0; i < s.length(); i++)
		{
			sArray[i] = String.valueOf(s.charAt(i));
		}
		
		return sArray;
	}
	
	//method to verify if letter exists in word and prints
	public static String[] verifyLetter(String letterToTest, String[] CorrectWord, String[] WordToTest)
	{
		
		//WordToTest = new String[CorrectWord.length];
		
		
		
		for (int counter = 0; counter < CorrectWord.length; counter++)
		{
			if (    String.valueOf(CorrectWord[counter]).equalsIgnoreCase(letterToTest)    && String.valueOf(WordToTest[counter]).equals("_ ") )
			
				
			{
				WordToTest[counter] =  letterToTest + " ";
			}
			else if ((String.valueOf(CorrectWord[counter])).equals(" "))
			{
				WordToTest[counter] = "  ";
			}
			
			else if(String.valueOf(WordToTest[counter]).equals("_ "))
			{
				WordToTest[counter] = "_ ";
			}
		}
		
		//print the word
		for (int i = 0; i < WordToTest.length; i++)
		{
			System.out.print(WordToTest[i]);
		}
		
		System.out.println();
		return WordToTest;
	}

	
	public static boolean IsLetterThere(String letterToTest, String[] CorrectWord, String[] WordToTest)
	{
		boolean isThere = false;
		
		for (int i = 0; i < CorrectWord.length; i++)
		{
			if(CorrectWord[i].equalsIgnoreCase(letterToTest))
			{
				isThere = true;
				break;
			}
		}
		
		return isThere;
	}


//TODO Method is word finished
	public static boolean IsWordFound(String[] WordToTest)
	{
		boolean Found = true;
		
		for(int i = 0; i < WordToTest.length; i++)
		{
			if (WordToTest[i].equalsIgnoreCase("_ "))
			{
				Found = false;
				break;
			}
		}
		
		return Found;
	}







}
