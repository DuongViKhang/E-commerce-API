package Model;

import java.sql.Date;

public class Orders {
	int OrderId;
	int UserId;
	int StoreId;
	int DeliveryId;
	String Address;
	String Phone;
	int StatusId;
	int IsPay;
	int AmountFromUser;
	int AmountFromStore;
	int AmountToStore;
	int AmountToGD;
	String Email;
	Date Date;
	int IsDeleted;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(int orderId, int userId, int storeId, int deliveryId, String address, String phone, int statusId,
			int isPay, int amountFromUser, int amountFromStore, int amountToStore, int amountToGD, String email,
			Date date, int isDeleted) {
		super();
		OrderId = orderId;
		UserId = userId;
		StoreId = storeId;
		DeliveryId = deliveryId;
		Address = address;
		Phone = phone;
		StatusId = statusId;
		IsPay = isPay;
		AmountFromUser = amountFromUser;
		AmountFromStore = amountFromStore;
		AmountToStore = amountToStore;
		AmountToGD = amountToGD;
		Email = email;
		Date = date;
		IsDeleted = isDeleted;
	}
	public Orders(int userId, int storeId, int deliveryId, String address, String phone, int statusId,
			int isPay, int amountFromUser, int amountFromStore, int amountToStore, int amountToGD, String email,
			Date date, int isDeleted) {
		super();
		UserId = userId;
		StoreId = storeId;
		DeliveryId = deliveryId;
		Address = address;
		Phone = phone;
		StatusId = statusId;
		IsPay = isPay;
		AmountFromUser = amountFromUser;
		AmountFromStore = amountFromStore;
		AmountToStore = amountToStore;
		AmountToGD = amountToGD;
		Email = email;
		Date = date;
		IsDeleted = isDeleted;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}
	public int getDeliveryId() {
		return DeliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		DeliveryId = deliveryId;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public int getStatusId() {
		return StatusId;
	}
	public void setStatusId(int statusId) {
		StatusId = statusId;
	}
	public int getIsPay() {
		return IsPay;
	}
	public void setIsPay(int isPay) {
		IsPay = isPay;
	}
	public int getAmountFromUser() {
		return AmountFromUser;
	}
	public void setAmountFromUser(int amountFromUser) {
		AmountFromUser = amountFromUser;
	}
	public int getAmountFromStore() {
		return AmountFromStore;
	}
	public void setAmountFromStore(int amountFromStore) {
		AmountFromStore = amountFromStore;
	}
	public int getAmountToStore() {
		return AmountToStore;
	}
	public void setAmountToStore(int amountToStore) {
		AmountToStore = amountToStore;
	}
	public int getAmountToGD() {
		return AmountToGD;
	}
	public void setAmountToGD(int amountToGD) {
		AmountToGD = amountToGD;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
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
		return "Orders [OrderId=" + OrderId + ", UserId=" + UserId + ", StoreId=" + StoreId + ", DeliveryId="
				+ DeliveryId + ", Address=" + Address + ", Phone=" + Phone + ", StatusId=" + StatusId + ", IsPay="
				+ IsPay + ", AmountFromUser=" + AmountFromUser + ", AmountFromStore=" + AmountFromStore
				+ ", AmountToStore=" + AmountToStore + ", AmountToGD=" + AmountToGD + ", Email=" + Email + ", Date="
				+ Date + ", IsDeleted=" + IsDeleted + "]";
	}
	
}
