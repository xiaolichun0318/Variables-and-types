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

    public void takeOrder(String id, String ingredients, String side, String drink) {
        this.setOrderID(id);
        this.setOrderTotal(pizzaPrice);
        this.pizzaIngredients = ingredients;
        this.sides = side;
        this.drinks = drink;
        System.out.println("Order accepted!");
        System.out.println("Preparing your pizza...");
        makePizza(ingredients);
        System.out.println("Your pizza is ready!");
        System.out.println("Adding sides: " + side);
        System.out.println("Adding drinks: " + drink);
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

    public void processCardPayment(String cardNumber, String expiryDate, int cvv) {
        int cardLength = cardNumber.length();
        if (cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
        }

        int firstCardDigit = Integer.parseInt(cardNumber.substring(0, 1));

        String blacklistedNumber = "12345678901234";
        if (cardNumber.equals(blacklistedNumber)) {
            System.out.println("Card is blacklisted. Please use another card");
        }

        int lastFourDigits = Integer.parseInt(cardNumber.substring(cardNumber.length() - 4));

        StringBuilder cardNumberToDisplayBuilder = new StringBuilder(cardNumber);
        for (int i = 1; i < cardNumber.length() - 4; i++) {
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

    public static void main(String[] args) {
        SliceOHeaven pizzeria = new SliceOHeaven("Slice - o - Heaven", "123 Pizza St", "info@sliceoheaven.com", 1234567890L,
                "Pizza, Sides");
        pizzeria.pizzaPrice = 20.0;
        pizzeria.takeOrder("SOH - 123", "Pepperoni, Mushrooms", "Garlic Bread", "Cola");

        pizzeria.processCardPayment("12345678901234", "12/25", 123);
        pizzeria.specialOfTheDay("Margherita Pizza", "Fries", "$12.99");
    }
}