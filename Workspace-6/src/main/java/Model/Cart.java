package Model;

public class Cart {
	int CartId;
	int UserId;
	public Cart() {
		super();
	}
	public Cart(int cartId, int userId) {
		super();
		CartId = cartId;
		UserId = userId;
	}
	public int getCartId() {
		return CartId;
	}
	public void setCartId(int cartId) {
		CartId = cartId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	@Override
	public String toString() {
		return "Cart [CartId=" + CartId + ", UserId=" + UserId + "]";
	}
	
}
