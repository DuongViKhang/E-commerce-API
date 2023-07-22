package Model;

import java.util.Date;

public class CartItem {
	int CartItemId;
	int CartId;
	int ProductId;
	int Count;
	Date DateCre;
	int IsDeleted;
	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CartItem(int cartItemId, int cartId, int productId, int count, Date dateCre, int isDeleted) {
		super();
		CartItemId = cartItemId;
		CartId = cartId;
		ProductId = productId;
		Count = count;
		DateCre = dateCre;
		IsDeleted = isDeleted;
	}

	public int getCartItemId() {
		return CartItemId;
	}
	public void setCartItemId(int cartItemId) {
		CartItemId = cartItemId;
	}
	public int getCartId() {
		return CartId;
	}
	public void setCartId(int cartId) {
		CartId = cartId;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public Date getDateCre() {
		return DateCre;
	}
	public void setDateCre(Date dateCre) {
		DateCre = dateCre;
	}
	public int getIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		IsDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "CartItem [CartItemId=" + CartItemId + ", CartId=" + CartId + ", ProductId=" + ProductId + ", Count="
				+ Count + ", DateCre=" + DateCre + ", IsDeleted=" + IsDeleted + "]";
	}
	
}
