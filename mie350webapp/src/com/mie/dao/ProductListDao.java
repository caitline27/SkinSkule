package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Product;
import com.mie.model.Student;
import com.mie.util.DbUtil;

public class ProductListDao {
	//here is some comments

	/**
	 * This class handles all of the Product-related methods
	 * (get).
	 */

	private Connection connection;

	public ProductListDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public List<Product> getAllProduct() {
		/**
		 * This method returns the list of all products in the form of a List
		 * object.
		 */
		List<Product> products = new ArrayList<Product>();
		try {
			Statement statement = connection.createStatement();
			// System.out.println("getting products from table");
			ResultSet rs = statement.executeQuery("select * from Products");
			while (rs.next()) {
				Product prod = new Product();
				prod.setBrandID(rs.getInt("brandID"));
				prod.setSkinType(rs.getString("skinType"));
				prod.setProductID(rs.getInt("productID"));
				prod.setProductType(rs.getString("productType"));
				prod.setPurpose(rs.getString("purpose"));
				prod.setProductName(rs.getString("productName"));
				prod.setRating(rs.getInt("ratings"));
				prod.setUsage(rs.getString("productID"));
				prod.setActiveIngredient(rs.getString("activeIngredient"));
				prod.setPrice(rs.getDouble("purpose"));
				prod.setSize(rs.getInt("productName"));
				prod.setPricePerMl(rs.getDouble("pricePerMl"));
				products.add(prod);
			
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
	
	public List<Product> getProductsByPT(String pT) {
		/**
		 * This method retrieves a list of products that matches the product type pT
		 * selected by the user in the drop down.
		 */
		List<Product> products = new ArrayList<Product>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Products where ProductTypes LIKE ?");

			preparedStatement.setString(1, "%" + pT + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Product prod = new Product();
				prod.setProductName(rs.getString("productName"));
				products.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}


}


