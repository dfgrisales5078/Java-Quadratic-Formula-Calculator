import java.util.Scanner; // Import scanner.

public class QuadraticRootCalculator {
	  
	//Method to calculate value of discriminant
	static double discr(double a, double b, double c) { 
	    double result = (b * b ) - (4 * a * c);
	    return result;
	}
	
	//Method to calculate root #1	
	static double CalcRoot1(double a, double b, double c) {
		double di = discr(a, b, c);
    	return(-b + Math.sqrt(di))/(2*a);
	}
 
	//Method to compute root #2
    static double CalcRoot2(double a, double b, double c) {
    	double di = discr(a, b, c);
		return(-b - Math.sqrt(di))/(2*a);
    }
    
    //method to read coefficients a, b and c from user
 	static double ReadCoeff() {
 		Scanner inp = new Scanner(System.in); // Declaration and creation of object.
 		int k = 0;     
 		double x = 0;  
 		for (k=0; k<3; k++) {
			System.out.print("Please enter a coefficient: "); // ask the user for input.
				try {
					x = inp.nextDouble(); // method to read double from user.
					break;
				}
				catch (Exception e) { //exception is handled here in case something other than an integer is entered. 
					inp.nextLine();
					System.out.println("Please enter a number."); //
					
				}
		}	
		if (k==3) { //The third time a non integer is entered, this message will be displayed and program will exit. 
			System.out.println("Value entered incorrectly 3 times. The program will now exit.");
			System.exit(0);
		}
		return x;
 	} 
	
 	//Method used to display roots of the coefficients entered, or a message saying there are no roots.
    static void OutResults(double a, double b, double c, double x1, double x2, boolean flag) {
		
		// if the discriminant is more than or equal to zero, it will calculate root1 and root2 with the given coefficients.
    	if (flag == true) { 
			// prints message with coefficients entered and both calculated roots.
			System.out.println("\nQuadratic equation with the following coefficients"  
					+ "\na: <" + a + ">;" + " b: <" + b + ">;" + " c: <" + c + "> "
					+ "\nhas the following roots: <" + x1 + "> and <" + x2 +">");
		}
	
		else {  // if the discriminant is negative, it will not calculate the roots. 
			// prints message with coefficients and says quadratic equation does not have roots.
			System.out.println("\nQuadratic equation with the following coefficients:" 
					+ "\na: <" + a + ">;" + " b: <" + b + ">;" + " c: <" + c 
					+ "> does not have roots.");
		}
    }
    	
    
	public static void main(String args[]) {
		
		int iterations = 0;
		try {
			String str; // declaration of a String variable 
			str = args[0]; // first string in the command line assigned to str
			iterations = Integer.parseInt(str);  // converting a String to an int
	
		}
		catch (ArrayIndexOutOfBoundsException | NumberFormatException e) { // if no parameters or something other than a integer is entered
			System.out.println("Please enter a positive integer in the command line."); // This message will be printed
			System.exit(0);
		}
	
		if (iterations <= 0) {  // if number entered in command line is not positive, this message will be printed:
			System.out.println("Please enter a positive integer in the command line.");
		}
	
		// for loop used to read coefficients and calculate as many roots as entered in the command line
		for (int i = 0; i < iterations; i++ ) { 
			
			double a = ReadCoeff(); //call to method ReadCoeff(), to read coefficient a 
			while (a == 0) { // if zero is entered for coefficient a, print message and prompt for coefficient a again. 
				System.out.println("Coefficient a cannot be a zero. Enter the correct value.");
				a = ReadCoeff();
			}
			double b = ReadCoeff(); //call to method ReadCoeff(), to read coefficient b	
			double c = ReadCoeff(); //call to method ReadCoeff(), to read coefficient c
			
			double discriminant = discr(a, b, c); //calculates the value of the discriminant 
			
			// if the discriminant is more than or equal to zero, it will calculate root1 and root2 with the given coefficients.
			if (discriminant >= 0) { 
				double x1 = CalcRoot1(a, b, c); 	//calculates root 1
				double x2 = CalcRoot2(a, b, c); 	//calculates root 2
				boolean flag = true; 				//when discriminant is more than or equal to zero, boolean flag is true. 
				OutResults(a, b, c, x1, x2, flag);  //prints out coefficients entered along with the calculated roots 
		
			}
			
			// if the discriminant less than zero, a message will be displayed saying there are no roots. 
			else {  
				double x1 = CalcRoot1(a, b, c);		
				double x2 = CalcRoot2(a, b, c);
				boolean flag = false;				 // when discriminant is more than or equal to zero, boolean flag is false.
				OutResults(a, b, c, x1, x2, flag);   // prints out coefficients entered along with a message saying they dont have roots. 
			}

		}
	}

		
}
