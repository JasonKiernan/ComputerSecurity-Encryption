class Generator { 
      
  
// Function to return gcd of a and b 
static int gcd(int a, int b) 
{ 
    if (a == 0) 
        return b; 
    return gcd(b%a, a); 
} 
  
// Print generators of n 
static void printGenerators(int n) 
{ 
    // 1 is always a generator 
    System.out.println("1 "); 
  
    for (int i=2; i < n; i++) 
  
        // A number x is generator of GCD is 1 
        if (gcd(i, n) == 1) 
            System.out.println(i +" "); 
} 
  
// Driver program to test above function 
public static void main(String args[]) 
{ 
    int n = 10; 
    printGenerators(n); 
} 
} 
