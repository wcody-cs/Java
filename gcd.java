// Cody Wilson
// Last Edited: November 8, 2021
// Practice using recursion to solve for the greatest common divisor
public class gcd {

    public static int gcd ( int num1, int num2) {
        //base case
        if ( num1 == num2 )
            return num1;
        //recursive step
        if ( num1 > num2 )
            return gcd (num1-num2, num2);
        else
            return gcd(num1, num2-num1);
    }//end gcd

    public static void factors( int number, int possibleFactor){
        //error/base case
        if ( number < 1 || possibleFactor < 1){
            return;
        }

        //recursive step
        factors( number, possibleFactor-1);
        
        if ( number % possibleFactor == 0 ) {
            System.out.printf("%d, ", possibleFactor );
            return;
        }
    }//end factors

    public static void lowercase ( String sentence ){
        //base case
        if ( sentence.length() == 1){
            if (Character.isLowerCase( sentence.charAt(0) ) ){
            System.out.print( sentence.charAt(0) );
            return;
            }
            else
                return;
        }//end if
        
        if ( Character.isLowerCase( sentence.charAt(0) ) ) 
            System.out.print( sentence.charAt(0) );
        
        //recursive step
        lowercase( sentence.substring(1) );

    }//end lowercase

        public static void main(String[] args){
        int num1 = 8;
        int num2 = 12;
        System.out.println( "gcd( " + num1 +", " + num2 + " ) = " + gcd( num1, num2 ) );
        System.out.println();
        System.out.println( "Factors of " + num2 );
        factors(12,12);
        System.out.println("\n\n Testing lowercase: ");
        String a = "Programming Assignment 9";
        lowercase ( a );

    }
}
