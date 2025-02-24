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


    public SliceOHeaven(String name, String address, String email, long phone, String menu) {
        this.storeName = name;
        this.storeAddress = address;
        this.storeEmail = email;
        this.storePhone = phone;
        this.storeMenu = menu;
    }

    
    public void takeOrder(String id, String ingredients, String side, String drink) {
        this.orderID = id;
     
        this.orderTotal = pizzaPrice;
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

    // 打印收据的方法
    private void printReceipt() {
        System.out.println("********RECEIPT********");
        System.out.println("Store Name: " + storeName);
        System.out.println("Order ID: " + orderID);
        System.out.println("Pizza Ingredients: " + pizzaIngredients);
        System.out.println("Sides: " + sides);
        System.out.println("Drinks: " + drinks);
        System.out.println("Order Total: $" + orderTotal);
    }

    public static void main(String[] args) {
        SliceOHeaven pizzeria = new SliceOHeaven("Slice-o-Heaven", "123 Pizza St", "info@sliceoheaven.com", 1234567890L, "Pizza, Sides, Drinks");
        pizzeria.pizzaPrice = 12.99;
        pizzeria.pizzaIngredients = "Cheese, Pepperoni, Mushrooms";
        pizzeria.sides = "Garlic Bread";
        pizzeria.drinks = "Coke";
        pizzeria.takeOrder("ORD123", pizzeria.pizzaIngredients, pizzeria.sides, pizzeria.drinks);
    }
}