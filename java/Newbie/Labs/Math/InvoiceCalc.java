/**
 * Listing 6-4. BigDecimal-based invoice calculations not leading to confusing results.
 * 
 */
 
 import java.math.*;

class InvoiceCalc {
    public static void main(String[] args) {
        BigDecimal invoiceSubtotal = new BigDecimal("285.36");
        BigDecimal discountPercent = new BigDecimal("0.10");
        BigDecimal discount = invoiceSubtotal.multiply(discountPercent);

	System.out.println("BigDecimal invoiceSubTotal = new BigDecimal(\"285.36\");");
        System.out.println("BigDecimal discountPercent = new BigDecimal(\"0.10\");");
        System.out.println("BigDecimal discount = invoiceSubtotal.multiply(discountPercent); // discount = " + discount);
        
        discount = discount.setScale(2, RoundingMode.HALF_UP);
        
	System.out.println("discount = discount.setScale(2, RoundingMode.HALF_UP); // discount = " + discount);

        BigDecimal subtotalBeforeTax = invoiceSubtotal.subtract(discount);
        
	System.out.println("BigDecimal subtotalBeforeTax = invoiceSubtotal.subtract(discount); // subtotalBeforeTax = " + subtotalBeforeTax);

        subtotalBeforeTax = subtotalBeforeTax.setScale(2, RoundingMode.HALF_UP);

        System.out.println("subtotalBeforeTax = subtotalBeforeTax.setScale(2, RoundingMode.HALF_UP); // subtotalBeforeTax = " + subtotalBeforeTax);

        BigDecimal salesTaxPercent = new BigDecimal("0.05");
        BigDecimal salesTax = subtotalBeforeTax.multiply(salesTaxPercent);
        
	System.out.println("BigDecimal salesTaxPercent = new BigDecimal(\"0.05\");");
        System.out.println("BigDecimal salesTax = subtotalBeforeTax.multiply(salesTaxPercent); // salesTax = " + salesTax);

        salesTax = salesTax.setScale(2, RoundingMode.HALF_UP);
        
	System.out.println("salesTax = salesTax.setScale(2, RoundingMode.HALF_UP); // salesTax = " + salesTax);
	
	BigDecimal invoiceTotal = subtotalBeforeTax.add(salesTax);

	System.out.println("BigDecimal invoiceTotal = subtotalBeforeTax.add(salesTax); // invoiceTotal = " + invoiceTotal);

        invoiceTotal = invoiceTotal.setScale(2, RoundingMode.HALF_UP);
        
	System.out.println("invoiceTotal = invoiceTotal.setScale(2, RoundingMode.HALF_UP); // invoiceTotal = " + invoiceTotal);
	
	/*
        System.out.println("Subtotal: " + invoiceSubtotal);
        System.out.println("Discount: " + discount);
        System.out.println("SubTotal after discount: " + subtotalBeforeTax);
        System.out.println("Sales Tax: " + salesTax);
        System.out.println("Total: " + invoiceTotal);
	*/
    }
}
