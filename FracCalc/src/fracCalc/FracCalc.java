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
        int[] frac1 = {numerator1,denominator1};
        int[] frac2 = {numerator2, denominator2};
        String answer = "";
        //SEPERATES OPERAND1 INTO WHOLEN NUMBER, NUMERATOR, AND DENOMINATOR
        if (operand1.contains("_")) {
        	wholenum1 = Integer.parseInt(operand1.split("_")[0]);
        	denominator1 = Integer.parseInt((operand1.split("_")[1]).split("/")[1]);
        	if (wholenum1 > 0) {
        		numerator1 = (((Integer.parseInt((operand1.split("_")[1]).split("/")[0]))) + (denominator1)*wholenum1); 
        	}
        	else if (wholenum1 < 0) {
        		numerator1 = (((denominator1)*wholenum1)-((Integer.parseInt((operand1.split("_")[1]).split("/")[0])))); 
        		
        	}
        	frac1[0] = numerator1;
        }
        else if (operand1.contains("/")) {
        	numerator1 = Integer.parseInt(operand1.split("/")[0]);
    		denominator1 = Integer.parseInt(operand1.split("/")[1]);
        }
        else {
        	numerator1 = Integer.parseInt(operand1);
        	wholenum1 = Integer.parseInt(operand1);
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
        	frac2[0]= numerator2;
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
    	   answer = (addition(numerator1,numerator2,denominator1,denominator2));
       }
       else if(operation.equals("-")) {
    	   answer = (subtraction(numerator1,numerator2,denominator1,denominator2));
       }
       else if(operation.equals("*")) {
    	   answer = (multiplication(numerator1,numerator2,denominator1,denominator2));
       }
       else if(operation.equals("/")) {
    	   answer = (division(numerator1,numerator2,denominator1,denominator2));
       }
        return (answer);
        //return ("whole:"+ wholenum1 + " numerator:" + numerator1 + " denominator:" + denominator1);
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String addition (int numerator1, int numerator2,int denominator1, int denominator2) {
    	int m1 =(lcm(denominator1,denominator2))/denominator1;
    	int m2 =(lcm(denominator1,denominator2))/denominator2;
    	int newnumerator = ((numerator1*m1)+(numerator2*m2));
    	String answer = (newnumerator + "/" + (lcm(denominator1,denominator2)));
    	return answer;
    }
    
    public static String subtraction (int numerator1, int numerator2,int denominator1, int denominator2) {
    	int m1 =(lcm(denominator1,denominator2))/denominator1;
    	int m2 =(lcm(denominator1,denominator2))/denominator2;
    	int newnumerator = ((numerator1*m1)-(numerator2*m2));
    	String answer = (newnumerator + "/" + (lcm(denominator1,denominator2)));
    	return answer;
    }
    
    public static String multiplication (int numerator1, int numerator2, int denominator1, int denominator2) {
    	int newnumerator = numerator1*numerator2;
    	int newdenominator = denominator1*denominator2;
    	String answer = (newnumerator + "/" + newdenominator);
    	return answer;
    }
    
    public static String division (int numerator1, int numerator2, int denominator1, int denominator2) {
    	int newnumerator = numerator1*denominator2;
    	int newdenominator = denominator1*numerator2;
    	String answer = (newnumerator + "/" + newdenominator);
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
    	if(wholenum == 0) {
    		return(remainder+"/"+newdenominator);
    	}
    	else if(remainder == 0) {
    		return(Integer.toString(wholenum));
    	}
    	else {
    		return ( wholenum + "_" + remainder +"/" + newdenominator);
    	}
    }
}