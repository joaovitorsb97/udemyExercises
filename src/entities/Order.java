package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	List<OrderItem> items = new ArrayList<>();
	
	public Order(Date moment, OrderStatus status, Client client) {
		
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Order() {
		
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItems() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		this.items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.items.remove(item);
	}
	
	public double total() {
		
		double total = 0;
		
		for(OrderItem orderItem : items) {
			total = total + orderItem.subTotal();
		}
		return total;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf1.format(moment));
		sb.append("\nOrder status: " + status);
		sb.append("\nClient: " + client.getName() + " - " + client.getEmail());
		sb.append("\nOrder Items:");
		for(OrderItem odItems : items) {
			sb.append("\n" + odItems.getProduct().getName() + ", $" 
			+ String.format("%.2f", odItems.getPrice()) 
			+ ", Quantity: " 
			+ odItems.getQuantity() 
			+ ", Subtotal: $" 
			+ String.format("%.2f", odItems.subTotal()));
		}
		
		sb.append("\nTotal price: $" + String.format("%.2f", total()));
		
		return sb.toString();
	}
}
