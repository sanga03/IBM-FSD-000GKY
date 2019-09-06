package code.hiber.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.NoArgsConstructor;


@Entity
@Table(name = "cd")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (discriminatorType = DiscriminatorType.STRING,name = "ctype")
@DiscriminatorValue(value = "Normal CD")
@NoArgsConstructor
public class CD {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
int id;
@Column(name = "title")
String title;
@Column(name="artist")
String artists;
@Column(name="rdate")
Date cdate;

public CD(String title, String artists, Date cdate) {
	super();
	this.title = title;
	this.artists = artists;
	this.cdate = cdate;
}


}
