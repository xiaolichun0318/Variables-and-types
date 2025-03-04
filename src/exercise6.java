import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SliceOHeaven {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    public String storeMenu; 
    public String pizzaIngredients;
    public double pizzaPrice;
    public String sides;
    public String drinks;
    private String orderID;
    private double orderTotal;

    public static final String DEF_ORDER_ID = "DEF-SOH-099";
    public static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public static final double DEF_ORDER_TOTAL = 15.00;

    public SliceOHeaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "";
        this.drinks = "";
    }

    public SliceOHeaven(String storeName, String storeAddress, String storeEmail, long storePhone, String storeMenu) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeEmail = storeEmail;
        this.storePhone = storePhone;
        this.storeMenu = storeMenu;
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "";
        this.drinks = "";
    }

    public SliceOHeaven(String storeName, String storeAddress, String storeEmail, long storePhone, String storeMenu,
                        String orderID, String pizzaIngredients, double orderTotal) {
        this(storeName, storeAddress, storeEmail, storePhone, storeMenu);
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        String ing1 = scanner.next();
        String ing2 = scanner.next();
        String ing3 = scanner.next();
        pizzaIngredients = ing1 + ", " + ing2 + ", " + ing3;

        System.out.println("Enter size of pizza (Small, Medium, Large):");
        String pizzaSize = scanner.next();

        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = scanner.next();

        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        sides = scanner.next();

        System.out.println("Enter drinks (Cold Coffee, Cocoa drink, Coke, None):");
        this.drinks = scanner.next();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = scanner.next();

        if (wantDiscount.equalsIgnoreCase("Y")) {
            isItYourBirthday();
        } else {
            makeCardPayment();
        }

        System.out.println("Order accepted!");
        System.out.println("Preparing your pizza...");
        makePizza(pizzaIngredients);
        System.out.println("Your pizza is ready!");
        System.out.println("Adding sides: " + sides);
        System.out.println("Adding drinks: " + this.drinks);
        printReceipt();
    }

    private void makePizza(String ingredients) {
        System.out.println("Making pizza with " + ingredients);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Pizza making interrupted!");
        }
    }

    private void printReceipt() {
        System.out.println("********RECEIPT********");
        System.out.println("Store Name: " + storeName);
        System.out.println("Order ID: " + getOrderID());
        System.out.println("Pizza Ingredients: " + pizzaIngredients);
        System.out.println("Sides: " + sides);
        System.out.println("Drinks: " + drinks);
        System.out.println("Order Total: $" + getOrderTotal());
    }

    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        String cardNumberStr = Long.toString(cardNumber);
        int cardLength = cardNumberStr.length();
        if (cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
        }

        int firstCardDigit = Integer.parseInt(cardNumberStr.substring(0, 1));

        long blacklistedNumber = 12345678901234L;
        if (cardNumber == blacklistedNumber) {
            System.out.println("Card is blacklisted. Please use another card");
        }

        int lastFourDigits = Integer.parseInt(cardNumberStr.substring(cardNumberStr.length() - 4));

        StringBuilder cardNumberToDisplayBuilder = new StringBuilder(cardNumberStr);
        for (int i = 1; i < cardNumberStr.length() - 4; i++) {
            cardNumberToDisplayBuilder.setCharAt(i, '*');
        }
        String cardNumberToDisplay = cardNumberToDisplayBuilder.toString();

        System.out.println("First digit of card: " + firstCardDigit);
        System.out.println("Last four digits of card: " + lastFourDigits);
        System.out.println("Card number to display: " + cardNumberToDisplay);
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        StringBuilder specialDetails = new StringBuilder();
        specialDetails.append("Special of the day:\n");
        specialDetails.append("Pizza: ").append(pizzaOfTheDay).append("\n");
        specialDetails.append("Side: ").append(sideOfTheDay).append("\n");
        specialDetails.append("Price: ").append(specialPrice).append("\n");
        System.out.println(specialDetails.toString());
    }

    private void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birthday (MM/dd/yyyy):");
        String birthdateStr = scanner.next();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date birthdate = null;
        try {
            birthdate = sdf.parse(birthdateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
            return;
        }

        Calendar birthCal = Calendar.getInstance();
        birthCal.setTime(birthdate);
        Calendar nowCal = Calendar.getInstance();

        int age = nowCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);
        if (nowCal.get(Calendar.DAY_OF_YEAR) < birthCal.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        boolean isBirthday = nowCal.get(Calendar.MONTH) == birthCal.get(Calendar.MONTH) &&
                nowCal.get(Calendar.DAY_OF_MONTH) == birthCal.get(Calendar.DAY_OF_MONTH);

        if (age < 18 && isBirthday) {
            System.out.println("Congratulations! You pay only half the price for your order");
            orderTotal = pizzaPrice / 2;
        } else {
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
            orderTotal = pizzaPrice;
        }
    }

    private void makeCardPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number:");
        long cardNumber = scanner.nextLong();
        System.out.println("Enter the card’s expiry date (MM/yy):");
        String expiryDate = scanner.next();
        System.out.println("Enter the card’s cvv number:");
        int cvv = scanner.nextInt();

        processCardPayment(cardNumber, expiryDate, cvv);
        orderTotal = pizzaPrice;
    }

    public static void main(String[] args) {
        SliceOHeaven pizzeria = new SliceOHeaven("Slice - o - Heaven", "123 Pizza St", "info@sliceoheaven.com", 1234567890L,
                "Pizza, Sides");
        pizzeria.pizzaPrice = 20.0;
        pizzeria.takeOrder();
        pizzeria.specialOfTheDay("Margherita Pizza", "Fries", "$12.99");
    }
}