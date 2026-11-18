import java.util.Scanner;

public class as1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Constants
        final double DRINK_PRICE = 15.50;
        final double STUDENT_DISCOUNT = 0.10;
        final double SENIOR_DISCOUNT = 0.05;
        final double TIP_RATE = 0.10;

        // Input
        System.out.print("Customer name: ");
        String name = input.nextLine();

        System.out.print("Customer age: ");
        int age = input.nextInt();

        System.out.print("Meal price: ");
        double mealPrice = input.nextDouble();

        System.out.print("Number of drinks: ");
        int drinks = input.nextInt();

        System.out.print("Is the customer a student? (true/false): ");
        boolean isStudent = input.nextBoolean();

        System.out.print("Service rating (1-5): ");
        int rating = input.nextInt();

        // Validate rating
        if (rating < 1 || rating > 5) {
            System.out.println("Error: service rating must be between 1 and 5.");
        } else {
            // Calculations
            double drinksCost = drinks * DRINK_PRICE;
            double subtotal = mealPrice + drinksCost;

            // Only one discount: use the larger one
            double discountRate = 0;
            if (isStudent && age >= 60) {
                if (STUDENT_DISCOUNT > SENIOR_DISCOUNT) {
                    discountRate = STUDENT_DISCOUNT;
                } else {
                    discountRate = SENIOR_DISCOUNT;
                }
            } else if (isStudent) {
                discountRate = STUDENT_DISCOUNT;
            } else if (age >= 60) {
                discountRate = SENIOR_DISCOUNT;
            }

            double discount = subtotal * discountRate;
            double afterDiscount = subtotal - discount;

            // Tip for rating 4 or 5
            double tip = 0;
            if (rating == 4 || rating == 5) {
                tip = afterDiscount * TIP_RATE;
            }

            double finalBill = afterDiscount + tip;
            int wholeAmount = (int) finalBill;

            // Receipt
            System.out.println();
            System.out.println("===== SMART RESTAURANT =====");
            System.out.println("Customer: " + name);
            System.out.printf("Meal: $%.2f%n", mealPrice);
            System.out.printf("Drinks: $%.2f%n", drinksCost);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Tip: $%.2f%n", tip);
            System.out.printf("Final bill: $%.2f%n", finalBill);
            System.out.println("Whole amount: $" + wholeAmount);
        }

        input.close();
    }
}