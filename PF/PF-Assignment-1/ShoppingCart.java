import java.util.*;
class Item
{
	String name;
	int quantity;
	double price;
	
	public Item(String name, int quantity, double price)
	{
		this.name=name;
		this.quantity=quantity;
		this.price=price;
	}
	public String getName(){
		return name;
	}
	public int getQuantity(){
		return quantity;
	}
	public double getPrice(){
		return price;
	}
	public double total()
	{
		return getPrice()*getQuantity();
	}
	
}
class ShoppingCart
{
	public static void addItem(HashMap cart)
	{
		String name;
		int quantity;
		double price;
		System.out.print("\nEnter item name: ");
		Scanner sc=new Scanner(System.in);
		name=sc.next();
		System.out.print("Enter quantity: ");
		quantity=sc.nextInt();
		System.out.print("Enter price: ");
		price=sc.nextDouble();
		
		Item newItem=new Item(name, quantity, price);
		cart.put(name, newItem);
	}
	
	public static void removeItem(HashMap cart)
	{
		String name;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter item's name to be removed : ");
		name = sc.next();
		Item value = Item.class.cast(cart.get(name));
		if(value != null) 
		{
			System.out.println("Item successfully removed.");
			cart.remove(name);
		} else 
			System.out.println("Item not found!!!");
	}
	public static void showItems(HashMap cart)
	{
		System.out.println("\n\n--CART DETAILS--\n");
		for(Object obj : cart.values())
		{
			Item item = Item.class.cast(obj);
			System.out.println("Name: "+item.getName());
			System.out.println("Quantity: "+item.getQuantity());
			System.out.println("Price: "+item.getPrice());
		}
	}
	public static void total(HashMap cart)
	{
		double total=0;
		for(Object obj: cart.values())
		{
			Item item = Item.class.cast(obj);
			total+=item.total();
		}
		System.out.println("Total is: "+total);
	}
	public static void main(String args[])
	{
		HashMap<String,Item> cart=new HashMap<String,Item>();
		char continu;
		int choice;
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println("\n\nSHOPPING CART MENU!!");
			System.out.println("1.Add an item");
			System.out.println("2.Remove an item");
			System.out.println("3.Update an item");
			System.out.println("4.Show items in your cart");
			System.out.println("5.Checkout");
			System.out.print("\nEnter your choice: ");
			choice=sc.nextInt();
			
			switch(choice)
			{
				case 1: addItem(cart); break;
				case 2: removeItem(cart); break;
				case 3: break;
				case 4: showItems(cart); break;
				case 5: total(cart); break;
				default: System.out.print("Invalid input"); break;
			}
			System.out.print("\nDo you want to continue? (Y/N): ");
			continu = sc.next().charAt(0);
		}while(continu=='Y' || continu=='y');
	}
}