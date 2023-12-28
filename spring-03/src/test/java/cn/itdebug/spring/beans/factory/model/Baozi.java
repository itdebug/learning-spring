package cn.itdebug.spring.beans.factory.model;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/12/25
 * @描述
 */
public class Baozi {

	private String name;
	private String color;
	private String filing;

	public String description(){
		return "Hi，给我来个大包子";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFiling() {
		return filing;
	}

	public void setFiling(String filing) {
		this.filing = filing;
	}
}
