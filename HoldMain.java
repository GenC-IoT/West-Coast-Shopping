package com.test;

public class HoldMain {

	public static void main(String[] args) {
		DBConnection db = new DBConnection();
		
		//CUSTOMERS 
		JdbcCustomerDao jdbcCustomer = new JdbcCustomerDao();
		Customer customer0 = new Customer("A1234", "Cognizant", "Ian", "Appalachian", "Claremont", "CA");
		//jdbcCustomer.insert(customer0); 	// :)
		//jdbcCustomer.update(customer0); 	// :)
		//jdbcCustomer.delete(customer0); 	// :)
		
		//CATEGORIES 
		JdbcCategoriesDao jdbcCategories = new JdbcCategoriesDao();
		Categories category0 = new Categories();
		//jdbcCategories.insert(category0); 	// :)
		//jdbcCategories.update(category0); 	// :)
		//jdbcCategories.delete(category0); 	// :( FOREIGN KEY CONSTRAINT CANNOT PERFORM
		
		//ORDERS 
		JdbcOrderDao jdbcOrders = new JdbcOrderDao();
		Order order0 = new Order();
		//jdbcOrders.insert(order0); 	// :)
		//jdbcOrders.update(order0); 	// :)
		//jdbcOrders.delete(order0); 	// :( FOREIGN KEY CONSTRAINT CANNOT PERFORM
		
		//ORDERDETAILS 
		JdbcOrderDetailsDao jdbcOrderDetails = new JdbcOrderDetailsDao();
		OrderDetails orderDetails0 = new OrderDetails();
		//jdbcOrderDetails.insert(orderDetails0); 	//:)
		//jdbcOrderDetails.update(orderDetails0); 	// :)
		//jdbcOrderDetails.delete(orderDetails0); 	// :)
		
		//PRODUCTS 
		JdbcProductDao jdbcProducts = new JdbcProductDao();
		Product product0 = new Product();
		//jdbcProducts.insert(product0); 	// :)
		//jdbcProducts.update(product0); 	// :)
		//jdbcProducts.delete(product0); 	// :)
		
		//SUPPLIERS 
		JdbcSuppliersDao jdbcSuppliers = new JdbcSuppliersDao();
		Suppliers supplier0 = new Suppliers();
		//jdbcSuppliers.insert(supplier0); 	// :)
		//jdbcSuppliers.update(supplier0); 	// :)
		//jdbcSuppliers.delete(supplier0); 	// :)
		
	}

}
