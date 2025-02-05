import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    public List<Item> items = new ArrayList<>();
	
    public double total; 

    public void addItem(String name, double price) {
        
		if (name == null || price < 0) {
            System.out.println("Item inválido.");
            return;
        }
        items.add(new Item(name, price));
        total += price; 
    }

    public void removeItem(String name) {
        for (Item item : items) {
            if (item.name.equals(name)) {
                items.remove(item); 
                total -= item.price; 
                break; 
            }
        }
    }

    public double applyDiscount(String code) {
	
        if (code.equals("DISCOUNT10")) {
            total *= 0.9;
        } else if (code.equals("DISCOUNT50")) {
            total *= 0.5;
        } else {
            System.out.println("Código de desconto inválido.");
        }
        return total; 
    }

    public void printCart() {
        System.out.println("Carrinho de compras:");
        for (Item item : items) {
            System.out.println(item.name + " - R$ " + item.price);
        }
        System.out.println("Total: R$ " + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Notebook", 3000);
        cart.addItem("Mouse", -50); 
        cart.addItem("Notebook", 3000); 
        cart.removeItem("Notebook"); 
        cart.applyDiscount("DISCOUNT10"); 
        cart.applyDiscount("INVALID"); 
        cart.printCart();
    }
}

class Item {
    public String name; 
    public double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}