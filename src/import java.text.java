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
        int ingChoice1, ingChoice2, ingChoice3;
        String ing1, ing2, ing3;

        // 选择披萨配料
        boolean validIngredients = false;
        while (!validIngredients) {
            System.out.println("Please pick any three of the following ingredients:");
            System.out.println("1. Mushroom");
            System.out.println("2. Paprika");
            System.out.println("3. Sun-dried tomatoes");
            System.out.println("4. Chicken");
            System.out.println("5. Pineapple");
            System.out.println("Enter any three choices (1, 2, 3,…) separated by spaces:");
            ingChoice1 = scanner.nextInt();
            ingChoice2 = scanner.nextInt();
            ingChoice3 = scanner.nextInt();

            if (ingChoice1 >= 1 && ingChoice1 <= 5 && ingChoice2 >= 1 && ingChoice2 <= 5 && ingChoice3 >= 1 && ingChoice3 <= 5) {
                validIngredients = true;
            } else {
                System.out.println("Invalid choice(s). Please pick only from the given list:");
            }
        }

        // 将配料选择转换为配料名称
        switch (ingChoice1) {
            case 1:
                ing1 = "Mushroom";
                break;
            case 2:
                ing1 = "Paprika";
                break;
            case 3:
                ing1 = "Sun-dried tomatoes";
                break;
            case 4:
                ing1 = "Chicken";
                break;
            case 5:
                ing1 = "Pineapple";
                break;
            default:
                ing1 = "";
        }

        switch (ingChoice2) {
            case 1:
                ing2 = "Mushroom";
                break;
            case 2:
                ing2 = "Paprika";
                break;
            case 3:
                ing2 = "Sun-dried tomatoes";
                break;
            case 4:
                ing2 = "Chicken";
                break;
            case 5:
                ing2 = "Pineapple";
                break;
            default:
                ing2 = "";
        }

        switch (ingChoice3) {
            case 1:
                ing3 = "Mushroom";
                break;
            case 2:
                ing3 = "Paprika";
                break;
            case 3:
                ing3 = "Sun-dried tomatoes";
                break;
            case 4:
                ing3 = "Chicken";
                break;
            case 5:
                ing3 = "Pineapple";
                break;
            default:
                ing3 = "";
        }

        pizzaIngredients = ing1 + ", " + ing2 + ", " + ing3;

        // 选择披萨尺寸
        int sizeChoice;
        String pizzaSize;
        boolean validSize = false;
        while (!validSize) {
            System.out.println("What size should your pizza be?");
            System.out.println("1. Large");
            System.out.println("2. Medium");
            System.out.println("3. Small");
            System.out.println("Enter only one choice (1, 2, or 3):");
            sizeChoice = scanner.nextInt();

            if (sizeChoice >= 1 && sizeChoice <= 3) {
                validSize = true;
            } else {
                System.out.println("Invalid choice. Please pick only from the given list:");
            }
        }

        // 将尺寸选择转换为尺寸名称
        switch (sizeChoice) {
            case 1:
                pizzaSize = "Large";
                break;
            case 2:
                pizzaSize = "Medium";
                break;
            case 3:
                pizzaSize = "Small";
                break;
            default:
                pizzaSize = "";
        }

        // 是否要额外奶酪
        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = scanner.next();

        // 选择配菜
        int sideDishChoice;
        String sideDish;
        boolean validSideDish = false;
        while (!validSideDish) {
            System.out.println("Following are the side dish that go well with your pizza:");
            System.out.println("1. Calzone");
            System.out.println("2. Garlic bread");
            System.out.println("3. Chicken puff");
            System.out.println("4. Muffin");
            System.out.println("5. Nothing for me");
            System.out.println("What would you like? Pick one (1, 2, 3,…):");
            sideDishChoice = scanner.nextInt();

            if (sideDishChoice >= 1 && sideDishChoice <= 5) {
                validSideDish = true;
            } else {
                System.out.println("Invalid choice. Please pick only from the given list:");
            }
        }

        // 将配菜选择转换为配菜名称
        switch (sideDishChoice) {
            case 1:
                sideDish = "Calzone";
                break;
            case 2:
                sideDish = "Garlic bread";
                break;
            case 3:
                sideDish = "Chicken puff";
                break;
            case 4:
                sideDish = "Muffin";
                break;
            case 5:
                sideDish = "Nothing for me";
                break;
            default:
                sideDish = "";
        }
        sides = sideDish;

        // 选择饮料
        int drinkChoice;
        boolean validDrink = false;
        while (!validDrink) {
            System.out.println("Choose from one of the drinks below. We recommend Coca Cola:");
            System.out.println("1. Coca Cola");
            System.out.println("2. Cold coffee");
            System.out.println("3. Cocoa Drink");
            System.out.println("4. No drinks for me");
            System.out.println("Enter your choice:");
            drinkChoice = scanner.nextInt();

            if (drinkChoice >= 1 && drinkChoice <= 4) {
                validDrink = true;
            } else {
                System.out.println("Invalid choice. Please pick only from the given list:");
            }
        }

        // 将饮料选择转换为饮料名称
        switch (drinkChoice) {
            case 1:
                drinks = "Coca Cola";
                break;
            case 2:
                drinks = "Cold coffee";
                break;
            case 3:
                drinks = "Cocoa Drink";
                break;
            case 4:
                drinks = "No drinks for me";
                break;
            default:
                drinks = "";
        }

        // 是否想要半价机会
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
        System.out.println("Adding drinks: " + drinks);
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
        Date birthdate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar nowCal = Calendar.getInstance();
        Calendar fiveYearsAgo = Calendar.getInstance();
        fiveYearsAgo.add(Calendar.YEAR, -5);
        Calendar oneHundredTwentyYearsAgo = Calendar.getInstance();
        oneHundredTwentyYearsAgo.add(Calendar.YEAR, -120);

        boolean validDate = false;
        while (!validDate) {
            System.out.println("Enter your birthday (MM/dd/yyyy):");
            String birthdateStr = scanner.next();
            try {
                birthdate = sdf.parse(birthdateStr);
                Calendar birthCal = Calendar.getInstance();
                birthCal.setTime(birthdate);
                if (birthCal.before(fiveYearsAgo) && birthCal.after(oneHundredTwentyYearsAgo)) {
                    validDate = true;
                } else {
                    System.out.println("Invalid date. You are either too young or too dead to order.");
                    System.out.println("Please enter a valid date:");
                }
            } catch (ParseException e) {
                System.out.println("Invalid date format.");
            }
        }

        Calendar birthCal = Calendar.getInstance();
        birthCal.setTime(birthdate);

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
        String expiryDate;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
        Calendar nowCal = Calendar.getInstance();
        boolean validExpiryDate = false;

        while (!validExpiryDate) {
            System.out.println("Enter the card’s expiry date (MM/yy):");
            expiryDate = scanner.next();
            try {
                Date expiry = sdf.parse(expiryDate);
                Calendar expiryCal = Calendar.getInstance();
                expiryCal.setTime(expiry);
                if (expiryCal.after(nowCal)) {
                    validExpiryDate = true;
                } else {
                    System.out.println("Invalid expiry date. Please enter a future date:");
                }
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter in MM/yy format:");
            }
        }

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