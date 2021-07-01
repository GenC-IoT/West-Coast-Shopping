package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class IoTShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(IoTShoppingApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//get Beans
		JdbcCustomerDao customers = (JdbcCustomerDao) context.getBean("customerDao");
		JdbcCategoriesDao categories = (JdbcCategoriesDao) context.getBean("categoriesDao");
		JdbcOrderDao orders = (JdbcOrderDao) context.getBean("orderDao");
		JdbcOrderDetailsDao orderDetails = (JdbcOrderDetailsDao) context.getBean("orderDetailsDao");
		JdbcProductDao products = (JdbcProductDao) context.getBean("productDao");
		JdbcSuppliersDao suppliers = (JdbcSuppliersDao) context.getBean("suppliersDao");
		
				
		//customers(String[5] CUSTOMERID*, String[40], String[30], String[60], String[15], String[15])
		Customer cus = new Customer("00001", "Cognizant", "Ian", "Street", "City", "CA");
		
		//categories(int CATEGORYID*, String[15], String[255])
		Categories cat = new Categories(1, "Food", "This item is food");
		
		//order(int ORDERID*, String[5] CUSTOMERID*, Date)
		Order ord = new Order(1, "00001", "07/01/2021");
		
		//suppliers(int SUPPLIERID*, String[40], String[30])
		Suppliers sup = new Suppliers(10, "Apple Supplier", "John");
				
		//product(int PRODUCTID*, String[40], int SUPPLIERID*, int CATEGORYID*, double[7])
		Product prod = new Product(1, "Apple", 10, 1, 1.99);
				
		//order details(int ORDERID*, int PRODUCTID*, SMALLINT)
		OrderDetails ordDet = new OrderDetails(1, 1, (short) 1);
		
		/*
		//insert all
		customers.insert(cus);
		categories.insert(cat);
		orders.insert(ord);
		suppliers.insert(sup);
		products.insert(prod);
		orderDetails.insert(ordDet);
		 */
		
		/*
		//update all
		customers.update(cus);
		categories.update(cat);
		orders.update(ord);
		suppliers.update(sup);
		products.update(prod);
		orderDetails.update(ordDet);
		*/
		
		/*
		//delete all 
		orderDetails.delete(ordDet);
		products.delete(prod);
		suppliers.delete(sup);
		orders.delete(ord);
		categories.delete(cat);
		customers.delete(cus);
		*/
	}

}
