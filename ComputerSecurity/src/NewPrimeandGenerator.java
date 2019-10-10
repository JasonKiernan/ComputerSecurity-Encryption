import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class NewPrimeandGenerator {

	public static void main(String[] args) {
		// generate a probable prime with length 17 digits. We need about 54 bits to give a 17 digit number
		Random rnd = new Random();
		BigInteger prime = BigInteger.probablePrime(54, rnd);
		//check  to see that it is an actual prime
		boolean flag = efficientPrimeCheck(prime);
		if (flag) {
            System.out.println(prime+" is a prime number.");
            }
        else {
            System.out.println(prime+" is not a prime number.");
            }		
		
//		q is a prime number
//		p = 2q + 1 is a prime number
//		p will be used for Z*p
		
		BigInteger q = BigInteger.probablePrime(3, rnd);
		BigInteger q1 = null;
		//q must divide p-1 evenly
		if(((prime.subtract(BigInteger.ONE)).mod(q)).equals(BigInteger.ZERO)){
			q1=((prime.subtract(BigInteger.ONE)).divide(q));
			System.out.println("Divides evenly");
		}
		else {
			q1=BigInteger.valueOf(1L);
			System.out.println("Doesn't divide evenly so we reject this value");
		}
		
		boolean flag1 = efficientPrimeCheck(q);
		if (flag1) {
            System.out.println(q+" is a prime number.");
            }
        else {
            System.out.println(q+" is not a prime number.");
            }		
		
		BigInteger generator = getGenerator(prime,q);
		System.out.println("The Generator is: "+generator);
		
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
	

	public static BigInteger getGenerator(BigInteger p, BigInteger q){

		BigInteger generator = null;

		for(generator = BigInteger.valueOf(2); generator.compareTo(p.subtract(BigInteger.ONE))<0; generator=generator.add(BigInteger.ONE))
		{
			
		    if(generator.modPow(BigInteger.valueOf(2), p).equals(BigInteger.ONE)) //if (g^2 = 1 mod p) then go to the next number 
		    {
		        continue;
		    }
		    //TODO: make a method that works with BigInteger^BigInteger. This is hackey and limits us to 32 bits
		    if((generator.modPow(q, p)).equals(BigInteger.ONE)) //if (g^q != 1modp) then go to the next number
		    {
		        continue; //next number!
		    }
		    //TODO: randomly generate then test. Sequential isn't really best here...just for testing purposes
		    else
		    {
		        return generator; //return the first one we find for simplicity's sake
		    }
		}


		return generator; 
		}
	
	
	
}
