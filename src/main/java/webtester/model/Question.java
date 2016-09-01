package webtester.model;

import java.io.Serializable;

import webtester.annotation.Column;

public class Question implements Serializable {

	private static final long serialVersionUID = 3277558928948980063L;

	private Long id;
	@Column("id_test")
	private Long idTest;
	@Column("name")
	private String name;
	private transient Test test;

	public Question() {
		super();
	}
	
	public Question(Long idTest, String name){
		super();
		this.idTest = idTest;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdTest() {
		return idTest;
	}

	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", idTest=" + idTest + ", name=" + name
				+ "]";
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	
	
}
