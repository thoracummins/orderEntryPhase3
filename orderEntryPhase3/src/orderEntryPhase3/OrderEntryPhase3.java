//Thora Cummins
//CIS406
//Order Entry Phase 3

package orderEntryPhase3;
import java.util.Scanner;

public class OrderEntryPhase3
{

	//Variables
	private double discountPercent;
	private double grossPrice;
	private String itemDescription;
	private String itemNumber;
	private double itemPrice;
	private int itemQtyOrdered;
	private double netPrice;
	public String printLine = 	"";
	private double taxPercent;
	private double totalDiscount;
	private int totalItems = 0;
	private double totalTax;
	
	// Continue yes or no
	public String contineYesNo()
	{
		//Continue?
		Scanner contOBJ = new Scanner(System.in);
		System.out.println("Continue? (y/n): ");
		return contOBJ.nextLine();		
	}
	
	//Gather Inputs
	public void gatherInputs()
	{
		getItemDescription();
		getItemNumber();
		getItemPrice();
		getOrderedQuantity();
		getTax();
		getDiscountPercent();
		
		//Calculations
		grossPrice = itemPrice*itemQtyOrdered;  // calculate cost of item
	
		totalTax = grossPrice * taxPercent;  // Calculate Total Tax
		totalDiscount = grossPrice * discountPercent;
		netPrice = (grossPrice + totalTax) - totalDiscount;	
		
		//Calculate Totals
		totalItems =+ 1;   // count line items
		
		//build list
		printLine = printLine + "  "+itemNumber+"\t   "+itemDescription+"\t\t   "+itemPrice+"\t\t    "+itemQtyOrdered+"\t\t   "+grossPrice+"\t\t"+taxPercent+
				"\t"+String.format("%.2f",totalTax)+"\t   "+discountPercent+"\t\t  "+
			    String.format("%.2f", totalDiscount)+"\t\t  "+String.format("%.2f",netPrice)+"\n";
	}
	
	//Discount Percent
	private void getDiscountPercent()
	{
		Scanner dpOBJ = new Scanner(System.in);
		System.out.println("Enter Discount Percent: ");
		
		discountPercent = dpOBJ.nextDouble();	
	}
	
	//Item Description
	private void getItemDescription()
	{
		Scanner itemOBJ = new Scanner(System.in);
		System.out.println("Enter Item Description: ");
		
		itemDescription = itemOBJ.nextLine();
	}
	
	//Item Number
	private void getItemNumber()
	{
		Scanner inumOBJ = new Scanner(System.in);
		System.out.println("Enter Item Number: ");
		
		itemNumber = inumOBJ.nextLine();	
	}
	
	//Item Price
	private void getItemPrice()
	{
		Scanner ipOBJ = new Scanner(System.in);
		System.out.println("Enter Item Price: ");
		
		itemPrice = ipOBJ.nextDouble();
	}
	
	//Quantity Ordered
	private void getOrderedQuantity()
	{
		Scanner oqOBJ = new Scanner(System.in);
		System.out.println("Enter Quantity Ordered: ");
		
		itemQtyOrdered = oqOBJ.nextInt();
	}
	
	//Tax Percent
	private void getTax()
	{
		Scanner txOBJ = new Scanner(System.in);
		System.out.println("Enter Tax Percent: ");
		
		taxPercent = txOBJ.nextDouble();
	}
		
	//Print Grand Totals
	public void printGrandTotals()
	{
		System.out.println("\n Grand Totals\n");
		System.out.println("Total Items");
		System.out.println("     "+totalItems);
		//System.out.println("Item Number\tItem Description\tItem Price\tQuantity\tGross Price\tTax %\tTax\tDiscount%\tDiscount\tNet Price");
		//System.out.println("  "+itemNumber+"\t   "+itemDescription+"\t\t   "+itemPrice+"\t\t    "+itemQtyOrdered+"\t\t   "+grossPrice+"\t\t"+taxPercent+
								//"\t"+String.format("%.2f",totalTax)+"\t   "+discountPercent+"\t\t  "+
							   // String.format("%.2f", totalDiscount)+"\t\t  "+String.format("%.2f",netPrice));
	}
	
	//Print Invoice
	public void printInvoice()
	{
		System.out.println("\n Order Entry\n");
		System.out.println("Item Number\tItem Description\tItem Price\tQuantity\tGross Price\tTax %\tTax\tDiscount%\tDiscount\tNet Price");
		System.out.println(printLine);		
	}
	
	//-----------------------------------------------------------------------
	public static void main(String[] args)
	{
		char cont = 'Y';
		
		do
		{
			OrderEntryPhase3 oep = new OrderEntryPhase3();
		
			// gather input data
			oep.gatherInputs();
			
			cont = oep.contineYesNo().charAt(0);					
		} while (cont == 'Y' || cont == 'y');

		OrderEntryPhase3 oep = new OrderEntryPhase3();
		
		// print invoice
		oep.printInvoice();
		
		// print Grand Totals
		oep.printGrandTotals();
		
		System.out.println("\nBye!!!");

	}
}
