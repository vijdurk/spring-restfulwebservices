package com.rest.restfulservices.user;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {
	@Id
	@GeneratedValue
private Integer id;
@Size(min=2, message = "Name should have atleast 2 characters")
private String name;

private int age;

public Integer getId() {
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
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public User(int id, String name, int age) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
}

}
