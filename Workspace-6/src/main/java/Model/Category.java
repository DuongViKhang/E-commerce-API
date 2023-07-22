package Model;

public class Category {
	int CategoryId;
	String CategoryName;
	int StyleId;
	int IsDeleted;
	public Category() {
		super();
	}
	public Category(int categoryId, String categoryName, int styleId, int isDeleted) {
		super();
		CategoryId = categoryId;
		CategoryName = categoryName;
		StyleId = styleId;
		IsDeleted = isDeleted;
	}
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public int getStyleId() {
		return StyleId;
	}
	public void setStyleId(int styleId) {
		StyleId = styleId;
	}
	public int getIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		IsDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "Category [CategoryId=" + CategoryId + ", CategoryName=" + CategoryName + ", StyleId=" + StyleId
				+ ", IsDeleted=" + IsDeleted + "]";
	}
	
}
