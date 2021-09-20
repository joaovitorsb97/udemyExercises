package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("Email:");
		String email = sc.nextLine();
		System.out.println("Birth date (DD/MM/YYYY):");
		Date date = sdf.parse(sc.next());
		
		Client c1 = new Client(name, email, date);
		
		System.out.println("Enter order data:");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, c1);
		
		System.out.println("How many items to this order?");
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.println("Enter #" + (i+1) + " data:");
			System.out.println("Product name:");
			String itemName = sc.nextLine();
			System.out.println("Product price:");
			double itemPrice = sc.nextDouble();
			System.out.println("Quantity:");
			int quantity = sc.nextInt();
			
			Product pdt = new Product(itemName, itemPrice);
			
			OrderItem items = new OrderItem(quantity, itemPrice, pdt);
			
			order.addItem(items);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		
		sc.close();
	
	}

}
