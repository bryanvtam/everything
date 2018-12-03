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
        int[] answers = new int[2];
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
    	   answer = (addition(numer1,numerator2,deno1,denominator2));
    	   answers = addition(frac1, frac2);
       }
       else if(operation.equals("-")) {
    	   answer = (subtraction(numer1,numerator2,deno1,denominator2));
    	   answers = subtraction(frac1, frac2);
       }
       else if(operation.equals("*")) {
    	   answer = (multiplication(numer1,numerator2,deno1,denominator2));
    	   answers = multiplication(frac1,frac2);
       }
       else if(operation.equals("/")) {
    	   answer = (division(numer1,numerator2,deno1,denominator2));
    	   answers = division(frac1,frac2);
       }
        return (answer);
        //return ("whole:"+ wholenum1 + " numerator:" + numerator1 + " denominator:" + denominator1);
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String addition (int numerator1, int numerator2,int denominator1, int denominator2) {
    	int m1 =(lcm(denominator1,denominator2))/denominator1;
    	int m2 =(lcm(denominator1,denominator2))/denominator2;
    	int newnumerator = ((numerator1*m1)+(numerator2*m2));
    	String answer = toMix(reduce(newnumerator + "/" + (lcm(denominator1,denominator2))));
    	return answer;
    }
    
    public static String subtraction (int numerator1, int numerator2,int denominator1, int denominator2) {
    	int m1 =(lcm(denominator1,denominator2))/denominator1;
    	int m2 =(lcm(denominator1,denominator2))/denominator2;
    	int newnumerator = ((numerator1*m1)-(numerator2*m2));
    	String answer = toMix(reduce(newnumerator + "/" + (lcm(denominator1,denominator2))));
    	return answer;
    }
    
    public static String multiplication (int numerator1, int numerator2, int denominator1, int denominator2) {
    	int newnumerator = numerator1*numerator2;
    	int newdenominator = denominator1*denominator2;
    	String answer = toMix(reduce(newnumerator + "/" + newdenominator));
    	return answer;
    }
    
    public static String division (int numerator1, int numerator2, int denominator1, int denominator2) {
    	int newnumerator = numerator1*denominator2;
    	int newdenominator = denominator1*numerator2;
    	String answer = toMix(reduce(newnumerator + "/" + newdenominator));
    	return answer;
    }
    
    public static int lcm(int denominator1, int denominator2) {
    	int multiply = 1;
    	if(denominator1 != denominator2) {
    		while((denominator1*multiply)%denominator2 !=0) {
    			multiply++;
    		}
    	}
    		return (denominator1*multiply);
    }
    
    public static String reduce(String input) {	
    	int numerator = (Integer.parseInt(input.split("/")[0]));
    	int denominator = (Integer.parseInt(input.split("/")[1]));
    	int gcd = gcd(numerator, denominator);
    	
    	return((numerator/gcd) + "/" + (denominator/gcd));
    }
    
    public static int gcd(int a, int b) {
    	if(b == 0) {
    		return a;
    	}
    	return gcd(b, a%b);
    }
    
    public static String toMix (String input) {
    	int newnumerator = Integer.parseInt(input.split("/")[0]);
    	int newdenominator = Integer.parseInt(input.split("/")[1]);
    	int wholenum = (newnumerator/newdenominator);
    	int remainder = (newnumerator%newdenominator);
    	if(newdenominator<0) {
    		newdenominator = newdenominator*(-1);
    		newnumerator = newnumerator*(-1);
    	}
    	if (remainder <0) {
    		remainder = remainder*(-1);
    	}
    	if(wholenum == 0) {
    		if(remainder == 0) {
    			return(Integer.toString(wholenum));
    		}
    		else {
    		return(remainder+"/"+newdenominator);
    		}
    	}
    	else {
    		return ( wholenum + "_" + remainder +"/" + newdenominator);
    	}
    }
    
   //=========================================================== METHODS USING ARRAYS, GCD STAYS THE SAME =========================================================================
    
    public static int[] addition (int[] frac1 , int[] frac2) {
    	int[] answer = new int[2];
    	answer[1]=lcm(frac1[1],frac2[1]);
    	answer[0]=(frac1[0]*(answer[1]/frac1[1])) + (frac2[0]*(answer[1]/frac2[1]));

    	return answer;
    }
    
    public static int[] subtraction(int[] frac1, int[] frac2) {
    	int[] answer = new int[2];
    	answer[1]=lcm(frac1[1],frac2[1]);
    	answer[0]=(frac1[0]*(answer[1]/frac1[1])) - (frac2[0]*(answer[1]/frac2[1]));

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
    	int remainder = (numerator%denominator);
    	int wholenum = (numerator/denominator);
    	String answer = "";
    	if (wholenum == 0) {
    		if (denominator < 0) {
    			denominator *= (-1);
    			numerator *= (-1);
    			answer = (numerator + "/" + denominator);
    		}
    		else if(numerator == 0) {
    			answer =  "0";
    		}
    		else {
    			answer = (numerator + "/" + denominator);
    		}
    	}
    	else {
    		if(numerator < 0 ) {
    			numerator *= (-1);
    			answer = (wholenum + "_" + numerator + "/" + denominator);
    		}
    		else if (denominator < 0) {
    			denominator *= (-1);
    			answer = (wholenum + "_" + numerator + "/" + denominator);
    		}
    		else if(numerator == 0) {
    			answer =  Integer.toString(wholenum);
    		}
    	}  
    	return answer;
    }
    
}