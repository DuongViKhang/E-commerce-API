package Model;

import java.util.Date;

public class Store {
	int StoreId;
	String StoreName;
	String Bio;
	int UserId;
	int IsActive;
	int IsOpen;
	String Avatar;
	float Rating;
	Date Date;
	int IsDeleted;
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Store(int storeId, String storeName, String bio, int userId, int isActive, int isOpen, String avatar,
			float rating, java.util.Date date, int isDeleted) {
		super();
		StoreId = storeId;
		StoreName = storeName;
		Bio = bio;
		UserId = userId;
		IsActive = isActive;
		IsOpen = isOpen;
		Avatar = avatar;
		Rating = rating;
		Date = date;
		IsDeleted = isDeleted;
	}
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}
	public String getStoreName() {
		return StoreName;
	}
	public void setStoreName(String storeName) {
		StoreName = storeName;
	}
	public String getBio() {
		return Bio;
	}
	public void setBio(String bio) {
		Bio = bio;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getIsActive() {
		return IsActive;
	}
	public void setIsActive(int isActive) {
		IsActive = isActive;
	}
	public int getIsOpen() {
		return IsOpen;
	}
	public void setIsOpen(int isOpen) {
		IsOpen = isOpen;
	}
	public String getAvatar() {
		return Avatar;
	}
	public void setAvatar(String avatar) {
		Avatar = avatar;
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
		return "Store [StoreId=" + StoreId + ", StoreName=" + StoreName + ", Bio=" + Bio + ", UserId=" + UserId
				+ ", IsActive=" + IsActive + ", IsOpen=" + IsOpen + ", Avatar=" + Avatar + ", Rating=" + Rating
				+ ", Date=" + Date + ", IsDeleted=" + IsDeleted + "]";
	}
	
}
