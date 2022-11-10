package com.solera.example.defectexample.model;
import javax.persistence.*;

@Entity
@Table(name = "Part")
public class PartModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private String name;
	
	public PartModel() {
		
	}
	public PartModel(Long id, String name) {
		
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PartModel [id=" + id + ", name=" + name + "]";
	}

}
