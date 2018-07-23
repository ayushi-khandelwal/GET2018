import java.util.*;
import java.util.Calendar;
class Item
{
	String name;
	int quantity;
	double price;
	
	Item(String name, int quantity, double price)
	{
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public String getName()
	{
		return name;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public double getPrice()
	{
		return price;
	}
}
class CartMethods
{
	Map<String,Item> cart = new HashMap<String,Item>();
	public void addItem()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter item name : ");
		String name = scan.next();
		System.out.print("Enter quantity : ");
		int quantity = scan.nextInt();
		System.out.print("Enter price : ");
		double price = scan.nextDouble();
		Item newItem = new Item(name, quantity, price);
		cart.put(name,newItem);
	}
	public void removeItem()
	{
		
		System.out.print("\nEnter the item name to delete : ");
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		Item value = Item.class.cast(cart.get(name));
		if(value!=null)
		{
			System.out.println("Item removed successfully");
			cart.remove(name);
		}
		else
			System.out.println("Item not found!");
	}
	public void updateItem()
	{
		System.out.print("\nEnter the item name to update : ");
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		Item value = Item.class.cast(cart.get(name));
		if(value!=null)
		{
			cart.remove(name);
			addItem();
		}
		else
			System.out.println("Item not found");
	}
	public void showItems()
	{
		System.out.println("\nMy cart");
		for(Object obj : cart.values())
		{
			Item item = Item.class.cast(obj);
			System.out.println("Name : " + item.getName());
			System.out.println("Quantity : " + item.getQuantity());
			System.out.println("Price : " + item.getPrice());
		}
	}
	public void billing(FixedProductPromotion fixedProductPromotion, FixedOrderPromotion fixedOrderPromotion)
	{
		int totalQuantity = 0;
		double totalPrice = 0.0;
		String promotionCode = "";
		double totalDiscount = 0.0;
		System.out.println("--PAYMENT--");
		for(Object obj : cart.values())
		{
			Item item = Item.class.cast(obj);
			totalQuantity += item.getQuantity();
			totalPrice += item.getPrice() * item.getQuantity();
		}
		System.out.println("Total quantity is " + totalQuantity);
		System.out.println("Total price is " + totalPrice);
		System.out.println("Amount payable now is " + totalPrice);
		System.out.print("Enter promocode(if you have any) : ");
		Scanner scan = new Scanner(System.in);
		promotionCode = scan.next();
		if(fixedOrderPromotion.isPromotionApplicable(totalPrice, promotionCode))
		{
			totalDiscount = totalPrice * fixedOrderPromotion.getFixedDiscount();
		}
		else if(fixedProductPromotion.isPromotionApplicable(totalQuantity, totalPrice, promotionCode))
		{
			totalDiscount = totalPrice * fixedProductPromotion.getFixedDiscount();
		}
		System.out.println("Discount applicable using promocode is " + totalDiscount);
		System.out.println("Payable amount is " + (totalPrice-totalDiscount));
	}
}

interface Promotion
{
	enum PromotionEnum
	{
		get10("GET10",1,5),avail10("AVAIL10", 15,20),free10("FREE10", 25,30);
		String code;
		int startDate;
		int endDate;
		
		private PromotionEnum(String code, int startDate, int endDate)
		{
			this.code = code;
			this.startDate = startDate;
			this.endDate = endDate;
		}
		public String getCode()
		{
			return code;
		}
		public int getStartDate()
		{
			return startDate;
		}
		public int getEndDate()
		{
			return endDate;
		}
	}
}
class FixedProductPromotion implements Promotion
{
	int minQuantity; 
	double minPrice;
	double fixedDiscount;
	public FixedProductPromotion(int minProducts, double minPayment)
	{
		setMinimumPrice(minProducts, minPayment);
		setFixedDiscount();
	}
	public double getMinimumPrice()
	{
		return minPrice;
	}
	public int getMinimumQuantity()
	{
		return minQuantity;
	}
	public void setMinimumPrice(int quantity, double price)
	{
		minQuantity = quantity;
		minPrice = price;
	}
	public double getFixedDiscount()
	{
		return fixedDiscount;
	}
	public void setFixedDiscount() {
		fixedDiscount = 0.10;	//avail 10% discount
	}
	public boolean isPromotionApplicable(int finalProducts, double totalBill, String usercode)
	{
		Calendar calendar = Calendar.getInstance();
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if(finalProducts >= getMinimumQuantity())
		{
			for(PromotionEnum promoEnum : PromotionEnum.values())
			{
				if(usercode.equals(promoEnum.getCode()))
				{
					if(dayOfMonth <= promoEnum.endDate && dayOfMonth >= promoEnum.startDate)
					return true;
					else
					return false;
				}
				else
				System.out.println("Promocode is not available today!");
			}
		}
		else
		System.out.println("Get more products to avail discount");
	return false;
	}
}
class FixedOrderPromotion implements Promotion
{
	double minPrice;
	double fixedDiscount;
	int minQuantity;
	public FixedOrderPromotion(double minPayment)
	{
		setMinimumPrice(minPayment);
		setFixedDiscount();
	}
	public double getMinimumPrice()
	{
		return minPrice;
	}
	public int getMinimumQuantity()
	{
		return minQuantity;
	}
	public void setMinimumPrice(double price)
	{
		minPrice = price;
	}
	public double getFixedDiscount()
	{
		return fixedDiscount;
	}
	public void setFixedDiscount()
	{
		fixedDiscount = 0.10;	//avail 10% discount
	}
	public boolean isPromotionApplicable(double totalBill, String usercode)
	{
		Calendar calendar = Calendar.getInstance();
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if(totalBill >= getMinimumPrice())
		{
			for(PromotionEnum promoEnum : PromotionEnum.values())
			{
				if(usercode.equals(promoEnum.getCode()))
				{
					if(dayOfMonth <= promoEnum.endDate && dayOfMonth >= promoEnum.startDate)
						return true;
					else
						return false;
				}
				else
				System.out.println("Promocode is not available now!");
			}
		}
		else
		System.out.println("Your amount don't reach yet to avail discount");
		return false;
	}
}
public class ShoppingCart
{
	public static void main(String args[])
	{
		CartMethods cartMethods = new CartMethods();
		FixedProductPromotion fixedProductPromotion = new FixedProductPromotion(15, 2000.0);
		FixedOrderPromotion fixedOrderPromotion = new FixedOrderPromotion(4000.0);
		Scanner sc = new Scanner(System.in);
		char proceed = 'a';
		do
		{
			System.out.println("\n--SHOPPING CART MENU--");			
			System.out.println("1.Add an item");			
			System.out.println("2.Remove an item");			
			System.out.println("3.Update an item");			
			System.out.println("4.Show cart items");			
			System.out.println("5.Show total bill");			
			System.out.println("6.Exit");					
			System.out.print("Enter your choice: ");		
			int choice = sc.nextInt();
			switch(choice)
			{		
				case 1: cartMethods.addItem(); break;
				case 2: cartMethods.removeItem(); break;
				case 3: cartMethods.updateItem(); break;
				case 4: cartMethods.showItems(); break;
				case 5: cartMethods.billing(fixedProductPromotion, fixedOrderPromotion); break;
				case 6: return; 
				default: System.out.println("Invalid input");			
			}
			System.out.print("\nPress 'Y' for continue and 'N' for exit: ");
			proceed = sc.next().charAt(0);
			while(!(proceed=='Y' || proceed=='y' || proceed=='N' || proceed=='n'))
			{
				System.out.println("Invalid input");
				System.out.print("Press 'Y' for continue and 'N' for exit: ");
				proceed=sc.next().charAt(0);
			}	
			System.out.print("\n");
		}while(proceed=='Y' || proceed=='y');	
	}
}