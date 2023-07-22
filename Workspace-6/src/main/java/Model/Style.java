package Model;

public class Style {
	int StyleId;
	String StyleName;
	int IsDeleted;
	public Style() {
		super();
	}
	public Style(int styleId, String styleName, int isDeleted) {
		super();
		StyleId = styleId;
		StyleName = styleName;
		IsDeleted = isDeleted;
	}
	public int getStyleId() {
		return StyleId;
	}
	public void setStyleId(int styleId) {
		StyleId = styleId;
	}
	public String getStyleName() {
		return StyleName;
	}
	public void setStyleName(String styleName) {
		StyleName = styleName;
	}
	public int getIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		IsDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "Style [StyleId=" + StyleId + ", StyleName=" + StyleName + ", IsDeleted=" + IsDeleted + "]";
	}
	
}
