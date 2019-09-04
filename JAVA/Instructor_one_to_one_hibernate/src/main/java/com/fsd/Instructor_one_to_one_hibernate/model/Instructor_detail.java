package com.fsd.Instructor_one_to_one_hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Entity
@Data
@Table(name = "instructor_detail")
public class Instructor_detail {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
int id;
@Column(name="youtube_channel")
String youtube_channel;
@Column(name = "hobby")
String hobby;


public Instructor_detail(String youtube_channel, String hobby) {
	super();
	this.youtube_channel = youtube_channel;
	this.hobby = hobby;
}


@OneToOne(mappedBy="instructor_detail",cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
Instructor instructor;


public Instructor getInstructor() {
	return instructor;
}


public void setInstructor(Instructor instructor) {
	this.instructor = instructor;
}


@Override
public String toString() {
	return "Instructor_detail [id=" + id + ", youtube_channel=" + youtube_channel + ", hobby=" + hobby + ", instructor="
			+ instructor + "]";
}

}
