package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userinput = new Scanner(System.in);
    	String holder = ("");
    	while (!holder.toUpperCase().equals("QUIT")) {
    		System.out.println("Please give a an expression:");
    		holder = (userinput.nextLine());
    		System.out.println(produceAnswer(holder));
    		
    	}
    	userinput.close();
    }

    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	// VARIABLES
        String operand1 = (input.split(" "))[0];
        String operation = (input.split(" "))[1];
        String operand2 = (input.split(" "))[2];
        int wholenum1 = 0;
        int numerator1 = 0;
        int denominator1 = 1;
        int wholenum2 = 0;
        int numerator2 = 0;
        int denominator2 = 1;
        
        //Seperating the fraction of operand1
        if (operand1.contains("_")) {
        	wholenum1 = Integer.parseInt(operand1.split("_")[0]);
        	numerator1 = Integer.parseInt((operand1.split("_")[1]).split("/")[0]);
        	denominator1 = Integer.parseInt((operand1.split("_")[1]).split("/")[1]);
        }
        else if (operand1.contains("/")) {
        	numerator1 = Integer.parseInt(operand1.split("/")[0]);
    		denominator1 = Integer.parseInt(operand1.split("/")[1]);
        }
        else {
        	wholenum1 = Integer.parseInt(operand1);
        }
        System.out.println("whole:"+ wholenum1 + " numerator:" + numerator1 + " denominator:" + denominator1);
        
        //Seperating the fraction of operand2
        if (operand2.contains("_")) {
        	wholenum2 = Integer.parseInt(operand2.split("_")[0]);
        	numerator2 = Integer.parseInt((operand2.split("_")[1]).split("/")[0]);
        	denominator2 = Integer.parseInt((operand2.split("_")[1]).split("/")[1]);
        }
        else if (operand2.contains("/")) {
        	numerator2 = Integer.parseInt(operand2.split("/")[0]);
    		denominator2 = Integer.parseInt(operand2.split("/")[1]);
        }
        else {
        	wholenum2 = Integer.parseInt(operand2);
        }
        
        return ("whole:"+ wholenum2 + " numerator:" + numerator2 + " denominator:" + denominator2);
    }
    // TODO: Fill in the space below with any helper methods that you think you will need

}