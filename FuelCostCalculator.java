package project3;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FuelCostCalculatorPhase3 {
 
	private static int i;

	public static void main(String[] args) throws Exception {		
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon("C:\\Users\\Zannatul Naeem\\Documents\\ITP 120\\pic1.jpg");
		JLabel label = new JLabel(icon); 
		
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.validate();	
		
		//files
		String fileName1 = ("file1.txt");
	  	String fileName2 = ("file2.txt");
	  		
	  	//create objects for files
	  	String [] zipCodesArray = new String[3];
	  	String [] citiesArray = new String[3];
	  	
		//declare variables
        double distance = 0.0;
        double mpg = 0.0;
		String carInfo = null;
		int userInput = 0;
		int resetInput = 0;
		
        final double GAS_PRICE = 3.75;
        
       // String fileName1 = null;
      //	String fileName2 = null;
      //	int arrayLength1 = 0;
      //	int arrayLength2 = 0;
      	
	  	//String [] zipCode = new String[arrayLength1];
	  	//String [] cities = new String[arrayLength2];
        
        //Requirement 1 - Create parallel arrays
        String zipCodes [] = {"22192", "22079", "33141"};
      	String cities [] = {"Woodbridge", "Fairfax", "Manassas"};
      	String cityName = null;
      	String gasStation = null;

        //establishes user input 
        Scanner input = new Scanner(System.in);    
        
        //do-while loop that asks the user to restart the program
        do {
            //UI
        	userInput = Integer.parseInt(JOptionPane.showInputDialog("                                Welcome to Fuel Calculator!\nThis app will calculate the fuel amount and the cost for any road trip.\nPlease select your car\n"
        			+ "1 - Honda\n"
    				+ "2 - Toyota\n"
    				+ "3 - Ford\n"
    				+ "4 - Kia\n"
    				+ "5 - Nissan\n"
    				+ "                            Programmed By: Zannatul Naeem "));
	        	
				//takes user input and assigns it to the value of the userInput variable
        	    //also captures user's car selection as caraInfo variable
				switch(userInput)
				{
				case 1:
					carInfo = "Honda";
					break;
				case 2:
					carInfo = "Toyota";
					break;
				case 3:
					carInfo = "Ford";
					break;
				case 4:
					carInfo = "Kia";
					break;
				case 5:
					carInfo = "Nissan";
					break;
				}//end of switch
				
				
				
	        	while((userInput > 5) || (userInput < 1)) //user input validation loop
	        	{        		
	       		userInput = Integer.parseInt(JOptionPane.showInputDialog("                         ERROR!\nPlease type 1-5 to select your car\n"
	            			+ "1 - Honda\n"
	        				+ "2 - Toyota\n"
	        				+ "3 - Ford\n"
	        				+ "4 - Kia\n"
	        				+ "5 - Nissan"));
	            	
	    				switch(userInput)
	    				{
	    				case 1:
	    					carInfo = "Honda";
	    					break;
	    				case 2:
	    					carInfo = "Toyota";
	    					break;
	    				case 3:
	    					carInfo = "Ford";
	    					break;
	    				case 4:
	    					carInfo = "Kia";
	    					break;
	    				case 5:
	    					carInfo = "Nissan";
	    					break;
	    				}//end of switch		
	        	}//end of while user validation loop
	        	
	        //user's prompt to select gallons or liters	
             System.out.println("Enter 1 to receive the results in gallons");
             System.out.println("Enter 2 to receive the results in liters");
             userInput = input.nextInt();
           
                //prompt that asks users to input data in miles or kilometer 
	        	while (!(userInput == 1) && !(userInput == 2)) { //input validation
	        		System.out.println("Error! Please enter the number '1' or '2'");
	        		userInput = input.nextInt();	
	        	}//while
	        	
	        	 if (userInput == 1) 
	  	        {	
	  	        	// miles per gallon
	  	        	System.out.println("How many miles are you going to drive?"); 
	  	        	 distance = input.nextDouble();
	  	        	
	  	        	while ((!(distance > 1))) //input validation
	  	        	{
	  	        		System.out.println("Error! Please enter a number above 0");
	  	        		distance = input.nextDouble();
	  	        	}//end of while-distance validation
	  	        	
	  	        	System.out.println("Whats your car's MPG?");
	  	        	mpg = input.nextDouble();
	  	        	
	  	        	while ((!(mpg > 1))) //input validation
	  	        	{
	  	        		System.out.println("Error! Please a number above 0");
	  	        		mpg = input.nextDouble();
	  	        	}//end of while-mpg validation
	  	               
	  	        	//calculation formula
	  	        	//Fuel cost = (Distance / Consumption) × Cost per gallon
	  	        	double fuelCost = (distance/mpg) * GAS_PRICE;
	  	            double fuelNeeded = (distance/mpg);  
	  	    
		  	        //loading promt method  
		  	       // loadingMethod();
		  	            
	  	            //generates random #numbers of users
	  	        	int random = (int)(Math.random() * 100 + 80);
	  	        	
	  	            //output
	  	        	System.out.println("\nFor your " + carInfo + "," + " the fuel amount required to drive " + distance + " miles" + ":");
	  	        	System.out.printf("%.2f gallons%n", fuelNeeded);
	  	        	System.out.println("It will cost:");
	  	        	System.out.printf("$%.2f \n", fuelCost);
	  	        	
	  	        	//ask the user to find a gas station nearby 
	  	        	userInput = JOptionPane.showConfirmDialog(null, "Would you like to find a fuel station near you?");
	  	        	
	  	        	//findGasStation method that that iterates through parallel arrays to return the city name based on user's input 
	  	        	cityName = findCity(zipCodes, cities);
			  	      
			  	      switch(cityName)
						{
						case "Woodbridge":
							gasStation = "Sanoco - 0.5";
							break;
						case "Fairfax":
							gasStation = "Exxon - 5.5";
							
							break;
						case "Manassas":
							gasStation = "Wawa - 7.5";
							break;
						}//end of switch
			  	    
			  	    //displays the gas station and city name
					System.out.println("\nThe nearest gas station in " + cityName + " is:");
					System.out.println(gasStation + " miles away" );	
	  	  			
	  	        	//displays number of users by using random number genarator
	  	        	System.out.println("\nThe number of users have used this app: " + random + "\n");
	  	        } 
	  	        else if (userInput == 2) 
	  	        {
	  	        	// km per liter
	  	        	System.out.println("How many kilometers are you going to drive?"); 
	  	        	distance = input.nextDouble();
		  	          while ((!(distance > 1))) //input validation
		  	        	{
		  	        		
		  	        		System.out.println("Error! Please enter a number above 0");
		  	        		distance = input.nextDouble();
		  	        	}//end of while-distance validation
	  	        	
	  	            System.out.println("Whats your car's MPG?");
	  	              mpg = input.nextDouble();
		  	          while ((!(mpg > 1))) //input validation
		  	        	{
		  	        		System.out.println("Error! Please enter a number above 0"); 
		  	        		mpg = input.nextDouble();
		  	        	}//end of while-mpg validation
	  	         
	  	     
	  	           // Convert MPG to KPL. 1 miles per gallon = 0.425144 kilometer per liter 
	  	           //Divide the gas price (per U.S. gallon) by the number of liters in a gallon. 1 gallon = 3.785 liter. The result is the gas price per liter.
	  	         
	  	        	double fuelCost = ((distance)/(mpg * 0.425144)) * ((GAS_PRICE / 3.785)); // $per liter
	  	        	double fuelNeeded = (distance /(mpg * 0.425144)); // _liters
	  	        	      	
	  	        	//loading promt method
	  	        	//loadingMethod();
	  	        
	  	        	int random = (int)(Math.random() * 500 + 50); //generates random number to display #num of users
	  	        
	  	        	System.out.println("\nFor your " + carInfo + "," + " the fuel amount required to drive " + distance + " kilometers" + ":");
	  	        	System.out.printf("%.2f liters%n", fuelNeeded);
	  	        	System.out.println("It will cost:");
	  	        	System.out.printf("$%.2f \n", fuelCost);
	  	        	
	  	        	//ask the user to find a gas station nearby 
	  	        	userInput = JOptionPane.showConfirmDialog(null, "Would you like to find a fuel station near you?");
	  	        	
	  //---------------------------------------------------------------------	
		  	       	//find display gas station using findGasStation method (method code in line 251)
		  	        //variables for files
		  	  		
		  	  		//loading file methods 
		  	  		zipCodesArray = loadStringArray(fileName1);
		  	  		citiesArray = loadStringArray(fileName2);
		  	  		
		  	  		//displays arrays from files
		  	  		System.out.println("Zip codes: " + java.util.Arrays.toString(zipCodesArray));
		  	  		System.out.println("Cities: " + java.util.Arrays.toString(citiesArray));
	  	       
	  	  		
	  	        	
//-----------------------------------------------------------------------		
		  	      cityName = findCity(zipCodes, cities);
		  	      
		  	      switch(cityName)
					{
					case "Woodbridge":
						gasStation = "Sanoco - 0.5";
						break;
					case "Fairfax":
						gasStation = "Exxon - 5.5";
						
						break;
					case "Manassas":
						gasStation = "Wawa - 7.5";
						break;
					}//end of switch
		  	      	
		  	      	
					System.out.println("\nThe nearest gas station in " + cityName + " is:");
					System.out.println(gasStation + " miles away" );	
		  	  			
		  	        	//displays number of users by using random number genarator
		  	        	System.out.println("\nThe number of users have used this app: " + random + "\n");
		  	        } 
		  	        else //input validation 
		  	        {
		  	        	System.out.println("ERROR! Please input only 1 or 2");
		  	        }//end of if/else statement
		        	
		        	//prompt to restart the program
		        	 resetInput = JOptionPane.showConfirmDialog(null, "Would you like to start a new calculation?");
	        	  
        } while(resetInput == 0);//end of do-while loop 
        
        //program closing message
        System.out.println("-----------------------------------------");
        System.out.println("Thank you for using Fuel Cost Calculator!"); 
        System.out.println("-----------------------------------------");
	
}//end of main

//A method that displays "Calculating..." as a loading promt before displaying the result of the calculation 
	static void loadingMethod() {
		System.out.print("Calculating");
	 	for(i = 0; i < 3; i++)
	 	{
	 		System.out.print(".");
	 		
	 		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	 		
	 	}//end of for loop
	 	System.out.println("");
	}//end of loadingMethod
	
//---------------------------------------
	
	// finds gas staion using a method with parallel array
	public static String[] loadStringArray(String fileName) throws Exception {
		
		//create file object
		File F1 = new File(fileName);
		
		//create scanner object 
		Scanner scanF1 = new Scanner(F1);
		
		//array 
		String [] stringArray = new String[3];
		
		//variable 
		//String userInput = "";
		
		
		//loop
		for(int i = 0; i < stringArray.length; i++) {
				
			stringArray[i] = scanF1.nextLine();
					
			
		}//end of for loop
		
		scanF1.close();
		
		return stringArray;
		
				
	}//end of array method
	
	// finds gas staion using a method with parallel array
		public static  String findCity(String zipCodes[], String cities[] ){ 
			int index = 0;
			
			String userInput = "";
			
			userInput = JOptionPane.showInputDialog("Enter your city zipcode\n"
					+ "22192 - WOODBRIDGE\n"
					+ "22079 - FAIRFAX\n"
					+ "33141 - MANASSAS\n");
				
			for(index = 0; index < zipCodes.length; index++) {
				if((userInput.equals(zipCodes[index]) )) { //Requirement 4 - String method (.equals)
					return cities[index] ;
				}
			}//end of for loop
			
			
			return "not found. Please enter the correct zip code";
		    
		}//end of array method
	
	 
}//end of class
