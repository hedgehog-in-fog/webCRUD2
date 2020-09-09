package project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "usersCRUD")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "characte")
	private String character;

	@Column(name = "age")
	private int age;

	public User() {

	}

	public User(String name, String character, int age) {
		this.name = name;
		this.character = character;
		this.age = age;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCharacter() {
		return character;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", character='" + character + '\'' +
				", age=" + age +
				'}';
	}
}
