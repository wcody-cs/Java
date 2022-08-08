// Cody Wilson
// Last Edited: November 16, 2021
// Write a program to determine scrabble words.
import java.util.*;
import java.io.*;

public class scrabble {

   public static int search ( String array[], String value ) {
      for ( int i = 0; i < array.length; i++ ) 
         if ( array[i].equals(value) )
            return i;
      return -1;
   }//end search
   
   public static int factorial(int n) {
      if ( n < 0 ) {
         System.out.println("Error, n must be non-negative");
         return -1;
      }//end if
      else {
         int fact = 1;
         for ( int i = 1; i<= n; i++ )
            fact = fact * i;
         return fact;
      }//end else
   }//end factorial
   
   public static String[] permutations3( String letters ){
      String answer[] = new String[6];
      char first = letters.charAt(0);
      char second = letters.charAt(1);
      char third = letters.charAt(2);
      
      answer[0] = "" + first + second + third;
      answer[1] = "" + first + third + second;
      answer[2] = "" + second + first + third;
      answer[3] = "" + second + third + first;
      answer[4] = "" + third + first + second;
      answer[5] = "" + third + second + first;
      
      return answer;
   }//end permutations3
   
   public static String[] permutations4( String[] array ){
      String answer[] = new String[26*6];
      int index = 0;
      char alphabet[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
      for ( int i = 0; i < alphabet.length; i++ )
         for ( int j = 0 ; j < array.length; j++ )
            answer[index++] = alphabet[i] + array[j];
         
      return answer;
   }//end letters
   
   public static void main ( String args[] ) throws IOException {
      String scrabbleWords3[] = new String[1065];
      String scrabbleWords4[] = new String[3996]; 
      String letters;
      int index = 0;
      Scanner fileScan = new Scanner( new File("scrabble3.txt") );
      Scanner scan = new Scanner (System.in);
      while ( fileScan.hasNext() ){
         scrabbleWords3[index] = fileScan.nextLine();
         index++;
      }//end while
      fileScan = new Scanner( new File("scrabble4.txt") );
      index = 0;
      while ( fileScan.hasNext() ){
         scrabbleWords4[index] = fileScan.nextLine();
         index++;
      }//end while
      System.out.print("Enter 3 letters with no space in between: ");
      letters = scan.nextLine();
      //shorten to only first 3 characters, correct input is assumed.
      letters = letters.substring(0,3);
      
      //get number of permutations
      int numPerms = factorial(3);
      
      //print the permutations
      System.out.println("There are " + numPerms + " 3-letter permutations. They are: ");
      String threeLetterPermutations[] = permutations3(letters);   
      for ( int i = 0 ; i < threeLetterPermutations.length ; i++ )
         System.out.println(threeLetterPermutations[i]);
      System.out.println();
         
      //create an array for valid words and set all to null
      String valid3LetterWords[] = new String [1065];
      for ( int i = 0 ; i < valid3LetterWords.length; i++ )
         valid3LetterWords[i] = null;
         
      //variable to keep track of index for valid words
      int validIndex = 0;
              
      //search for a element in array
      for ( int i = 0; i < threeLetterPermutations.length; i++ )
         if ( search ( scrabbleWords3, threeLetterPermutations[i]) != -1 )
            valid3LetterWords[validIndex++] = threeLetterPermutations[i];
            
      //assume there are no matches, then check if the flag remains false, print no matches, otherwise, print the matches
      boolean flag = false;
      int valid3Count = 0;
      for ( int i = 0; i < valid3LetterWords.length; i++ )
         if ( valid3LetterWords[i] != null )
            flag = true;
       if (!flag)
          System.out.println("There are no valid 3-letter scrabble words.");
      else {
         //print the valid 3-letter permutations
         System.out.println("\nThe permutations that are valid 3-letter Scabble words are: ");
        
         for ( int i = 0; i < valid3LetterWords.length; i++ )
            if ( valid3LetterWords[i] != null ) {
               System.out.println(valid3LetterWords[i]);
               valid3Count++;
            }//end if
      }//end else
      System.out.println();
       
      //create an array of all 4 letter permutations
      String fourLetterPermutations[] = new String[26*numPerms];
      fourLetterPermutations = permutations4(threeLetterPermutations);
      
      
      //create an array for valid words and set all to null
      String valid4LetterWords[] = new String [3996];
      for ( int i = 0 ; i < valid3LetterWords.length; i++ )
         valid4LetterWords[i] = null;
         
      //search for a element in array
      for ( int i = 0; i < fourLetterPermutations.length; i++ )
         if ( search ( scrabbleWords4, fourLetterPermutations[i]) != -1 )
            valid4LetterWords[validIndex++] = fourLetterPermutations[i];
      System.out.println("If one letter is added at the beginning, there are " + 26*6 + " permutations.\n" );
      
      //assume there are no matches, then check if the flag remains false, print no matches, otherwise, print the matches
      flag = false;
      int valid4Count = 0;
      for ( int i = 0; i < valid4LetterWords.length; i++ )
         if ( valid4LetterWords[i] != null )
            flag = true;
      if (!flag)
          System.out.println("There are no valid 4-letter scrabble words.");
      else {
         //print the valid 4-letter permutations.
         
         System.out.println("\nThe permutations that are valid 4-letter Scabble words are: ");
         for ( int i = 0; i < valid4LetterWords.length; i++ )
            if ( valid4LetterWords[i] != null ) {
               System.out.println(valid4LetterWords[i]);
               valid4Count++;
            }//end if
       }//end else
       System.out.println();
      
      System.out.println("Depending on the letters on the board, you have " + valid3Count + " 3-letter moves and " +
                         valid4Count + " 4-letter moves.");
   }//end main
}//end class