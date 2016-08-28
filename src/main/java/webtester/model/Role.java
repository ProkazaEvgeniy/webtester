package webtester.model;

import java.sql.Timestamp;

import webtester.annotation.Column;

public class Role {

	private int id;
	@Column("name")
	private String name;
	@Column("created")
	private Timestamp created;

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
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", created=" + created + "]";
	}
	public Object getIdModel(){
		return getId();
	}
	
}
