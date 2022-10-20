import java.lang.Math;

public class Lab2ex 
{
	public static void main(String[] args) 
	{
		double sum = 0;
		//long S = 0;
		double array[];
		double size = 64;
		int i;
		array = new double[64];
		for(i = 0; i < size; i++)
		{
			array[i] = Math.pow(2, i-1);
			sum += array[i];
		}
		for(i = 1; i < size; i++)
		{
			System.out.println(array[i] + " - this represents 2^" + (i-1));
		}
		
		System.out.println(sum);
		
		//Integer
		int myInt = Integer.MAX_VALUE;
		System.out.println(myInt + ": Integer");
		myInt++;
		System.out.println(myInt + ": Integer + 1");
		myInt--;
		System.out.println(myInt + ": Integer - 1");
		
		//Short
		short myShort = Short.MAX_VALUE;
		System.out.println(myShort + ": Short");
		myShort++;
		System.out.println(myShort + ": Short + 1");
		myShort--;
		System.out.println(myShort + ": Short - 1");
		
		//Byte
		byte myByte = Byte.MAX_VALUE;
		System.out.println(myByte + ": Byte");
		myByte++;
		System.out.println(myByte + ": Byte + 1");
		myByte--;
		System.out.println(myByte + ": Byte - 1");
		
		//Long
		long myLong = Long.MAX_VALUE;
		System.out.println(myLong + ": Long");
		myLong++;
		System.out.println(myLong + ": Long + 1");
		myLong--;
		System.out.println(myLong + ": Long - 1");
		
		//Float
		float myFloat = Float.MAX_VALUE;
		System.out.println(myFloat + ": Float");
		myFloat++;
		System.out.println(myFloat + ": Float + 1");
		myFloat--;
		System.out.println(myFloat + ": Float - 1");
		
		//Double
		double myDouble = Double.MAX_VALUE;
		System.out.println(myDouble + ": Double");
		myDouble++;
		System.out.println(myDouble + ": Double + 1");
		myDouble--;
		System.out.println(myDouble + ": Double - 1");
		
		//Char
		char myChar = Character.MAX_VALUE;
		System.out.println(myChar + ": Char");
		myChar++;
		System.out.println(myChar + ": Char + 1");
		myChar--;
		System.out.println(myChar + ": Char - 1");
	}
}