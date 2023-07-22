package Model;

import java.util.Date;

public class Transactions {
	int TransactionId;
	int UserId;
	int StoreId;
	int Amount;
	Date date;
	int IsDeleted;
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transactions(int transactionId, int userId, int storeId, int amount, Date date, int isDeleted) {
		super();
		TransactionId = transactionId;
		UserId = userId;
		StoreId = storeId;
		Amount = amount;
		this.date = date;
		IsDeleted = isDeleted;
	}
	public int getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
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
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		IsDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "Transactions [TransactionId=" + TransactionId + ", UserId=" + UserId + ", StoreId=" + StoreId
				+ ", Amount=" + Amount + ", date=" + date + ", IsDeleted=" + IsDeleted + "]";
	}
	
	
}
