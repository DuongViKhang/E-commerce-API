package Model;

public class Delivery {
	int DeliveryId;
	String DeliveryName;
	String Decription;
	int Price;
	int IsDeleted;
	public Delivery() {
		super();
	}
	public Delivery(int deliveryId, String deliveryName, String decription, int price, int isDeleted) {
		super();
		DeliveryId = deliveryId;
		DeliveryName = deliveryName;
		Decription = decription;
		Price = price;
		IsDeleted = isDeleted;
	}
	public int getDeliveryId() {
		return DeliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		DeliveryId = deliveryId;
	}
	public String getDeliveryName() {
		return DeliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		DeliveryName = deliveryName;
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
	public int getIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		IsDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "Delivery [DeliveryId=" + DeliveryId + ", DeliveryName=" + DeliveryName + ", Decription=" + Decription
				+ ", Price=" + Price + ", IsDeleted=" + IsDeleted + "]";
	}
	
}
