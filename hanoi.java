class hanoi {
	
	static String answer = "";
	
	
	public static int FibBinaryRecursive(int k) {
		
		if ( k == 0 ) return 0;
		
		if ( k == 1 ) return 1;
		
		return FibBinaryRecursive(k-1) + FibBinaryRecursive(k-2);
		
	}//end FixBinaryRecursive
	
 
	
	//n is the number of disks
	//s is source
	//d is destination
	//t is temp, or other post
	// function prints out the steps to solve any hanoi tower problem
	public static void HanoiTower(int n, int s, int d, int t) {
		
		if (n <= 0) return;
		
		HanoiTower(n-1,s,t,d);
		
		System.out.println( "move disk "+ n +" from post "+ s +" to post "+ d );
		
		HanoiTower(n-1,t,d,s);
		
		}//end HanoiTower
	
	
	
	public static String showCallLevel(int L, int curl) {
		
		if ( L == 0 ) return "";
		
		for ( int i = 0 ; i < curl ; i++ ) {
			answer += " ";
		}//end for loop
		
		answer = answer + "This was written by call number " + curl  + "x.\n";
		
		
		
		showCallLevel (L-1, curl+1);
		
		for ( int i = 0 ; i < curl ; i++ ) {
			answer += " ";
		}//end for loop
		
		
		answer = answer + "This was written by call number " + curl  + "y.\n";
		
		return answer;
		
	}//end showCallLevel
	
	
	public static void binaryPrint ( int n ) {
		
		if ( n < 2 ) {
			System.out.print(n);
			return;
		}//end if
		
		binaryPrint ( n / 2 );
		
		System.out.print( n % 2 );
		
	}//end binaryPrint
	
	public static void pattern ( int stars, int spaces ) {
		
		if ( stars == 1 ) {
			for(int i=0; i < spaces ; i++ )
				System.out.print(" ");
			System.out.println("*");
		}
		else {
			
			pattern( stars/2 , spaces);
			for ( int i = 0; i < spaces; i++)
				System.out.print(" ");
			
			for ( int j = 0; j < stars; j++ )
				System.out.print("* ");
			System.out.println();
			
			pattern( stars/2, spaces + stars);
		}//end else
		
	}//end pattern
	
	public static void main ( String args[] ) {
		System.out.println( "Testing fibBinaryRecursive:\n" );
		System.out.println( FibBinaryRecursive(10) );
		
		System.out.println( "---------------------------------------------------\nTesting HanoiTower(3,1,3,2):\n" );
		HanoiTower(3,1,3,2);
		
		System.out.println( "---------------------------------------------------\nTesting showCallLevel(4,1):\n" );
		System.out.println( showCallLevel(4,1) );
		
		System.out.println( "---------------------------------------------------\nTesting binaryPrint(3,6,10,50):\n" );
		binaryPrint(3);
		System.out.println();
		binaryPrint(6);
		System.out.println();
		binaryPrint(10);
		System.out.println();
		binaryPrint(50);
		System.out.println();
		
		System.out.println( "---------------------------------------------------\nTesting pattern(8,0):\n" );
		pattern(8,0);
		
		
		
		
		
		
	}//end main
	
	
} //end class