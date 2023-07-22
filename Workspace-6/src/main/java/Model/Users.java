package Model;

import java.sql.Date;

public class Users {
	int UserId;
	String UserName;
	String IdCard;
	String Email;
	String Phone;
	int IsEmailActive;
	String Password;
	int RoleId;
	String Address;
	String Avatar;
	Date Date;
	int IsDeleted;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int userId, String userName, String idCard, String email, String phone, int isEmailActive,
			String password, int roleId, String address, String avatar, java.sql.Date date, int isDeleted) {
		super();
		UserId = userId;
		UserName = userName;
		IdCard = idCard;
		Email = email;
		Phone = phone;
		IsEmailActive = isEmailActive;
		Password = password;
		RoleId = roleId;
		Address = address;
		Avatar = avatar;
		Date = date;
		IsDeleted = isDeleted;
	}
	
	public Users(String userName, String idCard, String email, String phone, int isEmailActive,
			String password, int roleId, String address, String avatar, java.sql.Date date, int isDeleted) {
		super();
		UserName = userName;
		IdCard = idCard;
		Email = email;
		Phone = phone;
		IsEmailActive = isEmailActive;
		Password = password;
		RoleId = roleId;
		Address = address;
		Avatar = avatar;
		Date = date;
		IsDeleted = isDeleted;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getIdCard() {
		return IdCard;
	}
	public void setIdCard(String idCard) {
		IdCard = idCard;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public int getIsEmailActive() {
		return IsEmailActive;
	}
	public void setIsEmailActive(int isEmailActive) {
		IsEmailActive = isEmailActive;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getRoleId() {
		return RoleId;
	}
	public void setRoleId(int roleId) {
		RoleId = roleId;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getAvatar() {
		return Avatar;
	}
	public void setAvatar(String avatar) {
		Avatar = avatar;
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
		return "Users [UserId=" + UserId + ", UserName=" + UserName + ", IdCard=" + IdCard + ", Email=" + Email
				+ ", Phone=" + Phone + ", IsEmailActive=" + IsEmailActive + ", Password=" + Password + ", RoleId="
				+ RoleId + ", Address=" + Address + ", Avatar=" + Avatar + ", Date=" + Date + ", IsDeleted=" + IsDeleted
				+ "]";
	}
	
}
