import java.math.BigDecimal;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.ArithmeticException;

public class Coursework2 {

	public static void main(String[] args) {
			
		probablePrime(BigInteger.valueOf(2607L));
		actualPrime(BigInteger.valueOf(26807L));
		boolean flag = efficientPrimeCheck(BigInteger.valueOf(2685735182053607L));
				if (flag) {
		            System.out.println("2685735182053607 is a prime number.");
		            }
		        else {
		            System.out.println("2685735182053607 is not a prime number.");
		            }
		
	}
		//use Fermant's little thoerem to assess whether the number is a PROBABLE prime
		public static boolean probablePrime(BigInteger number) {
			boolean flag=false;
			
			for(BigInteger i = BigInteger.valueOf(2); i.compareTo(number.subtract(BigInteger.ONE))<0; i=i.add(BigInteger.ONE)) {
				if(i.modPow((number.subtract(BigInteger.ONE)),number) ==BigInteger.ZERO){
					flag=true;
					break;
				}
			}
			System.out.println("Is "+number+" a prime? -> "+ flag);
			return flag;
		}
		
		public static boolean actualPrime(BigInteger number) {
			boolean flag = false;
	        for(BigInteger i = BigInteger.valueOf(2); i.compareTo(number.divide(BigInteger.valueOf(2)))<0; i=i.add(BigInteger.ONE))
	        {
	        	
	            // condition for nonprime number
	            if(number.mod(i).equals(BigInteger.ZERO))
	            {
	                flag = true;
	                break;
	            }
	        }

	        if (!flag) {
	            System.out.println(number + " is a prime number.");
	            }
	        else {
	            System.out.println(number + " is not a prime number.");
	            }
	        return flag;
	    }
		
		public static boolean efficientPrimeCheck(BigInteger n) {
		    if(n.compareTo(BigInteger.valueOf(2)) < 0) return false;
		    if(n.compareTo(BigInteger.valueOf(2)) == 0 || n.compareTo(BigInteger.valueOf(3))==0) return true;
		    if(n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO) || n.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO)) return false;
		    long sqrtN = (long)Math.sqrt(n.longValue())+1;
		    for(long i = 6L; i <= sqrtN; i += 6) {
		        if(n.mod(BigInteger.valueOf(i).subtract(BigInteger.ONE)).equals(BigInteger.ZERO) || n.mod(BigInteger.valueOf(i).add(BigInteger.ONE)).equals(BigInteger.ZERO)) return false;
		    }
		    return true;
		}
			

}
