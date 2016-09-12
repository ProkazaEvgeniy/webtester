package webtester.model;

import webtester.annotation.Column;

public class Role {

	private int id;
	@Column("name")
	private String name;

	public Role(String name) {
		super();
		this.name = name;
	}
	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Role() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getIdModel(){
		return getId();
	}
	
}
