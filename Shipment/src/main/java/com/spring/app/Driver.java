package com.spring.app;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

	public static void main(String[] args) {

        //Fill the code
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Scanner scanner = new Scanner(System.in);

        // Shipment 1
        System.out.println("Shipment Details1");

        System.out.println("Enter the Item Name");
        String itemName1 = scanner.nextLine();

        System.out.println("Enter the Item Price");
        double price1 = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter the ShipmentId");
        String shipmentId1 = scanner.nextLine();

        System.out.println("Enter the Delivery Status");
        String status1 = scanner.nextLine();

        Shipment shipment1 = context.getBean(Shipment.class);
        Item item1 = context.getBean(Item.class);
        item1.setItemName(itemName1);
        item1.setPrice(price1);

        shipment1.setItem(item1);
        shipment1.setShipmentId(shipmentId1);
        shipment1.setDeliveryStatus(status1);

        // Shipment 2
        System.out.println("\nShipment Details2");

        System.out.println("Enter the Item Name");
        String itemName2 = scanner.nextLine();

        System.out.println("Enter the Item Price");
        double price2 = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter the ShipmentId");
        String shipmentId2 = scanner.nextLine();

        System.out.println("Enter the Delivery Status");
        String status2 = scanner.nextLine();

        Shipment shipment2 = context.getBean(Shipment.class);
        Item item2 = context.getBean(Item.class);
        item2.setItemName(itemName2);
        item2.setPrice(price2);

        shipment2.setItem(item2);
        shipment2.setShipmentId(shipmentId2);
        shipment2.setDeliveryStatus(status2);

        // Output
        System.out.println("\nDelivery status of shipment ID: " + shipment1.getShipmentId() + " is " + shipment1.getDeliveryStatus());
        System.out.println("Delivery status of shipment ID: " + shipment2.getShipmentId() + " is " + shipment2.getDeliveryStatus());
	}	 

	
}
