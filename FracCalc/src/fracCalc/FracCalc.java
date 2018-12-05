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
        int wholeN1 = 0;
        int numer1 = 0;
        int deno1 = 1;
        int wholenum2 = 0;
        int numerator2 = 0;
        int denominator2 = 1;
        int[] frac1 = {numer1,deno1};
        int[] frac2 = {numerator2, denominator2};
        String answer = "";
        //SEPERATES OPERAND1 INTO WHOLEN NUMBER, NUMERATOR, AND DENOMINATOR
        if (operand1.contains("_")) {
        	wholeN1 = Integer.parseInt(operand1.split("_")[0]);
        	deno1 = Integer.parseInt((operand1.split("_")[1]).split("/")[1]);
        	
        	frac1[1] = Integer.parseInt((operand1.split("_")[1]).split("/")[1]);
        	
        	if (wholeN1 > 0) {
        		numer1 = (((Integer.parseInt((operand1.split("_")[1]).split("/")[0]))) + (deno1)*wholeN1); 
        	}
        	else if (wholeN1 < 0) {
        		numer1 = (((deno1)*wholeN1)-((Integer.parseInt((operand1.split("_")[1]).split("/")[0])))); 
        		
        	}
        	frac1[0] = numer1;
        	frac2[1] = deno1;
        }
        else if (operand1.contains("/")) {
        	numer1 = Integer.parseInt(operand1.split("/")[0]);
    		deno1 = Integer.parseInt(operand1.split("/")[1]);
        }
        else {
        	numer1 = Integer.parseInt(operand1);
        	wholeN1 = Integer.parseInt(operand1);
        }
        
        //SEPERATES OPERAND2 INTO WHOLEN NUMBER, NUMERATOR, AND DENOMINATOR
        if (operand2.contains("_")) {
        	wholenum2 = Integer.parseInt(operand2.split("_")[0]);
        	denominator2 = Integer.parseInt((operand2.split("_")[1]).split("/")[1]);
        	if (wholenum2 > 0) {
        		numerator2 = (((Integer.parseInt((operand2.split("_")[1]).split("/")[0]))) + (denominator2)*wholenum2); 
        	}
        	else if (wholenum2 < 0) {
        		numerator2 = (((denominator2)*wholenum2)-((Integer.parseInt((operand2.split("_")[1]).split("/")[0])))); 
        		
        	}
        	//numerator2 = (((Integer.parseInt((operand2.split("_")[1]).split("/")[0])))+ denominator2*wholenum2); //multiply by wholenum3 for checkpoint3
        	frac2[0] = numerator2;
        	frac2[1] = denominator2;
        }
        else if (operand2.contains("/")) {
        	numerator2 = Integer.parseInt(operand2.split("/")[0]);
    		denominator2 = Integer.parseInt(operand2.split("/")[1]);
        }
        else {
        	wholenum2 = Integer.parseInt(operand2);
        	numerator2 = Integer.parseInt(operand2);
        }
       
       //CHECK AND CHOOSE OPERATIONS
       if (operation.equals("+")){
    	   answer = toMixnum(reduce(addition(frac1, frac2)));
       }
       else if(operation.equals("-")) {
    	   answer = toMixnum(reduce(subtraction(frac1, frac2)));
       }
       else if(operation.equals("*")) {
    	   answer = toMixnum(reduce(multiplication(frac1,frac2)));
       }
       else if(operation.equals("/")) {
    	   answer = toMixnum(reduce(division(frac1,frac2)));
       }
        return (answer);
        //return ("whole:"+ wholenum1 + " numerator:" + numerator1 + " denominator:" + denominator1);
    }
   //================================ METHODS USING ARRAYS, GCD STAYS THE SAME =========================================================================
    public static int gcd(int a, int b) {
    	if(b == 0) {
    		return a;
    	}
    	return gcd(b, a%b);
    }
    public static int[] addition (int[] frac1 , int[] frac2) {
    	int[] answer = new int[2];
    	answer[0] = (frac1[0] * frac2[1]) + (frac2[0] + frac1[1]);
    	answer[1] = (frac1[1] * frac2[1]);

    	return answer;
    }
    
    public static int[] subtraction(int[] frac1, int[] frac2) {
    	int[] answer = new int[2];
    	answer[0] = (frac1[0] * frac2[1])- (frac2[0] * frac1[1]);
    	answer[1] = (frac1[1] * frac2[1]);

    	return answer;
    }
    
    public static int[] multiplication(int[] frac1, int[] frac2) {
    	int[] answer = new int[2];
    	answer[0] = frac1[0] * frac2[0];
    	answer[1] = frac1[1] * frac2[1];
    	
    	return answer;
    }
    
    public static int[] division(int[] frac1, int[] frac2) {
    	int[] answer = new int[2];
    	answer[0] = frac1[0] * frac2[1];
    	answer[0] = frac1[1] * frac2[0];
    	
    	return answer;
    }
    
    public static int[] reduce(int[]input) {
    	int divide =gcd(input[0],input[1]);
    	int[] answer = {(input[0]/divide), (input[1]/divide)};
    	return answer;
    }
    
    public static String toMixnum(int[]reducedfrac) {
    	int numerator = reducedfrac[0];
    	int denominator = reducedfrac[1];
    	
    	if (denominator < 0) {
    		numerator *= (-1);
    		denominator *= (-1);
    	}
    	
    	int remainder = numerator % denominator;
    	int wholenum = numerator/denominator;
    	String answer = "";
    	
    	if(numerator != 0) {
    		if (wholenum != 0) {
    			if(remainder == 0 ) {
    				answer = Integer.toString(wholenum);
    			}
    			else if(remainder < 0) {
    				remainder *= (-1);
    				answer = (wholenum + "_" + remainder +"/" + denominator);
    			}
    		}
    		else {
    			answer = (remainder + "/" + denominator);
    		}
    	}
    	else {
    		answer = "0";
    	}
    	
    	return answer;
    }
    
}