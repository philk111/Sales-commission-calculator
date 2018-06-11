// -----------------------------------------------------
// Assignment 2
// Written by: Philippe Kotar 260751164
// For CCCS 300 - Programming Techniques I
// -----------------------------------------------------


/* As described in the instructions, this program is designed to calculate and keep track of the commissions of a salesperson
 * in a given month and throughout the year. The commissions are limited once they cross $15000 per month and the program terminates
 * once commissions cross $100000 in a given the year.
 */


import javax.swing.JOptionPane;

public class SalesCommissionCalculator {
  public static void main(String[] args) {
    
//Introductory statement.	  
System.out.println("Welcome to Philippe Kotar's Assignment # 2");  
	  
//Declare control variables for the outer loop.  
double totalCommissions = 0;  
int currentMonth = -1;
int exitVariable = 0;

//Beginning of the outer loop that controls the months cycle and monthly commissions and sales.
while (totalCommissions<=100000 && exitVariable == 0){	
	
	  //Declare more variables.	
	  double newPurchase;
	  double monthlyCommissions = 0;	
	
	
++currentMonth;
	
 
  //Determine current month 	
	switch (currentMonth % 12) {
      case 0: System.out.println("---   Welcome to January   ---"); break;
      case 1: System.out.println("---   Welcome to February   ---"); break;
      case 2: System.out.println("---   Welcome to March   ---"); break;
      case 3: System.out.println("---   Welcome to April   ---"); break;
      case 4: System.out.println("---   Welcome to May   ---"); break;
      case 5: System.out.println("---   Welcome to June   ---"); break;
      case 6: System.out.println("---   Welcome to July   ---"); break;
      case 7: System.out.println("---   Welcome to August   ---"); break;
      case 8: System.out.println("---   Welcome to September   ---"); break;
      case 9: System.out.println("---   Welcome to October   ---"); break;
      case 10: System.out.println("---   Welcome to November   ---"); break;
      case 11: System.out.println("---   Welcome to December   ---"); break;
		  }
	
	//IF statement to terminate program if full year has passed without totalCommissions >=100k
	if(currentMonth==12){
	JOptionPane.showMessageDialog(null, "A full year has passed. You'll be staying in Montreal!","1 year later",JOptionPane.INFORMATION_MESSAGE);
	System.out.println("A full year has passed and you haven't reached 100k in commissions. You're fired!");	 
	exitVariable=1;
	}	
	 
			
//Inner loop that controls transactions in a given month.	  
while (monthlyCommissions <=15000 && exitVariable == 0){

	int newCustomer;
	double transaction = Math.random() * 50000.0 ; 
	double transactionAmount = Math.round(transaction *100)/100.0; 	
		  
	  //Selecting if we have a customer
	  newCustomer = JOptionPane.showConfirmDialog(null, "You interested in buying something?","ABC store Inc.",JOptionPane.INFORMATION_MESSAGE);
		   
			//YES, we have a customer  
			if(newCustomer==JOptionPane.YES_OPTION){
				System.out.println("Welcome to ABC stores Inc.");	
				
				//Does the customer want to purchase?
				newPurchase = JOptionPane.showConfirmDialog(null, "One DAY only limited offer! Purchase for $" + transactionAmount,"ABC store Inc.",JOptionPane.INFORMATION_MESSAGE);
						
						//Customer purchases
						if(newPurchase==JOptionPane.YES_OPTION){
							
							
							//Calculate commissions						
							if (transactionAmount > 30000){
									monthlyCommissions += (transactionAmount - 30000)*0.2 + 3000 + (1000);}
							else if(transactionAmount > 10000){
									monthlyCommissions += (transactionAmount - 10000)*0.15 +(1000);}
							else {
								monthlyCommissions += (transactionAmount *0.1);}
							
							 monthlyCommissions = Math.round(monthlyCommissions *100)/100.0;
							
							//Display messages to advise user of purchase
							System.out.println("You've just purchased for $" + transactionAmount);	
							JOptionPane.showMessageDialog(null, "Thank you for your purchase.","Enjoy!",JOptionPane.INFORMATION_MESSAGE);}
					
					
				        //Customer not purchasing 
						else if (newPurchase==JOptionPane.NO_OPTION){
							JOptionPane.showMessageDialog(null, "You drive a hard bargain.","Next!",JOptionPane.INFORMATION_MESSAGE);}
						else {
							exitVariable = 1;
							System.out.println("You chose to terminate the program. Good-Bye.");
							JOptionPane.showMessageDialog(null, "See you back soon.","Good-bye",JOptionPane.INFORMATION_MESSAGE);}}
							
						
					
			//There are no customers option	
			else if(newCustomer==JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "No customers this month? Try again later.","Try again.",JOptionPane.INFORMATION_MESSAGE);
				break;}
			
			//Cancel or X option to terminate the program
			else {
				exitVariable = 1;
				System.out.println("You chose to terminate the program. Good-Bye.");
				JOptionPane.showMessageDialog(null, "See you back soon.","Good-bye",JOptionPane.INFORMATION_MESSAGE);}
			
	  }
	//inner loop for the current month finishes
	if(exitVariable != 1){
	System.out.println("You have earned  $" + monthlyCommissions + " in commissions this month.");
	totalCommissions += monthlyCommissions;}
	
			
}	

//outer loop finishes
if(exitVariable != 1){
totalCommissions=Math.round(totalCommissions *100)/100.0;
System.out.println("WOW you've reached  $" + totalCommissions + " in commissions. Aloha Hawaii~");}
		
	}
  }


