package Model;

public class Roles {
	int RoleId;
	String RoleName;
	int IsDeleted;
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Roles(int roleId, String roleName, int isDeleted) {
		super();
		RoleId = roleId;
		RoleName = roleName;
		IsDeleted = isDeleted;
	}
	public int getRoleId() {
		return RoleId;
	}
	public void setRoleId(int roleId) {
		RoleId = roleId;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	public int getIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		IsDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "Roles [RoleId=" + RoleId + ", RoleName=" + RoleName + ", IsDeleted=" + IsDeleted + "]";
	}
	
}
