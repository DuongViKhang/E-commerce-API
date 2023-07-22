package Model;

import java.util.Date;

public class Product {
	int ProductId;
	String ProductName;
	String Decription;
	int Price;
	int SalePrice;
	int PromotionalPrice;
	int Quantity;
	int Sold;
	int IsActive;
	int IsSell;
	String Image;
	int CategoryId;
	int StyleId;
	int StoreId;
	float Rating;
	Date Date;
	int IsDeleted;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String productName, String decription, int price, int salePrice, int promotionalPrice,
			int quantity, int sold, int isActive, int isSell, String image, int categoryId, int styleId, int storeId,
			float rating, java.util.Date date, int isDeleted) {
		super();
		ProductId = productId;
		ProductName = productName;
		Decription = decription;
		Price = price;
		SalePrice = salePrice;
		PromotionalPrice = promotionalPrice;
		Quantity = quantity;
		Sold = sold;
		IsActive = isActive;
		IsSell = isSell;
		Image = image;
		CategoryId = categoryId;
		StyleId = styleId;
		StoreId = storeId;
		Rating = rating;
		Date = date;
		IsDeleted = isDeleted;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getDecription() {
		return Decription;
	}
	public void setDecription(String decription) {
		Decription = decription;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getSalePrice() {
		return SalePrice;
	}
	public void setSalePrice(int salePrice) {
		SalePrice = salePrice;
	}
	public int getPromotionalPrice() {
		return PromotionalPrice;
	}
	public void setPromotionalPrice(int promotionalPrice) {
		PromotionalPrice = promotionalPrice;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getSold() {
		return Sold;
	}
	public void setSold(int sold) {
		Sold = sold;
	}
	public int getIsActive() {
		return IsActive;
	}
	public void setIsActive(int isActive) {
		IsActive = isActive;
	}
	public int getIsSell() {
		return IsSell;
	}
	public void setIsSell(int isSell) {
		IsSell = isSell;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public int getStyleId() {
		return StyleId;
	}
	public void setStyleId(int styleId) {
		StyleId = styleId;
	}
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}
	public float getRating() {
		return Rating;
	}
	public void setRating(float rating) {
		Rating = rating;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public int getIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		IsDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", Decription=" + Decription
				+ ", Price=" + Price + ", SalePrice=" + SalePrice + ", PromotionalPrice=" + PromotionalPrice
				+ ", Quantity=" + Quantity + ", Sold=" + Sold + ", IsActive=" + IsActive + ", IsSell=" + IsSell
				+ ", Image=" + Image + ", CategoryId=" + CategoryId + ", StyleId=" + StyleId + ", StoreId=" + StoreId
				+ ", Rating=" + Rating + ", Date=" + Date + ", IsDeleted=" + IsDeleted + "]";
	}
	
}
