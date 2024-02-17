//Thora Cummins
//CIS406
//Order Entry Phase 3

package orderEntryPhase3;
import java.util.Scanner;

public class OrderEntryPhase3 {

	//vars
	private double discountPercent;
	private String itemDescription;
	private String itemNumber;
	private double itemPrice;
	private int itemQtyOrdered;
	private double netPrice;
	private double taxPercent;
	private double totalDiscount;
	private double totalTax;
	
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
		Double grossPrice = itemPrice*itemQtyOrdered;  // calc cost of item
		
		totalTax = grossPrice * taxPercent;  // Calc Total Tax
		totalDiscount = grossPrice * discountPercent;
		netPrice = (grossPrice + totalTax) - totalDiscount;
		
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
		Scanner itemOBJ = new Scanner(System.in);
		System.out.println("Enter Item Number: ");
		
		itemNumber = itemOBJ.nextLine();		
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
	
	
	//Print Invoice
	public void printInvoice()
	{
		System.out.println("\n Order Entry\n");
		System.out.println("Item Number\tItem Description\tItem Price\tQuantity\tTax %\tTax\tDiscount%\tDiscount\tNet Price");
		System.out.println("  "+itemNumber+"\t   "+itemDescription+"\t\t   "+itemPrice+"\t\t    "+itemQtyOrdered+"\t\t "+taxPercent+
								"\t"+String.format("%.2f",totalTax)+"\t   "+discountPercent+"\t\t  "+
							    String.format("%.2f", totalDiscount)+"\t\t  "+String.format("%.2f",netPrice));
	}
	
	//-----------------------------------------------------------------------
	public static void main(String[] args) {
		OrderEntryPhase3 oep = new OrderEntryPhase3();
		
		// gather input data
		oep.gatherInputs();
				// print invoice
		oep.printInvoice();
		
		System.out.println("\nBye!!!");

	}

}
