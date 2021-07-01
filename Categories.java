package com.example.demo;

public class Categories {

	private long categoryID;
	private String categoryName;
	private String description;

	public Categories(long categoryID, String categoryName, String description) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.description = description;
	}

	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Categories [categoryID=" + categoryID + ", categoryName=" + categoryName + ", description="
				+ description + "]";
	}
}