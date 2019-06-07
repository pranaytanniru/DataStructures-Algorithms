import java.io.*;

class Java {
	public static void main (String[] args) {
    long a=System.currentTimeMillis();
    for(int i=0;i<1000000000;i++){

    }
    long b=System.currentTimeMillis();
    System.out.println("Execution time for Java "+((b-a)/1000)+" seconds");
	}
}

// output:
// Execution time for Java 0 seconds
