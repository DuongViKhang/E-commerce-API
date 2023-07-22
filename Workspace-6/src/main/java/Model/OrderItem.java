package Model;

public class OrderItem {
	int OrderItemId;
	int OrderId;
	int ProductId;
	int Count;
	public OrderItem() {
		super();
	}
	public OrderItem(int orderItemId, int orderId, int productId, int count) {
		super();
		OrderItemId = orderItemId;
		OrderId = orderId;
		ProductId = productId;
		Count = count;
	}
	public OrderItem(int orderId, int productId, int count) {
		super();
		OrderId = orderId;
		ProductId = productId;
		Count = count;
	}
	public int getOrderItemId() {
		return OrderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		OrderItemId = orderItemId;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
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
	@Override
	public String toString() {
		return "OrderItem [OrderItemId=" + OrderItemId + ", OrderId=" + OrderId + ", ProductId=" + ProductId
				+ ", Count=" + Count + "]";
	}
	
}
