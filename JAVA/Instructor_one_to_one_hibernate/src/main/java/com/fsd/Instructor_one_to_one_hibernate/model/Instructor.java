package com.fsd.Instructor_one_to_one_hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Instructor {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
int id;

@Column(name = "name")
String name;
@Column(name="email")
String email;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "instructor_detail_id")
Instructor_detail instructor_detail;
public Instructor(String name, String email) {
	super();
	this.name = name;
	this.email = email;
	
}
@Override
public String toString() {
	return "Instructor [id=" + id + ", name=" + name + ", email=" + email + ", instructor_detail=" + instructor_detail
			+ "]";
}
public Instructor_detail getInstructor_detail() {
	return instructor_detail;
}
public void setInstructor_detail(Instructor_detail instructor_detail) {
	this.instructor_detail = instructor_detail;
}

}
