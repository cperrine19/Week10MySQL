package entity;

public class ColorNew {
	private String hexId;
	private String colorName;
	
	public ColorNew(String hexId, String colorName) {
		this.hexId = hexId;
		this.colorName = colorName;
	}
//return hexId
	public String getHexId() {
		return hexId;
	}
	
	public void setHexId(String hexId) {
		this.hexId = hexId;
	}
//return color name
	public String getName() {
		return colorName;
	}

	public void setName(String colorName) {
		this.colorName = colorName;
	}

}
