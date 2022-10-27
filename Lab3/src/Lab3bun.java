import java.lang.Math;
import java.math.BigInteger;

public class Lab3bun {
	
	static boolean isPrime (int n) {
		boolean prime = true;
		if(n == 0 || n == 1)
			prime = false;
		else
			for(int i = 2; i <= n/2; i++) {
				if(n % i == 0) {
					prime = false;
					break;
				}
			}
		return prime;
	}
	
	static void goldbach(int n) {
		int i = 2;
		for(int j = n - i; j > 2; j--) {
			if(isPrime(i) == true && isPrime(j) == true) {
				System.out.println(n + " = " + i + " + " + j);
				break;
			}
			else
				if(j == 3)
					System.out.println("The number " + n + " cannot be written as a sum of 2 prime numbers");
			i++;
		}
	}
	
	public static void main(String[] args) {
		// 6.1
		
		int total_cases_1, total_cases_2; // first one for 6/49, second one for 5/40
		total_cases_1 = 44*3*46*47*49; // we need to calculate combinations of 49 taken 6; this is the result after all the simplifications are done
		System.out.println("The odds of winning a 6 out of 49 lottery are 1 in " + total_cases_1);
		total_cases_2 = 12*37*38*39; // here, we need to calculate combinations of 40 taken 5; this is the simplified result
		System.out.println("The odds of winning a 5 out of 40 lottery are 1 in " + total_cases_2);
		System.out.println();
		
		// 6.2 and 6.3
		
		short packed_info = 0;
		
		int min = 1, max = 49, range = max - min + 1, number;
		for(int i = 1; i <= 6; i++)
		{
			number = (int)(Math.random() * range) + min; // i saw that math.random returns a double type, so i converted it to an integer
			if(i == 1)
				System.out.println("The " + i + "st number extracted from the lottery is: " + number);
			else if(i == 2)
				System.out.println("The " + i + "nd number extracted from the lottery is: " + number);
			else if (i == 3)
				System.out.println("The " + i + "rd number extracted from the lottery is: " + number);
			else
				System.out.println("The " + i + "th number extracted from the lottery is: " + number);
			packed_info = (short)(number << 6);
		}
		System.out.println();
		for(int i = 1; i <= 6; i++)
		{
			System.out.println(packed_info & 0x6f); // i tried, i don't get how this works. if you could briefly explain it to me when you look through this, i would appreciate it :)
		}
		
		System.out.println();
		
		// 6.6
		
		goldbach(22);
		goldbach(14);
		goldbach(11);
		
	}
}
