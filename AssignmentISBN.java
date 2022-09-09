
/**
 * Author: Robert James Gungon
 * File: AssignmentISBN.java
 * Description: Book inventory program that calculates books returned or checked out via ISBN user input.
 */

import java.util.Scanner;

public class AssignmentISBN
{
	public static void main(String[] args)
	{
		//Create scanners
		Scanner keyinput = new Scanner(System.in);
		Scanner keyaction = new Scanner(System.in);
		
		//Declare variables
		String ISBNCode, inventoryAction, programAction;
		int ISBNInputLength = 0, ISBNNumericValue, ISBNSum = 0,  ISBN13thDigit = 0, bookReturnCount = 0, bookCheckedOutCount = 0, bookProcessedCount = 0;
		char ISBNDigit, inventoryActionCode, programActionCode = 'Y';
		
		//Display program header
		System.out.println("*************************************************");
		System.out.println("* Welcome to OCCC Daily Book Inventory Program! *");
		System.out.println("*************************************************");
		
		while (programActionCode == 'Y' || programActionCode == 'y')
		{
			//TEMP DISPLAY (Check Initial Values)
			//System.out.println("ISBN length is " + ISBNInputLength);
			//System.out.println("ISBN sum is " + ISBNSum);
			//System.out.println("The 13th ISBN code is " + ISBN13thDigit);
						
			//Prompt user for ISBN
			System.out.println("\nEnter the first 12 digits (0-9) of the ISBN-13 code:");
			ISBNCode = keyinput.nextLine();
			ISBNInputLength = ISBNCode.length();
		
			//Validate ISBN input for length
			while (ISBNInputLength != 12)
			{
				System.out.println("Invalid ISBN input. The code must be 12 digits (0-9). Try again:");
				System.out.println("\nEnter the first 12 digits (0-9) of the ISBN-13 code:");
				ISBNCode = keyinput.nextLine();
				ISBNInputLength = ISBNCode.length();
			}
		
			//Assign each ISBN digit to an integer variable and find the sum of the digits
			int x = 0; 
			while (x < 12)
			{
				ISBNDigit = ISBNCode.charAt(x);
			
				//The following IF/ELSE statement is my code to determine which digits in the ISBN input will be multiplied by 3
				//The even positions (2,4,6,8,10,12) in the ISBN input should be multiplied by 3 as per the example in the book
				//However, string positions start at 0 so the formula below seems counter-intuitive
			
				if (x == 1 || x == 3 || x == 5 || x == 7 || x == 9 || x == 11)
				{
					ISBNNumericValue = Character.getNumericValue(ISBNDigit) * 3; 
				}
				else
				{
					ISBNNumericValue = Character.getNumericValue(ISBNDigit) * 1;
				}
			
				ISBNSum += ISBNNumericValue;
				x++;
			}
		
			//Calculate 13th digit of ISBN
			
			//TEMP DISPLAY for Checking
			//System.out.println("ISBN Checksum is " + ISBNSum);
			
			ISBN13thDigit = 10-(ISBNSum%10);
			if (ISBN13thDigit == 10)
			{
				ISBN13thDigit = 0;
			}
		
			//Display ISBN output
			System.out.println("\nThe ISBN-13 code is " + ISBNCode + ISBN13thDigit);
		
			//Prompt for inventory action
			System.out.print("\nEnter 'R' for return or 'C' for check out: ");
			inventoryAction = keyaction.nextLine();
			inventoryActionCode = inventoryAction.charAt(0);
				
			//Validate inventory action entry
			while (inventoryActionCode != 'R' && inventoryActionCode != 'r' && inventoryActionCode != 'C' && inventoryActionCode != 'c' )
			{
				System.out.println("Invalid input. Please enter 'R' or 'C' only. Try again.");
				System.out.print("\nEnter 'R' for return or 'C' for check out: ");
				inventoryAction = keyaction.nextLine();
				inventoryActionCode = inventoryAction.charAt(0);
			}
		
			//Tabulate inventory action inputs
			if (inventoryActionCode == 'R' || inventoryActionCode == 'r')
			{
				bookReturnCount ++;
			}
		
			if (inventoryActionCode == 'C' || inventoryActionCode == 'c')
			{
				bookCheckedOutCount ++;
			}
		
			bookProcessedCount = bookReturnCount + bookCheckedOutCount; 
		
			//Display inventory header and report
			System.out.println("\n*************************************************");
			System.out.println("*         Daily Book Inventory Report           *");
			System.out.println("*************************************************");
		
			System.out.println("Number of books returned today:      " + bookReturnCount);
			System.out.println("Number of books checked out today:   " + bookCheckedOutCount);
			System.out.println("Number of books processed today:     " + bookProcessedCount);
			System.out.println("*************************************************");
			
			//Prompt for program next step
			System.out.print("\nEnter 'Y' to continue or 'N' to quit: ");
			programAction = keyaction.nextLine();
			programActionCode = programAction.charAt(0);
		
			//Validate inventory action entry
			while (programActionCode != 'Y' && programActionCode != 'y' && programActionCode != 'N' && programActionCode != 'n' )
			{
			System.out.println("Invalid input. Please enter 'Y' or 'N' only. Try again.");
			System.out.print("\nEnter 'Y' to continue or 'N' to quit: ");
			programAction = keyaction.nextLine();
			programActionCode = programAction.charAt(0);
			}
			
			//Reset ISBN numbers
			ISBNInputLength -= ISBNInputLength;
			ISBNSum -= ISBNSum;
			ISBN13thDigit -= ISBN13thDigit;
			
		}
		
		//Display inventory header and report if user selects 'N'
		System.out.println("\n*************************************************");
		System.out.println("*         Daily Book Inventory Report           *");
		System.out.println("*************************************************");
	
		System.out.println("Number of books returned today:      " + bookReturnCount);
		System.out.println("Number of books checked out today:   " + bookCheckedOutCount);
		System.out.println("Number of books processed today:     " + bookProcessedCount);
		System.out.println("*************************************************");		
	}
}
