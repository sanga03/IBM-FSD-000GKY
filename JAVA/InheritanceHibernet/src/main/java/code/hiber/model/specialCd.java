package code.hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class specialCd extends CD {
	@Column(name = "specialEdition")
String specialEdition;

	public specialCd(CD cd,String specialEdition) {
		super(cd.title,cd.artists,cd.cdate);
		this.specialEdition = specialEdition;
	}
	
}
