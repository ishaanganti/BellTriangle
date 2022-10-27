/*import java.util.*;

public class BellTriangle {
	public static void main(String[] args) {

		//creating scanner object 
		Scanner console = new Scanner(System.in);
		System.out.print("Enter how many rows of the Bell Triangle, with a minimum of 2 rows, you would like to see: ");

		//number of rows and creating 2d array for bell triangle
		int numOfRows = console.nextInt();
		int[][] bell_num_triangle = new int[numOfRows][numOfRows];

		//first two rows of bell triangle
		bell_num_triangle[0][0] = 1;
		bell_num_triangle[1][0] = 1;
		bell_num_triangle[1][1] = 2;


		//rest of the rows of bell triangle
		for(int k = 1; k <= numOfRows-2; k++) {
			for(int i = 1; i<= 2+k; i++) {
				if(i-1 == 0) {
					bell_num_triangle[2+k-1][i-1] = bell_num_triangle[2+k-1-1][k];
				}

				else {
					bell_num_triangle[2+k-1][i-1] = bell_num_triangle[2+k-1][i-2] + bell_num_triangle[2+k-1-1][i-2];
				}
			}
		}

		//space padding variable
		int paddingSpacesNum = 3+(1+(int)(Math.log(bell_num_triangle[numOfRows-1][numOfRows-1])/Math.log(10)));
		String paddingSpaces = "%-" + paddingSpacesNum +"d";

		//printing bell triangle (formatted)
		for(int k = 0; k < numOfRows; k++) {
			for(int i = 0; i<= k; i++) {
				System.out.printf(paddingSpaces, bell_num_triangle[k][i]);
			}
			System.out.println();
		}
	}
} */

/*
The first part of this code is printing the Bell Triangle and printing the Bell Numbers within the Bell Triangle in red.
The second part of this code is calculating the Bell Numbers using a recursive relationship, which I can derive. It includes
methods for n! and nCk as a part of implementing the recursive relationship into java.
 */

import java.sql.SQLOutput;
import java.util.*;

public class BellTriangle {

    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {

        //creating scanner object
        Scanner console = new Scanner(System.in);
        System.out.print("Enter how many rows of the Bell Triangle, with a minimum of 2 rows, you would like to see: ");

        //number of rows and creating 2d array for bell triangle
        int numOfRows = console.nextInt();
        int[][] bell_num_triangle = new int[numOfRows][numOfRows];

        //first two rows of bell triangle
        bell_num_triangle[0][0] = 1;
        bell_num_triangle[1][0] = 1;
        bell_num_triangle[1][1] = 2;

        //rest of the rows of bell triangle
        for(int k = 1; k <= numOfRows-2; k++) {
            for(int i = 1; i<= 2+k; i++) {
                if(i-1 == 0) {
                    bell_num_triangle[2+k-1][i-1] = bell_num_triangle[2+k-1-1][k];
                }
                else {
                    bell_num_triangle[2+k-1][i-1] = bell_num_triangle[2+k-1][i-2] + bell_num_triangle[2+k-1-1][i-2];
                }
            }
        }

        //space padding variable
        int paddingSpacesNum = 3+(1+(int)(Math.log(bell_num_triangle[numOfRows-1][numOfRows-1])/Math.log(10)));
        String paddingSpaces = "%-" + paddingSpacesNum +"d";

        //printing bell triangle (formatted)
        for(int k = 0; k < numOfRows; k++) {
            for(int i = 0; i<= k; i++) {
                if(i == k || i==0) {
                    System.out.printf(paddingSpaces, bell_num_triangle[k][i]);
                }
                else {
                    System.out.printf(paddingSpaces, bell_num_triangle[k][i]);
                }
            }
            System.out.println();
        }

        CalcBellNumbers(numOfRows);
    }

//PART 2; Bell Nums via recursion!

    public static void CalcBellNumbers(int numOfRows) {
        ArrayList<Integer> bellNums = new ArrayList<Integer>();

        //current value at a given point
        int current_val = 0;

        //this is b0, our starting point for the recursive relationship
        bellNums.add(1);

        //equal to n, so B(n+1) when counter = 0 will give B_1
        int n = 0;

        //recursive loop
        for(int i = 1; i <= numOfRows; i++) {

            for(int k = 0; k<= n; k++) {
                current_val += nCk(n, k)*bellNums.get(k);
            }

            bellNums.add(current_val);
            current_val = 0;
            n++;
        }

        //printing the bell numbers
        System.out.print("\nHere are the bell numbers calculated via recursion on display in your triangle: ");
        for(int i = 1; i <= numOfRows; i++) {
            if(i == numOfRows){
                System.out.print(bellNums.get(i) + ".");
            }
            else {
                System.out.print(bellNums.get(i) + ", ");
            }
        }
    }

    //n choose k method

    public static int nCk(int n, int k) {
        return (factorial(n))/(factorial(n-k)*factorial(k));
    }

    //n! method
    public static int factorial(int n) {
        int n_factorial = 1;
        for(int i = 1; i <= n; i++){
            n_factorial = n_factorial*i;
        }
        return n_factorial;
    }
}