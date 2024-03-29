//Thora Cummins
//CIS406
//Order Entry Phase 3

package orderEntryPhase3;
import java.util.Scanner;

public class OrderEntryPhase3
{

	//Variables
	private double discountPercent;
	public double grossPrice;
	private String itemDescription;
	private String itemNumber;
	private double itemPrice;
	private int itemQtyOrdered;
	public double netPrice;
	private double taxPercent;
	public double totalDiscount;
	public double totalTax;
	
	// Continue yes or no
	public String contineYesNo()
	{
		//Continue?
		Scanner contOBJ = new Scanner(System.in);
		System.out.println("Continue? (y/n): ");
		return contOBJ.nextLine();		
	}
	
	//Gather Inputs
	public String gatherInputs()
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
		
		//build list
		return "  "+itemNumber+"\t   "+itemDescription+"\t\t   "+itemPrice+"\t\t    "+itemQtyOrdered+"\t\t   "+grossPrice+"\t\t"+taxPercent+
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
	public void printGrandTotals(int totalItems, double totalGP, double totalTA, double totalDisc, double totalNP)
	{
		System.out.println("\n\n Grand Totals\n");
		System.out.println("Total Items\tTotal Gross Amount\tTotal Tax Amount\tTotal Discount Amount\tTotal Net Amount\n");
		System.out.println("     "+totalItems+"\t\t       "+String.format("%.2f",totalGP)+"\t\t      "+String.format("%.2f",totalTA)+"\t\t\t"+String.format("%.2f",totalDisc)+"\t\t\t"+String.format("%.2f",totalNP));
	}
	
	//Print Invoice
	public void printInvoice()
	{
		System.out.println("\n Order Entry\n");
		System.out.println("Item Number\tItem Description\tItem Price\tQuantity\tGross Price\tTax %\tTax\tDiscount%\tDiscount\tNet Price");
	}
	
	//-----------------------------------------------------------------------
	public static void main(String[] args)
	{
		char cont = 'Y';
		double totalDiscount = 0;
		double totalGrossAmt = 0;
		double totalNetPrice = 0;
		double totalTaxAmount = 0;
		String printLine = "";
		int totalItems = 0;	
		
		do
		{
			OrderEntryPhase3 oep = new OrderEntryPhase3();
		
			// gather input data
			totalItems = totalItems + 1;   // line count
			printLine= printLine + oep.gatherInputs();
			
			//Calculate totals
			totalGrossAmt = totalGrossAmt + oep.grossPrice;
			totalNetPrice = totalNetPrice + oep.netPrice;
			totalTaxAmount = totalTaxAmount + oep.totalTax;
			totalDiscount = totalDiscount + oep.totalDiscount;
					
			// Continue? yes or no
			cont = oep.contineYesNo().charAt(0);
			
		} while (cont == 'Y' || cont == 'y');

		// Wrap it up
		OrderEntryPhase3 oep = new OrderEntryPhase3();
		
		// print invoice
		oep.printInvoice();
		System.out.println(printLine);
		
		// print Grand Totals
		oep.printGrandTotals(totalItems, totalGrossAmt, totalTaxAmount, totalDiscount, totalNetPrice);
		
		System.out.println("\nBye!!!");

	}
}
