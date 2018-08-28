package others;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Temperature {
	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        System.out.println("The number of temperatures to analyse: ");
        int n = in.nextInt();
        
        for (int i = 0; i < n; i++) {
        	System.out.println("A temperature expressed as an integer ranging from -273 to 5526: ");
            int t = in.nextInt();
            if (t >= -173 && t <= 5526) {
                if (i == 0) {
                    result = t;
                } else if (Math.abs(t) == Math.abs(result)) {
                	if(t > result) {
                		result = t;                		
                	}
                } else if (Math.abs(t) <= Math.abs(result)) {
                	result = t;
                }
            }
        }
        
        // Write an action using System.out.println()
        System.out.println("result: " + result);
        in.close();
    }
}
