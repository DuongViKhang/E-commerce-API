package Model;

public class StatusOrder {
	int StatusId;
	String StatusName;
	int IsDeleted;
	public StatusOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatusOrder(int statusId, String statusName, int isDeleted) {
		super();
		StatusId = statusId;
		StatusName = statusName;
		IsDeleted = isDeleted;
	}
	public int getStatusId() {
		return StatusId;
	}
	public void setStatusId(int statusId) {
		StatusId = statusId;
	}
	public String getStatusName() {
		return StatusName;
	}
	public void setStatusName(String statusName) {
		StatusName = statusName;
	}
	public int getIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		IsDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "StatusOrder [StatusId=" + StatusId + ", StatusName=" + StatusName + ", IsDeleted=" + IsDeleted + "]";
	}
	
}
