package com.information.solidprinciple;


/* Without following OCP
*
  public class InvoiceService {
    public double calculateTotal(double amount, String discountType) {
        if (discountType.equals("SUMMER")) {
            return amount * 0.9; // 10% off
        } else if (discountType.equals("WINTER")) {
            return amount * 0.8; // 20% off
        } else if (discountType.equals("FESTIVE")) {
            return amount * 0.85; // 15% off
        }
        return amount;
    }
}
* Here, every time you need to add a new discount type,
* you have to modify the calculateTotal method, which violates the OCP.
* */

// With Following OCP below code
// To follow the OCP, we can use polymorphism or inheritance to extend the behavior without modifying the existing code.

// Define an interface for discount strategy
interface DiscountStrategy {
    double applyDiscount(double amount);
}

// Implement concrete discount strategies
class SummerDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.9; // 10% off
    }
}

class WinterDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.8; // 20% off
    }
}

// Use the discount strategies in the invoice service
class InvoiceService { // We are not modifying class instead we are extending this class, if we want to modify something
    private final DiscountStrategy discountStrategy;

    public InvoiceService(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal(double amount) {
        return discountStrategy.applyDiscount(amount);
    }
}

public class OCP {
   public static void main(String[] args) {
       InvoiceService invoiceService = new InvoiceService(new SummerDiscount());
       InvoiceService invoiceService2 = new InvoiceService(new WinterDiscount()); // Flexibility

       System.out.println(invoiceService.calculateTotal(100));
       System.out.println(invoiceService2.calculateTotal(200));
   }
}
