import java.util.*;

public class Online{
      static List<Customer> cus= new ArrayList<>();
      static ArrayList<Products> menu = new ArrayList<>();
    static ArrayList<CartItem> cart = new ArrayList<>();
      static int cusId=1;
      static int ProductId=1;
      public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.println("1. Add Customer/Seller");
            System.out.println("2. Add Products");
            System.out.println("3. View Products");
            System.out.println("4. Add to Cart");
            System.out.println("5. Display Cart");
            System.out.println("6. Exit");
            System.out.println("Enter Your choice: ");
            int choice= sc.nextInt();
            switch(choice){
                case 1:
                    AddCustomer(sc);
                    break;
                case 2:
                    AddProducts(sc);
                    break;
                case 3:
                    System.out.println("ID  | Product name  | price  | Stocks");
                    ViewProducts();
                    break;
                case 4:
                    AddToCart(sc);
                    break;
                case 5:
                    DisplayCart(sc);
                    break;
                case 6:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Invalid Choice...Please enter the number between (1-5)");
                    return;
            }

        }
      }
      static void AddCustomer(Scanner sc){
            System.out.println("Enter the name : ");
            String str= sc.nextLine();
            sc.nextLine();
            System.out.println("Are you a Customer or Seller? , Enter (c/s): ");
            char des=sc.nextLine().charAt(0);
            System.out.println("Successfully registered !");
            cus.add(new Customer(cusId,str,des));

      }

      static void ViewProducts(){
           for (Products p : menu) {
            
            System.out.println(p.ProductId + "   | " + p.name + "         |Rs." + p.price +"|"+ p.stock);
        }
      }

      static void AddProducts(Scanner sc){
          System.out.println("Enter Product Name:");
        String name = sc.next();

        System.out.println("Enter Price:");
        int price = sc.nextInt();
        System.out.println("Enter the stocks available: ");
        int stock=sc.nextInt();
        menu.add(new Products(ProductId, name, price,stock));

        System.out.println("Product added with ID: " + ProductId);

        ProductId++;
      }

    static void AddToCart(Scanner sc){
        System.out.println("Enter Product ID:");
        int id = sc.nextInt();
        Products selected = null;
        for (Products p : menu) {
            if (p.ProductId == id) {
                selected = p;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Product not found");
            return;
        }
        System.out.println("Enter Quantity:");
        int qty = sc.nextInt();
        if(qty>selected.stock){
            System.out.println("Out of stock( Available"+selected.stock+")");
            return;
        }
        int total = qty * selected.price;
        cart.add(new CartItem(selected.ProductId, selected.name, qty, total));
        System.out.println("Added to cart");
        selected.stock=selected.stock-qty;
      }

      static void DisplayCart(Scanner sc){
           int totalAmount = 0;

        System.out.println("\n--- CART ---");

        for (CartItem c : cart) {
            System.out.println(c.name + " x" + c.quantity + " = " + c.total);
            totalAmount += c.total;
        }

        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Coupon available?: Add");
        String c= sc.nextLine();
        sc.nextLine();
        if(c.equals("dini")){
            totalAmount=totalAmount-20;
            
        }
        System.out.println("-----");
        System.out.println("Total Amount: " + (totalAmount-(totalAmount*0.02)));
        System.out.println("Proceed to payment (y/n): ");
        String con= sc.next();
        if(con.equals("y")) {
            System.out.println("Redirecting to the payment gateway");
            cart.clear();
            
        }
        
        if(con.equals("n")) { 
            System.out.println("Clear Cart? (y/n):");
            String con1= sc.next();
            if(con1.equals("n")) cart.clear();
            System.out.println("Full refund initiated");
        }
      }
}