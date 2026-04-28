# Online Shopping System (Java Console Application)

## Problem Statement

In many small-scale systems or learning environments, there is a need to simulate an online shopping platform that can handle:

* Customer/Seller registration
* Product management
* Cart operations
* Billing and checkout

The challenge is to design a simple system that performs these operations efficiently using core Java concepts without relying on databases or external frameworks.

---

## Approach / Logic Used

The application is built using Object-Oriented Programming (OOP) principles and Java collections.

### Key Components:

* Customer Class: Stores user details (ID, name, role)
* Products Class: Stores product details (ID, name, price, stock)
* CartItem Class: Stores cart details (product ID, name, quantity, total)

### Data Structures:

* ArrayList<Customer>: Stores customers
* ArrayList<Products>: Stores product list (menu)
* ArrayList<CartItem>: Stores cart items

### Core Logic:

1. Menu-driven program using a loop and switch-case
2. Users can:

   * Add customers/sellers
   * Add and view products
   * Add items to cart with stock validation
3. Cart system:

   * Calculates total cost
   * Applies coupon discount (dini gives ₹20 off)
4. Checkout simulation:

   * Option to proceed to payment
   * Option to cancel and clear cart with refund simulation

---

## Steps to Execute the Code

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/online-shopping-java.git
cd online-shopping-java
```

### 2. Compile the Java Files

```bash
javac Online.java
```

### 3. Run the Program

```bash
java Online
```

---

## Sample Execution Flow

1. Add Customer/Seller
2. Add Products
3. View Products
4. Add items to Cart
5. Apply coupon and checkout

---

## Coupon Feature

* Coupon Code: dini
* Discount: 20 rupees

---

## Limitations

* Data is stored only temporarily (no database)
* Console-based interface
* Basic validation and error handling

---

## Future Enhancements

* Integration with database such as MySQL or MongoDB
* Graphical or web-based interface
* User authentication system
* Order history and tracking
* Payment gateway integration

---

## Author

Dinisha R

---

## License

This project is for educational purposes.
